USE WebSite
GO

DROP TABLE ACCOUNT
GO

DROP TABLE SYSTEMROLE
GO

CREATE TABLE SYSTEMROLE
(
	ROLE_ID	INT	IDENTITY(1,1)	PRIMARY KEY	NOT NULL,
	ROLE_NAME	NVARCHAR(50)	NOT	NULL,
)
GO

CREATE TABLE ACCOUNT
(
	USER_ID INT IDENTITY(1,1) PRIMARY KEY NOT NULL,
	USER_NAME	NVARCHAR(50)	NOT	NULL,
	USER_ACCOUNT VARCHAR(50) UNIQUE NOT NULL,
	USER_PASSWORD VARBINARY(MAX) NOT NULL,
	CREATE_DATE	DATETIME	DEFAULT	GETDATE()	NOT NULL,
	LAST_LOGIN_DATE	DATETIME	NULL,
	ROLE_ID	INT	NOT NULL,
	USER_ENABLE	BIT	NOT	NULL
	CONSTRAINT FK_ACCOUNT_ROLE_ID FOREIGN KEY (ROLE_ID) REFERENCES SYSTEMROLE(ROLE_ID) 
)
GO

INSERT INTO SYSTEMROLE(ROLE_NAME) VALUES (N'管理者'), (N'一般使用者')
GO

INSERT INTO ACCOUNT(USER_NAME,USER_ACCOUNT,USER_PASSWORD,ROLE_ID,USER_ENABLE) 
VALUES ('Mary','Mary',0x31323334,1,1),
	   ('George','George',0x31323334,2,1),
	   ('Peter','Peter',0x31323334,2,0)
GO