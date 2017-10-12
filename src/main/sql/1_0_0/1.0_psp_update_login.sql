


IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'updateLogin') AND type IN (N'P', N'PC'))
  DROP PROCEDURE updateLogin
GO

CREATE PROCEDURE updateLogin
    @username         VARCHAR(70),
    @password_matched BIT,
    @loginAttemptsConfig  INT
AS


  DECLARE @login_attempts INT
  DECLARE @locked_date    DATETIME


  SELECT @login_attempts = loginAttempts
  FROM users u (nolock)
  WHERE   u.email = @username or u.phoneNumber = @username

  IF (@password_matched = 0)
    BEGIN
      UPDATE users
      SET loginAttempts = @login_attempts + 1, failedLoginDate = GETDATE()
     WHERE   email = @username or phoneNumber = @username
      IF (@login_attempts >= @loginAttemptsConfig)
        BEGIN
          UPDATE users
          SET lockedDate = GETDATE()
          WHERE   email = @username or phoneNumber = @username
        END
      RETURN
    END

  IF (@password_matched = 1)
    BEGIN
      UPDATE users
      SET lockedDate = NULL, loginAttempts = 0, lastLogin = GETDATE()
     WHERE   email = @username or phoneNumber = @username
    END

  RETURN @@Error

GO


