
CREATE TABLE TDocumentCenterCategory (
    categoryId int IDENTITY(1,1) NOT NULL,
    upperCategoryId int,
    categoryEnglish varchar(500) NOT NULL UNIQUE,
    categoryZHTW VARCHAR(500) NOT NULL UNIQUE,
    categoryZHCN VARCHAR(500),
	CONSTRAINT PKTDocumentCenterCategory PRIMARY KEY CLUSTERED (categoryId)
);


DROP TABLE TDocumentCenterCategory;

SELECT * FROM TDocumentCenterCategory;