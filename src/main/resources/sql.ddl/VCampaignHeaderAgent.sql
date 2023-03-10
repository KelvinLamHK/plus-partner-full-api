  CREATE VIEW "VCampaignHeaderAgent" ("campaignHeaderId", "campaignCode", "campaignNameEng", "campaignNameZHTW", "campaignNameZHCN", "ifaCaIndicator", "remark", "campaignStartDate", "campaignEndDate", "thumbnailDocID", "createdDate", "updatedDate", "createdBy", "updatedBy", "servAgentCode", "trCode") AS
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
	b.servAgentCode,
	c.trCode
FROM
	TCampaignHeader a
INNER JOIN TCampaignDetail b ON a.campaignHeaderId = b.campaignHeaderId
INNER JOIN TPolicyAssignment c ON b.latestIssuedPolicy = c.policyNumber;

Drop View "VCampaignHeaderAgent"

Select * FROM "VCampaignHeaderAgent"