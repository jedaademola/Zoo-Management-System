

IF EXISTS(SELECT *
          FROM sys.objects
          WHERE object_id = OBJECT_ID(N'getReports') AND type IN (N'P', N'PC'))
  DROP PROCEDURE getReports
GO

CREATE PROCEDURE getReports

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
           FROM PaymentDetails  (nolock)


       ;WITH pg AS
       (
           SELECT id
           FROM PaymentDetails  (nolock)

           ORDER BY id
           OFFSET @page_size * (@page_num -1) ROWS
           FETCH NEXT @page_size ROWS ONLY
       )



       SELECT
                                      a.id
                                      ,amount
                                      ,paymentMethod
                                      ,paymentDate
                                      , ( select firstName + ' ' + lastName from users u where u.id = paidBy ) paidBy
                                      ,description
                                      ,discount

        FROM PaymentDetails  as a (nolock)
        INNER JOIN pg on pg.id = a.id
        ORDER BY pg.id desc


       RETURN @@Error
GO


