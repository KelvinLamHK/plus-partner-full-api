CREATE TABLE TDocument (
    documentId int IDENTITY(1,1) NOT NULL,
    documentName VARCHAR(500) NOT NULL,
    sourcePath VARCHAR(2000) NOT NULL,
    documentStatus VARCHAR(1) NOT NULL,
    documentCategory VARCHAR(200) NOT NULL,
    documentType VARCHAR(200) NOT NULL,
    policyCode VARCHAR(200),
    expiryDate DATETIME,
    effectiveDate DATETIME,
    createdDate DATETIME NOT NULL,
    updatedDate DATETIME NOT NULL,
    createdBy VARCHAR(200) NOT NULL,
    updatedBy VARCHAR(200) NOT NULL,
	CONSTRAINT  PKTDocument PRIMARY KEY CLUSTERED (documentId)
);

DROP TABLE TDocument;

SELECT * FROM TDocument;