

  IF NOT EXISTS(SELECT *
                  FROM sys.objects
                  WHERE object_id = OBJECT_ID(N'emails_to_send') AND type IN (N'U'))

      CREATE TABLE emails_to_send
      (
        id                  BIGINT        IDENTITY (1, 1) PRIMARY KEY,
        sender              VARCHAR (100) NOT NULL,
        recipient           VARCHAR (200) NOT NULL,
        subject             VARCHAR (200) NOT NULL,
        content_type        VARCHAR (100) NOT NULL,
        status              INT,
        created_on          DATETIME,
        content             VARCHAR (7000) NOT NULL
      )
    GO

    CREATE NONCLUSTERED  INDEX IX_emails_to_send
        ON emails_to_send(status);
    GO
