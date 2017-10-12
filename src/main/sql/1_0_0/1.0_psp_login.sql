


IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'loginUser') AND type IN (N'P', N'PC'))
  DROP PROCEDURE loginUser
GO


CREATE PROCEDURE loginUser
    @username varchar(50)
AS
  SET NOCOUNT ON
    DECLARE @password_expired                   BIT = 0
    DECLARE @password_expiration_days_remaining INT = -1

    SELECT @password_expiration_days_remaining = 90 - DATEDIFF(DAY, u.passwordChangedOn, GETDATE())
    FROM users u (nolock)
    WHERE u.email = @username or u.phoneNumber = @username

    IF (@password_expiration_days_remaining >= 0)
     		BEGIN
     		 SET @password_expired = 0
    	   END
       ELSE
     		BEGIN
     		  SET @password_expired = 1
     	    END

      SELECT
               u.*,
               @password_expired                   AS password_expired,
               ISNULL(@password_expiration_days_remaining,-1) AS password_expiration_days_remaining
              FROM users u (nolock)
              WHERE u.email = @username or u.phoneNumber = @username

  RETURN @@Error

GO






IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'loginLock') AND type IN (N'P', N'PC'))
  DROP PROCEDURE loginLock
GO

CREATE PROCEDURE loginLock
	@userId  BIGINT

AS
	SET NOCOUNT ON
	 update users set lockedDate = GETDATE() WHERE id=@userId

RETURN @@Error



GO




IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'updateFailedLogin') AND type IN (N'P', N'PC'))
  DROP PROCEDURE updateFailedLogin
GO

CREATE PROCEDURE updateFailedLogin
	@username  varchar(70)

AS
	 SET NOCOUNT ON

	 DECLARE @userExist BIGINT
	 DECLARE @loginCount BIGINT


	 SELECT @userExist = COUNT(id),@loginCount =loginAttempts  from users
	 WHERE email = @username or phoneNumber = @username
	 group by loginAttempts


	 if (@userExist > 0)
         begin
            update users set failedLoginDate = GETDATE(),loginAttempts = @loginCount + 1
            WHERE email = @username or phoneNumber = @username
         end


RETURN @@Error

GO









IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'loginUnlock') AND type IN (N'P', N'PC'))
  DROP PROCEDURE loginUnlock
GO

CREATE PROCEDURE loginUnlock
	@userId  BIGINT

AS
	SET NOCOUNT ON
	 update users set lockedDate = null, loginAttempts=0
	 WHERE id=@userId

RETURN @@Error

GO





