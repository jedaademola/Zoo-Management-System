




IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'fnColumnExists') AND type IN (N'FN', N'IF', N'TF', N'FS', N'FT') )
  DROP FUNCTION fnColumnExists
GO

CREATE FUNCTION fnColumnExists
(
	 @tableName  varchar(100),
	 @columnName varchar(100)

)
RETURNS int
AS
BEGIN

	    DECLARE @exist int

        IF EXISTS(SELECT * FROM sys.columns
            WHERE Name = @columnName AND OBJECT_ID = OBJECT_ID(@tableName))
            BEGIN
                    set @exist = 1
            END
        ELSE
            BEGIN
                    set @exist = 0
            END

	RETURN @exist

END

GO






IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'users') AND type IN (N'U'))
BEGIN
    CREATE TABLE users
    (
        id                      BIGINT      IDENTITY (1, 1) PRIMARY KEY,
        firstName              VARCHAR(50) NOT NULL,
        lastName             VARCHAR(100) NOT NULL,
        phoneNumber            VARCHAR(20) NOT NULL UNIQUE,
        email                   VARCHAR(70) NOT NULL UNIQUE,
        password                VARCHAR(200)  NOT NULL,
        address                 VARCHAR(500) NULL,
        ssn                     VARCHAR(50) NULL,
        gender                  CHAR  NULL,
        category                 varchar (1),

        active                  INT         NOT NULL DEFAULT 0,
        loginAttempts          BIGINT NOT NULL DEFAULT 0,





        lastLogin              DATETIME NULL,
        lockedDate             DATETIME NULL,
        failedLoginDate       DATETIME NULL,
        accountCreatedOn      DATETIME NOT NULL DEFAULT GETDATE(),
        passwordChangedOn      DATETIME NULL,
        lastUpdatedOn         DATETIME NULL



    )

    CREATE NONCLUSTERED  INDEX IX_users_search ON users (email,phoneNumber);
    PRINT 'User Table created successfully'

END
ELSE
BEGIN
    PRINT 'User table already exist....'
END
GO



INSERT INTO users (firstName,lastName,password,address,gender,phoneNumber,email,category,ssn,active)
      VALUES ('Lukman','Arogundade','ademola2009','Lagos','M','08137729363','lukman.arogundade@gmail.com','E','1283-766-1745',1)
GO



IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'previous_passwords') AND type IN (N'U'))
  CREATE TABLE previous_passwords
  (
    id         BIGINT               IDENTITY (1, 1) PRIMARY KEY,
    password   VARCHAR(100) NOT NULL,
    user_id    BIGINT      NOT NULL REFERENCES users (id)
      ON DELETE CASCADE,
    created_on DATETIME NOT NULL DEFAULT GETDATE()
  )

  CREATE NONCLUSTERED  INDEX IX_previous_passwords ON previous_passwords (user_id);
    PRINT 'previous_passwords Table created successfully'
GO




/*
If dbo.fnColumnExists('users', 'lastUpdatedOn') = 0
            BEGIN
                 ALTER TABLE users

                 ADD lastUpdatedOn   DATETIME NULL
            END

GO

*/




