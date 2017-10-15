



IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'Block') AND type IN (N'U'))
  CREATE TABLE Block
  (
    id         BIGINT               IDENTITY (1, 1) PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    location       VARCHAR(100) NOT NULL

  )

  CREATE NONCLUSTERED  INDEX IX_Block ON Block (id);
    PRINT 'block Table created successfully'
GO



IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'Cell') AND type IN (N'U'))
  CREATE TABLE Cell
  (
    id         BIGINT               IDENTITY (1, 1) PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    blockId      BIGINT    NOT NULL REFERENCES Block (id)
     ON DELETE CASCADE

  )

  CREATE NONCLUSTERED  INDEX IX_Cell ON Cell (id);
    PRINT 'Cell Table created successfully'
GO


IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'Animal') AND type IN (N'U'))
  CREATE TABLE Animal
  (
    id         BIGINT               IDENTITY (1, 1) PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    specy      VARCHAR(100) NOT NULL,
    tag        VARCHAR(100) NOT NULL,
    cellId     BIGINT    NOT NULL REFERENCES Cell (id)
                ON DELETE CASCADE,
    blockId      BIGINT    NOT NULL REFERENCES Block (id)
     ON DELETE CASCADE
     dateOfBirth  date,
     dateOfDeath  date

  )

  CREATE NONCLUSTERED  INDEX IX_Animal ON Animal (id);
    PRINT 'Animal Table created successfully'
GO


IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'Food') AND type IN (N'U'))
  CREATE TABLE Food
  (
    id         BIGINT               IDENTITY (1, 1) PRIMARY KEY,
    name       VARCHAR(100) NOT NULL


  )

  CREATE NONCLUSTERED  INDEX IX_Food ON Food (id);
    PRINT 'Food Table created successfully'
GO



IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'Medicine') AND type IN (N'U'))
  CREATE TABLE Medicine
  (
    id         BIGINT               IDENTITY (1, 1) PRIMARY KEY,
    name       VARCHAR(100) NOT NULL


  )

  CREATE NONCLUSTERED  INDEX IX_Medicine ON Medicine (id);
    PRINT 'Medicine Table created successfully'
GO




IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'Appointment') AND type IN (N'U'))
  CREATE TABLE Appointment
  (
    id         BIGINT               IDENTITY (1, 1) PRIMARY KEY,
    date       VARCHAR(100) NOT NULL,
    numberOfVisitor BIGINT,
    visitorId    BIGINT      NOT NULL REFERENCES users (id)
      ON DELETE CASCADE

  )

  CREATE NONCLUSTERED  INDEX IX_Appointment ON Appointment (id);
    PRINT 'Appointment Table created successfully'
GO



IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'Stock') AND type IN (N'U'))
  CREATE TABLE Stock
  (
    id         BIGINT               IDENTITY (1, 1) PRIMARY KEY,
    price      float,
    quantity   int,
    itemId    BIGINT,
    supplierId    BIGINT      NOT NULL REFERENCES users (id)
      ON DELETE CASCADE,
    category  VARCHAR(100)

  )

  CREATE NONCLUSTERED  INDEX IX_Stock ON Stock (id);
    PRINT 'Stock Table created successfully'
GO



IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'ZooCard') AND type IN (N'U'))
  CREATE TABLE ZooCard
  (
    id         BIGINT               IDENTITY (1, 1) PRIMARY KEY,
    balance      float,
    discount   float,
    amountLimit    float,
    userId    BIGINT      NOT NULL REFERENCES users (id)
      ON DELETE CASCADE

  )

  CREATE NONCLUSTERED  INDEX IX_ZooCard ON ZooCard (id);
    PRINT 'ZooCard Table created successfully'
GO



IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'Hollyday') AND type IN (N'U'))
  CREATE TABLE Hollyday
  (
    id         BIGINT               IDENTITY (1, 1) PRIMARY KEY,
    amount      float,
    name    VARCHAR(100),
    period     VARCHAR(100),
    userId    BIGINT      NOT NULL REFERENCES users (id)
      ON DELETE CASCADE

  )

  CREATE NONCLUSTERED  INDEX IX_ZooCard ON ZooCard (id);
    PRINT 'ZooCard Table created successfully'
GO



IF NOT EXISTS(SELECT *
              FROM sys.objects
              WHERE object_id = OBJECT_ID(N'Payment') AND type IN (N'U'))
  CREATE TABLE Payment
  (
    id         BIGINT               IDENTITY (1, 1) PRIMARY KEY,
    amount      float,
    paymentMethod    VARCHAR(100),
    paymentDate    date,
    paidBy    BIGINT      NOT NULL REFERENCES users (id)
    description    VARCHAR(100),
    discount  float

  )

  CREATE NONCLUSTERED  INDEX IX_Payment ON Payment (id);
    PRINT 'Payment Table created successfully'
GO



