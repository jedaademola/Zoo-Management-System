


IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'queueEmail') AND type IN (N'P', N'PC'))
  DROP PROCEDURE queueEmail
GO

CREATE PROCEDURE queueEmail

        @sender              VARCHAR (100),
        @recipient           VARCHAR (200),
        @subject             VARCHAR (200),
        @contentType        VARCHAR (100),
        @content             VARCHAR (7000)
AS

  INSERT INTO emails_to_send
  (
      sender,
      recipient,
      subject,
      content_type,
      status,
      created_on,
      content
  )
  VALUES
    (
     @sender,
     @recipient ,
     @subject ,
     @contentType,
     0,
     GETDATE(),
     @content
    )

  RETURN @@Error

GO





IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'getEmailsToSend') AND type IN (N'P', N'PC'))
  DROP PROCEDURE getEmailsToSend
GO

CREATE PROCEDURE getEmailsToSend
AS

  DECLARE @tmpTable TABLE
  (
    id                  BIGINT ,
    sender              VARCHAR (100) ,
    recipient           VARCHAR (200) ,
    subject             VARCHAR (200) ,
    content_type        VARCHAR (100) ,
    status              INT,
    created_on          DATETIME,
    content             VARCHAR (7000)
  )

  BEGIN  TRANSACTION
    INSERT INTO @tmpTable SELECT TOP 100 * from emails_to_send WHERE status = 0 ORDER by id

    UPDATE emails_to_send
     SET status = 1
     FROM (SELECT id from @tmpTable) AS tb
     WHERE emails_to_send.id = tb.id

     SELECT * from @tmpTable

  COMMIT TRANSACTION

GO






IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'updateEmailStatus') AND type IN (N'P', N'PC'))
  DROP PROCEDURE updateEmailStatus
GO

CREATE PROCEDURE updateEmailStatus
  @id BIGINT,
  @status INT
AS
  IF(@status = 0)
  BEGIN
    UPDATE emails_to_send
      SET status = 0
      WHERE id = @id
  END
  ELSE
  BEGIN
    DELETE emails_to_send WHERE id = @id
  END

GO




