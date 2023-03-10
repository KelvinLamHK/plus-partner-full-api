CREATE TABLE TDocumentCenter (
    documentCenterId int IDENTITY(1,1) NOT NULL,
    titleEnglish VARCHAR(500) NOT NULL,
    titleTraditionalChinese VARCHAR(500) NOT NULL,
    titleSimplifiedChinese VARCHAR(500),
    documentStatus VARCHAR(10) NOT NULL,
    level1CategoryId int NOT NULL,
    level2CategoryId int,
    descriptionEnglish VARCHAR(500) NOT NULL,
    descriptionTraditionalChinese VARCHAR(500) NOT NULL,
    descriptionSimplifiedChinese VARCHAR(500),
    file1Id int NOT NULL,
    file2Id int,
    file3Id int,
	effectiveDateFrom DATETIME ,
	effectiveDateTo DATETIME ,
	isPin VARCHAR(10),
    isPromo VARCHAR(10),
    ifaCaIndicator VARCHAR(200) NOT NULL,
    createdDate DATETIME  NOT NULL,
    updatedDate DATETIME  NOT NULL,
    createdBy VARCHAR(200) NOT NULL,
    updatedBy VARCHAR(200) NOT NULL,
	CONSTRAINT PKTDocumentCenter PRIMARY KEY CLUSTERED (documentCenterId)
);

DROP TABLE TDocumentCenter;

SELECT * FROM TDocumentCenter;