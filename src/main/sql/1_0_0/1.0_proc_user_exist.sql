




IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'isUserExists') AND type IN (N'P', N'PC'))
  DROP PROCEDURE isUserExists
GO


CREATE PROCEDURE isUserExists
	@email    VARCHAR(70),
	@phoneNumber  VARCHAR(20)

AS
	SET NOCOUNT ON


	 SELECT * FROM users (nolock) WHERE email= @email or phoneNumber = @phoneNumber


	RETURN @@Error


GO




