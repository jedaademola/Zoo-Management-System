





IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'manageAnimal') AND type IN (N'P', N'PC'))
  DROP PROCEDURE manageAnimal
GO

CREATE PROCEDURE manageAnimal
    @id  BIGINT = NULL OUTPUT,
    @name       VARCHAR(100) ,
    @specy      VARCHAR(100) ,
    @tag        VARCHAR(100) ,
    @cellId     BIGINT    ,
    @blockId      BIGINT    ,
    @dateOfBirth  date,
    @dateOfDeath  date
AS

IF NOT EXISTS(SELECT id FROM Animal (nolock) where ( name =@name and blockId = @blockId ) or  id = @id )
           BEGIN
                INSERT  into Animal
                (
                     name      ,
                     specy       ,
                     tag        ,
                     cellId       ,
                     blockId          ,
                     dateOfBirth  ,
                     dateOfDeath
                 )
                      values
                (
                              @name      ,
                              @specy       ,
                              @tag        ,
                              @cellId       ,
                              @blockId          ,
                              @dateOfBirth  ,
                              @dateOfDeath
                )

				   SELECT @id = SCOPE_IDENTITY();
           END
           ELSE
             BEGIN
                 update Animal
                 SET
                  name      =@name,
                  specy     =@specy  ,
                  tag      =@tag  ,
                  cellId      =@cellId ,
                  blockId    =@blockId      ,
                  dateOfBirth  =@dateOfBirth,
                  dateOfDeath =@dateOfDeath
                 WHERE  id =@id


            SET @id = @@ROWCOUNT ;

          END

 SELECT @id ;

 RETURN @@Error

GO






IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'getAnimals') AND type IN (N'P', N'PC'))
  DROP PROCEDURE getAnimals
GO

CREATE PROCEDURE getAnimals

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
           FROM Animal  (nolock)


       ;WITH pg AS
       (
           SELECT id
           FROM Animal  (nolock)

           ORDER BY id
           OFFSET @page_size * (@page_num -1) ROWS
           FETCH NEXT @page_size ROWS ONLY
       )

       SELECT
                                      a.id,
                                       name      ,
                                       specy       ,
                                       tag        ,
                                      ( select name from Cell c where c.id = cellId ) cellName ,
                                      ( select name from Block b where b.id = blockId ) blockName ,
                                       dateOfBirth  ,
                                       dateOfDeath,
                                       cellId,
                                       blockId

        FROM Animal  as a (nolock)
        INNER JOIN pg on pg.id = a.id
        ORDER BY pg.id desc


       RETURN @@Error
GO



s



