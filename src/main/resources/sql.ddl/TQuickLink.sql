CREATE TABLE TQuickLink (
    linkId int IDENTITY(1,1) NOT NULL,
    linkEngName VARCHAR(500) ,
    linkChiName VARCHAR(500) ,
    linkSimName VARCHAR(500),
    url VARCHAR(2000),
	CONSTRAINT  PKTQuickLink PRIMARY KEY CLUSTERED (linkId)
);

DROP TABLE TQuickLink;

SELECT * FROM TQuickLink;
