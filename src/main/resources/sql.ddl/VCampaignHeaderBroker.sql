  CREATE VIEW "VCampaignHeaderBroker" ("campaignHeaderId", "campaignCode", "campaignNameEng", "campaignNameZHTW", "campaignNameZHCN", "ifaCaIndicator", "remark", "campaignStartDate", "campaignEndDate", "thumbnailDocID", "createdDate", "updatedDate", "createdBy", "updatedBy", "servAgentCode") AS
  SELECT
	DISTINCT
	a.campaignHeaderId ,
	a.campaignCode ,
	a.campaignNameEng ,
	a.campaignNameZHTW ,
	a.campaignNameZHCN ,
	a.ifaCaIndicator ,
	a.remark ,
	a.campaignStartDate,
	a.campaignEndDate,
	a.thumbnailDocID ,
	a.createdDate,
	a.updatedDate,
	a.createdBy,
	a.updatedBy,
	b.servAgentCode
FROM
	TCampaignHeader a
INNER JOIN TCampaignDetail b ON a.campaignHeaderId = b.campaignHeaderId
LEFT JOIN TPolicyAssignment c ON b.latestIssuedPolicy = c.policyNumber;

Drop View "VCampaignHeaderBroker"

Select * FROM "VCampaignHeaderBroker"