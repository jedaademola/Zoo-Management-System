



IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'manageCell') AND type IN (N'P', N'PC'))
  DROP PROCEDURE manageCell
GO

CREATE PROCEDURE manageCell
    @id  BIGINT = NULL OUTPUT,
    @name varchar(100) ,
    @blockId BIGINT
AS

IF NOT EXISTS(SELECT id FROM Cell (nolock) where ( name =@name and blockId = @blockId ) or  id = @id )
           BEGIN
                INSERT  into Cell
                (
                       name,
                       blockId

                 )
                      values
                (
                          @name,
                          @blockId
                )

				   SELECT @id = SCOPE_IDENTITY();
           END
           ELSE
             BEGIN
                 update Cell
                 SET
                 name =@name,blockId=@blockId
                 WHERE  id =@id


            SET @id = @@ROWCOUNT ;

          END

 SELECT @id ;

 RETURN @@Error

GO




IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'manageBlock') AND type IN (N'P', N'PC'))
  DROP PROCEDURE manageBlock
GO

CREATE PROCEDURE manageBlock
    @id  BIGINT = NULL OUTPUT,
    @name varchar(100) ,
    @location varchar(100)
AS

IF NOT EXISTS(SELECT id FROM Block (nolock) where (name =@name and location = @location) or  id = @id )
           BEGIN
                INSERT  into Block
                (
                       name,
                       location

                 )
                      values
                (
                          @name,
                          @location
                )

				   SELECT @id = SCOPE_IDENTITY();
           END
           ELSE
             BEGIN
                 update Block
                 SET
                 name =@name,location=@location
                 WHERE  id =@id


            SET @id = @@ROWCOUNT ;

          END

 SELECT @id ;

 RETURN @@Error

GO



IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'getBlocks') AND type IN (N'P', N'PC'))
  DROP PROCEDURE getBlocks
GO

CREATE PROCEDURE getBlocks

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
           FROM Block  (nolock)

           ORDER BY id
           OFFSET @page_size * (@page_num -1) ROWS
           FETCH NEXT @page_size ROWS ONLY
       )

       SELECT
                                      a.id
                                      ,name
                                      ,location

        FROM Block  as a (nolock)
        INNER JOIN pg on pg.id = a.id
        ORDER BY pg.id desc


       RETURN @@Error
GO




IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'getCells') AND type IN (N'P', N'PC'))
  DROP PROCEDURE getCells
GO

CREATE PROCEDURE getCells

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
           FROM Cell  (nolock)


       ;WITH pg AS
       (
           SELECT id
           FROM Cell  (nolock)

           ORDER BY id
           OFFSET @page_size * (@page_num -1) ROWS
           FETCH NEXT @page_size ROWS ONLY
       )

       SELECT
                                      a.id
                                      ,name
                                      ,( select name from Block b where b.id = blockId ) blockName

        FROM Cell  as a (nolock)
        INNER JOIN pg on pg.id = a.id
        ORDER BY pg.id desc


       RETURN @@Error
GO








