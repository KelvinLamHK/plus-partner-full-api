CREATE TABLE TCampaignHeader(
    campaignHeaderId int IDENTITY(1,1) NOT NULL,
    campaignCode VARCHAR(200) NOT NULL,
    campaignNameEng VARCHAR(2000) NOT NULL,
    campaignNameZHTW VARCHAR(2000),
    campaignNameZHCN VARCHAR(2000),
    ifaCaIndicator VARCHAR(200) NOT NULL,
    remark VARCHAR(2000),
    campaignStartDate DATETIME  NOT NULL,
    campaignEndDate DATETIME  NOT NULL,
    thumbnailDocID int,
    createdDate DATETIME  NOT NULL,
    updatedDate DATETIME  NOT NULL,
    createdBy VARCHAR(200) NOT NULL,
    updatedBy VARCHAR(200) NOT NULL,
	CONSTRAINT PKTCampaignHeader PRIMARY KEY CLUSTERED (campaignHeaderId)
);

DROP TABLE TCampaignHeader;

SELECT * FROM TCampaignHeader;