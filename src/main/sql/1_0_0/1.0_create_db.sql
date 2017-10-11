



USE master
GO


IF NOT EXISTS(SELECT
                name
              FROM sysdatabases
              WHERE name = N'zoo_system_db')
  BEGIN
    CREATE DATABASE zoo_system_db

	PRINT 'zoo_system_db DB created successfully'
  END
GO


USE zoo_system_db
GO


IF NOT EXISTS(SELECT
                *
              FROM sys.server_principals
              WHERE name = N'zoo_system_db')
  BEGIN
    CREATE LOGIN zoo_system_db WITH PASSWORD = N'Password1$', DEFAULT_DATABASE = zoo_system_db, DEFAULT_LANGUAGE =[us_english], CHECK_EXPIRATION = OFF, CHECK_POLICY = OFF

	PRINT 'Password created to zoo_system_db DB object....'


	 CREATE ROLE zoo_system_db_app
        CREATE USER zoo_system_db FOR LOGIN zoo_system_db
        ALTER ROLE zoo_system_db_app ADD MEMBER zoo_system_db

        GRANT CREATE PROCEDURE to zoo_system_db_app
        GRANT EXECUTE ON SCHEMA::dbo TO zoo_system_db_app


  END
GO




