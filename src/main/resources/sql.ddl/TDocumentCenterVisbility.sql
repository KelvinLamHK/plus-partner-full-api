CREATE TABLE TDocumentCenterVisibility (
    documentCenterVisibilityId int IDENTITY(1,1) NOT NULL,
    documentCenterId int NOT NULL,
    agentCode VARCHAR(200),
    createdDate DATETIME  NOT NULL,
    updatedDate DATETIME  NOT NULL,
    createdBy VARCHAR(200) NOT NULL,
    updatedBy VARCHAR(200) NOT NULL,
	CONSTRAINT PKTDocumentCenterVisibility PRIMARY KEY CLUSTERED (documentCenterVisibilityId)
);


DROP TABLE TDocumentCenterVisibility;

SELECT * FROM TDocumentCenterVisibility;