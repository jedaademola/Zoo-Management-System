



IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'addHolidayRequest') AND type IN (N'P', N'PC'))
  DROP PROCEDURE addHolidayRequest
GO

CREATE PROCEDURE addHolidayRequest
    @id  BIGINT = NULL OUTPUT,
    @amount      float,
    @paymentMethod    VARCHAR(100),
    @paidBy    BIGINT,
    @description    VARCHAR(100),
    @discount float
AS

IF NOT EXISTS(SELECT id FROM PaymentDetails (nolock) where id = @id )
           BEGIN
                INSERT  into PaymentDetails
                (
                        amount      ,
                        paymentMethod   ,
                        paidBy,
                        description,
                        discount

                 )
                      values
                (
                            @amount      ,
                            @paymentMethod  ,
                            @paidBy   ,
                            @description  ,
                            @discount
                )

				   SELECT @id = SCOPE_IDENTITY();
           END
           ELSE
             BEGIN
                 update PaymentDetails
                 SET
                        amount   =@amount   ,
                        paymentMethod  =@paymentMethod ,
                        paidBy  = @paidBy,
                        description = @description,
                        discount = @discount,
                        paymentDate = GETDATE()
                 WHERE  id =@id


            SET @id = @@ROWCOUNT ;

          END

 SELECT @id ;

 RETURN @@Error

GO


