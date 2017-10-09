



USE master
GO


IF NOT EXISTS(SELECT
                name
              FROM sysdatabases
              WHERE name = N'internet_banking')
  BEGIN
    CREATE DATABASE internet_banking

	PRINT 'internet banking DB created successfully'
  END
GO


USE internet_banking
GO


IF NOT EXISTS(SELECT
                *
              FROM sys.server_principals
              WHERE name = N'internet_banking')
  BEGIN
    CREATE LOGIN internet_banking WITH PASSWORD = N'Password1$', DEFAULT_DATABASE = internet_banking, DEFAULT_LANGUAGE =[us_english], CHECK_EXPIRATION = OFF, CHECK_POLICY = OFF

	PRINT 'Password created to internet banking DB object....'


	 CREATE ROLE internet_banking_app
        CREATE USER internet_banking FOR LOGIN internet_banking
        ALTER ROLE internet_banking_app ADD MEMBER internet_banking

        GRANT CREATE PROCEDURE to internet_banking_app
        GRANT EXECUTE ON SCHEMA::dbo TO internet_banking_app


  END
GO




