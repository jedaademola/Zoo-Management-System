/*    ==Scripting Parameters==

    Source Server Version : SQL Server 2017 (14.0.1000)
    Source Database Engine Edition : Microsoft SQL Server Express Edition
    Source Database Engine Type : Standalone SQL Server

    Target Server Version : SQL Server 2017
    Target Database Engine Edition : Microsoft SQL Server Standard Edition
    Target Database Engine Type : Standalone SQL Server
*/



USE [zoo_system_db]
GO
SET IDENTITY_INSERT [dbo].[users] ON
GO
INSERT [dbo].[users] ([id], [firstName], [lastName], [phoneNumber], [email], [password], [address], [ssn], [gender], [category], [active], [loginAttempts], [lastLogin], [lockedDate], [failedLoginDate], [accountCreatedOn], [passwordChangedOn], [lastUpdatedOn]) VALUES (1, N'Lukman', N'Arogundade', N'08137729363', N'lukman.arogundade@gmail.com', N'ademola2009', N'Lagos', N'1283-766-1745', N'M', N'E', 1, 0, NULL, NULL, NULL, CAST(N'2017-10-11T18:12:13.197' AS DateTime), NULL, NULL)
GO
INSERT [dbo].[users] ([id], [firstName], [lastName], [phoneNumber], [email], [password], [address], [ssn], [gender], [category], [active], [loginAttempts], [lastLogin], [lockedDate], [failedLoginDate], [accountCreatedOn], [passwordChangedOn], [lastUpdatedOn]) VALUES (2, N'Bob', N'Marley', N'08059396317', N'ademola@gmail.com', N'$2a$05$4humLRFDpidXRsFMGHx.R.no3XCHFINtC9ix0rzdd71g33gOlm/DC', N'100 NORTH 4TH STREET, FAIRFIELD, IA', N'455-789-4888', N'M', N'S', 1, 0, NULL, NULL, NULL, CAST(N'2017-10-11T20:32:25.287' AS DateTime), NULL, NULL)
GO
INSERT [dbo].[users] ([id], [firstName], [lastName], [phoneNumber], [email], [password], [address], [ssn], [gender], [category], [active], [loginAttempts], [lastLogin], [lockedDate], [failedLoginDate], [accountCreatedOn], [passwordChangedOn], [lastUpdatedOn]) VALUES (3, N'Stanley', N'Julien', N'08059396318', N'stanleyjulien@gmail.com', N'$2a$05$HhV.MtiEjIWG50XDTnk3eeFuEqGZ0hJXLsEdnGZr81s8Z8imJgiFW', N'100 NORTH 4TH STREET, FAIRFIELD, IA', N'', N'M', N'E', 1, 0, CAST(N'2017-10-15T15:50:48.410' AS DateTime), NULL, NULL, CAST(N'2017-10-11T21:19:17.337' AS DateTime), NULL, NULL)
GO
SET IDENTITY_INSERT [dbo].[users] OFF
GO
SET IDENTITY_INSERT [dbo].[previous_passwords] ON
GO
INSERT [dbo].[previous_passwords] ([id], [password], [user_id], [created_on]) VALUES (1, N'$2a$05$4humLRFDpidXRsFMGHx.R.no3XCHFINtC9ix0rzdd71g33gOlm/DC', 2, CAST(N'2017-10-11T20:32:25.640' AS DateTime))
GO
INSERT [dbo].[previous_passwords] ([id], [password], [user_id], [created_on]) VALUES (2, N'$2a$05$HhV.MtiEjIWG50XDTnk3eeFuEqGZ0hJXLsEdnGZr81s8Z8imJgiFW', 3, CAST(N'2017-10-11T21:19:17.443' AS DateTime))
GO
SET IDENTITY_INSERT [dbo].[previous_passwords] OFF
GO
SET IDENTITY_INSERT [dbo].[Block] ON
GO
INSERT [dbo].[Block] ([id], [name], [location]) VALUES (1, N'Lukman', N'East')
GO
INSERT [dbo].[Block] ([id], [name], [location]) VALUES (2, N'Stanley', N'South')
GO
SET IDENTITY_INSERT [dbo].[Block] OFF
GO
SET IDENTITY_INSERT [dbo].[Cell] ON
GO
INSERT [dbo].[Cell] ([id], [name], [blockId]) VALUES (2, N'Cell1', 1)
GO
INSERT [dbo].[Cell] ([id], [name], [blockId]) VALUES (3, N'Cell2', 2)
GO
INSERT [dbo].[Cell] ([id], [name], [blockId]) VALUES (4, N'Cell2', 1)
GO
SET IDENTITY_INSERT [dbo].[Cell] OFF
GO
SET IDENTITY_INSERT [dbo].[Animal] ON
GO
INSERT [dbo].[Animal] ([id], [name], [specy], [tag], [cellId], [blockId], [dateOfBirth], [dateOfDeath]) VALUES (1, N'Animla lutag', N'Animla lutag ta', N'Animla lutag 2', 2, 1, NULL, NULL)
GO
SET IDENTITY_INSERT [dbo].[Animal] OFF
GO
SET IDENTITY_INSERT [dbo].[Food] ON
GO
INSERT [dbo].[Food] ([id], [name]) VALUES (1, N'APPLE')
GO
INSERT [dbo].[Food] ([id], [name]) VALUES (2, N'APPLE33')
GO
SET IDENTITY_INSERT [dbo].[Food] OFF
GO
