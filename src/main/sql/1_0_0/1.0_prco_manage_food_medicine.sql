



IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'manageFood') AND type IN (N'P', N'PC'))
  DROP PROCEDURE manageFood
GO

CREATE PROCEDURE manageFood
    @id  BIGINT = NULL OUTPUT,
    @name varchar(100)
AS

IF NOT EXISTS(SELECT id FROM Food (nolock) where name =@name or id = @id )
           BEGIN
                INSERT  into Food
                (
                       name

                 )
                      values
                (
                          @name
                )

				   SELECT @id = SCOPE_IDENTITY();
           END
           ELSE
             BEGIN
                 update Food
                 SET
                 name =@name
                 WHERE  id =@id


            SET @id = @@ROWCOUNT ;

          END

 SELECT @id ;

 RETURN @@Error

GO




IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'manageMedicine') AND type IN (N'P', N'PC'))
  DROP PROCEDURE manageMedicine
GO

CREATE PROCEDURE manageMedicine
    @id  BIGINT = NULL OUTPUT,
    @name varchar(100)
AS

IF NOT EXISTS(SELECT id FROM Medicine (nolock) where name =@name or id = @id )
           BEGIN
                INSERT  into Medicine
                (
                       name

                 )
                      values
                (
                          @name
                )

				   SELECT @id = SCOPE_IDENTITY();
           END
           ELSE
             BEGIN
                 update Medicine
                 SET
                 name =@name
                 WHERE  id =@id


            SET @id = @@ROWCOUNT ;

          END

 SELECT @id ;

 RETURN @@Error

GO



IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'getFoods') AND type IN (N'P', N'PC'))
  DROP PROCEDURE getFoods
GO

CREATE PROCEDURE getFoods

           @page_num  INT = 1,
           @page_size INT = 100
   AS

    SET NOCOUNT ON



       SET @page_num = ABS(@page_num)
       SET @page_size = ABS(@page_size)
       IF @page_num < 1
         SET @page_num = 1
       IF @page_size < 1
         SET @page_size = 1

       SELECT COUNT(*) AS cnt
           FROM Block  (nolock)


       ;WITH pg AS
       (
           SELECT id
           FROM Food  (nolock)

           ORDER BY id
           OFFSET @page_size * (@page_num -1) ROWS
           FETCH NEXT @page_size ROWS ONLY
       )

       SELECT
                                      a.id
                                      ,name


        FROM Food  as a (nolock)
        INNER JOIN pg on pg.id = a.id
        ORDER BY pg.id desc


       RETURN @@Error
GO




IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'getMedicines') AND type IN (N'P', N'PC'))
  DROP PROCEDURE getMedicines
GO

CREATE PROCEDURE getMedicines

           @page_num  INT = 1,
           @page_size INT = 100
   AS

    SET NOCOUNT ON



       SET @page_num = ABS(@page_num)
       SET @page_size = ABS(@page_size)
       IF @page_num < 1
         SET @page_num = 1
       IF @page_size < 1
         SET @page_size = 1

       SELECT COUNT(*) AS cnt
           FROM Medicine  (nolock)


       ;WITH pg AS
       (
           SELECT id
           FROM Medicine  (nolock)

           ORDER BY id
           OFFSET @page_size * (@page_num -1) ROWS
           FETCH NEXT @page_size ROWS ONLY
       )

       SELECT
                                      a.id
                                      ,name


        FROM Medicine  as a (nolock)
        INNER JOIN pg on pg.id = a.id
        ORDER BY pg.id desc


       RETURN @@Error
GO








