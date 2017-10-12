


IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'createUser') AND type IN (N'P', N'PC'))
  DROP PROCEDURE createUser

GO

CREATE PROCEDURE createUser
        @id         BIGINT OUTPUT,
        @email      VARCHAR(70) ,
        @password   VARCHAR(100),
        @firstName   VARCHAR(50),
        @lastName  VARCHAR(100),
        @phoneNumber  VARCHAR(20) ,
        @gender     varchar(1),
        @address    VARCHAR(500),
        @category    varchar (1),
        @ssn  varchar(50),
        @createdBy  BIGINT

    AS

      BEGIN TRANSACTION

      INSERT INTO users (firstName,lastName,password,address,gender,phoneNumber,email,category,ssn,active)
      VALUES (@firstName,@lastName,@password,@address,@gender,@phoneNumber,@email,@category,@ssn,1)

      IF (@@ERROR <> 0)
        BEGIN
          ROLLBACK TRANSACTION
          RETURN @@Error
        END

      SELECT @id = SCOPE_IDENTITY();

      INSERT INTO previous_passwords (password, user_id) VALUES (@password, @id)

      IF (@@ERROR <> 0)
        BEGIN
          ROLLBACK TRANSACTION
          RETURN @@Error
        END
      COMMIT TRANSACTION

      SELECT @id ;

      RETURN @@Error

GO











