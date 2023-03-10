CREATE VIEW VDocumentCenter AS
SELECT
	a.documentCenterId,
    a.titleEnglish,
    a.titleTraditionalChinese,
    a.titleSimplifiedChinese,
    a.documentStatus ,
    a.level1CategoryId ,
    a.level2CategoryId ,
    a.descriptionEnglish ,
    a.descriptionTraditionalChinese ,
    a.descriptionSimplifiedChinese ,
    a.file1Id ,
    a.file2Id ,
    a.file3Id ,
	a.effectiveDateFrom ,
	a.effectiveDateTo ,
	a.isPin ,
    a.isPromo ,
    a.ifaCaIndicator ,
    a.createdDate ,
    a.updatedDate ,
    a.createdBy ,
    a.updatedBy,
	f1.documentName as file1Name,
	f2.documentName as file2Name,
	f3.documentName as file3Name
FROM TDocumentCenter a
LEFT JOIN TDocument f1 on a.file1Id = f1.documentId
LEFT JOIN TDocument f2 on a.file2Id = f2.documentId
LEFT JOIN TDocument f3 on a.file3Id = f3.documentId

