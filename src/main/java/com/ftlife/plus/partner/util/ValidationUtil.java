package com.ftlife.plus.partner.util;

import com.ftlife.plus.partner.parameter.*;
import com.ftlife.plus.partner.parameter.RequestParameter;

import java.math.BigDecimal;

public class ValidationUtil {

	static String dateFormatRegex = "([0-9]{4})-([0-9]{2})-([0-9]{2})";

	public static String validateUserParameter(RequestParameter requestParameter) {

		if (requestParameter.getUserParameter() == null) {
			return "missing userParameter";
		}
		UserParameter userParameter = requestParameter.getUserParameter();
		if (userParameter.getName() == null) {
			return "missing userParameter.name";
		}
		if (userParameter.getLoginName() == null) {
			return "missing userParameter.loginName";
		}

		if (userParameter.getRole() == null) {
			return "missing userParameter.role";
		}
		return null;
	}

	public static String validateCampaignHeaderParameter(RequestParameter requestParameter) {

		if (requestParameter.getCampaignHeaderParameter() == null) {
			return "missing campaignHeaderParameter";
		}

		CampaignHeaderParameter campaignHeaderParameter = requestParameter.getCampaignHeaderParameter();

		
		if (campaignHeaderParameter.getCampaignHeaderId() != null) {
			String check = campaignHeaderParameter.getCampaignHeaderId();
			try {
				Long.parseLong(check);
			} catch (NumberFormatException nfe) {
				return "campaignHeaderParameter.campaignHeaderId: incorrect format to a numeric value";
			}
		}

		if (campaignHeaderParameter.getCampaignCode() == null) {
			return "missing campaignHeaderParameter.campaignCode";
		}

		if (campaignHeaderParameter.getCampaignNameEng() == null) {
			return "missing campaignHeaderParameter.campaignNameEng";
		}


		if (campaignHeaderParameter.getIfaCaIndicator() == null) {
			return "missing campaignHeaderParameter.ifaCaIndicator";
		}


		if (campaignHeaderParameter.getThumbnailDocID() != null) {
			try {
				Long.parseLong(campaignHeaderParameter.getThumbnailDocID());
			} catch (NumberFormatException nfe) {
				return "campaignHeaderParameter.thumbnailDocID: incorrect format to a numeric value";
			}
		}

		if (campaignHeaderParameter.getCampaignStartDate() == null) {
			return "missing campaignHeaderParameter.campaignStartDate";
		} else {
			if (!campaignHeaderParameter.getCampaignStartDate().matches(dateFormatRegex)) {
				return "campaignHeaderParameter.campaignStartDate: Date format not match YYYY-MM-DD";
			}
		}

		if (campaignHeaderParameter.getCampaignEndDate() == null) {
			return "missing campaignHeaderParameter.campaignEndDate";
		} else {
			if (!campaignHeaderParameter.getCampaignEndDate().matches(dateFormatRegex)) {
				return "campaignHeaderParameter.campaignEndDate: Date format not match YYYY-MM-DD";
			}
		}

		return null;
	}

	public static String validateCampaignDetailParameter(RequestParameter requestParameter) {

		if (requestParameter.getCampaignDetailParameter() == null) {
			return "missing campaignDetailParameter";
		}
		CampaignDetailParameter campaignDetailParameter = requestParameter.getCampaignDetailParameter();
		if (campaignDetailParameter.getCampaignDetailId() != null) {
			String check = campaignDetailParameter.getCampaignDetailId();
			try {
				Long.parseLong(check);
				return null;
			} catch (NumberFormatException nfe) {
				return "campaignDetailParameter.CampaignDetailId: incorrect format to a numeric value";
			}
		}

		if (campaignDetailParameter.getCampaignHeaderId() != null) {
			String check = campaignDetailParameter.getCampaignHeaderId();
			try {
				Long.parseLong(check);
				return null;
			} catch (NumberFormatException nfe) {
				return "campaignDetailParameter.CampaignHeaderId: incorrect format to a numeric value";
			}
		}

		if (campaignDetailParameter.getPartyId() != null) {
			String check = campaignDetailParameter.getPartyId();
			try {
				Integer.parseInt(check);
				return null;
			} catch (NumberFormatException nfe) {
				return "campaignDetailParameter.PartyId: incorrect format to a numeric value";
			}
		}

		if (campaignDetailParameter.getLatestPolicyIssueDateFrom() != null) {
			if (!campaignDetailParameter.getLatestPolicyIssueDateFrom().matches(dateFormatRegex)) {
				return "campaignDetailParameter.latestPolicyIssueDateFrom: Date format not match YYYY-MM-DD";
			}
		}
		if (campaignDetailParameter.getLatestPolicyIssueDateTo() != null && !campaignDetailParameter.getLatestPolicyIssueDateTo().matches(dateFormatRegex)) {
				return "campaignDetailParameter.latestPolicyIssueDateTo: Date format not match YYYY-MM-DD";
		}

		if (campaignDetailParameter.getFirstPolicyIssueDateFrom() != null
			&&
				!campaignDetailParameter.getFirstPolicyIssueDateFrom().matches(dateFormatRegex))
		{
			return "campaignDetailParameter.firstPolicyIssueDateFrom: Date format not match YYYY-MM-DD";
		}


		if (campaignDetailParameter.getFirstPolicyIssueDateTo() != null && !campaignDetailParameter.getFirstPolicyIssueDateTo().matches(dateFormatRegex)) {
				return "campaignDetailParameter.firstPolicyIssueDateTo: Date format not match YYYY-MM-DD";
			}


		if (campaignDetailParameter.getNoOfInForcePolicy() != null) {
			String check = campaignDetailParameter.getNoOfInForcePolicy();
			try {
				Integer.parseInt(check);
				return null;
			} catch (NumberFormatException nfe) {
				return "campaignDetailParameter.NoOfInForcePolicy: incorrect format to a numeric value";
			}
		}

		if (campaignDetailParameter.getLastYearPremium() != null) {
			String check = campaignDetailParameter.getLastYearPremium();
			try {
				BigDecimal.valueOf(Double.valueOf(check));
				return null;
			} catch (NumberFormatException nfe) {
				return "campaignDetailParameter.LastYearPremium: incorrect format to a numeric value";
			}
		}

		if (campaignDetailParameter.getThisYearPremium() != null) {
			String check = campaignDetailParameter.getThisYearPremium();
			try {
				BigDecimal.valueOf(Double.valueOf(check));
				return null;
			} catch (NumberFormatException nfe) {
				return "campaignDetailParameter.ThisYearPremium: incorrect format to a numeric value";
			}
		}

		if (campaignDetailParameter.getPicsIndicatorDateFrom() != null && !campaignDetailParameter.getPicsIndicatorDateFrom().matches(dateFormatRegex)) {
				return "campaignDetailParameter.picsIndicatorDateFrom: Date format not match YYYY-MM-DD";
			}


		if (campaignDetailParameter.getPicsIndicatorDateTo() != null && !campaignDetailParameter.getPicsIndicatorDateTo().matches(dateFormatRegex)) {
				return "campaignDetailParameter.picsIndicatorDateTo: Date format not match YYYY-MM-DD";
			}


		if (campaignDetailParameter.getDirectMarketingFtl() != null) {
			return null;
		}

		if (campaignDetailParameter.getDirectMarketingFtlDateFrom() != null && !campaignDetailParameter.getDirectMarketingFtlDateFrom().matches(dateFormatRegex)) {
				return "campaignDetailParameter.directMarketingFtlDateFrom: Date format not match YYYY-MM-DD";
			}


		if (campaignDetailParameter.getDirectMarketingFtlDateTo() != null && !campaignDetailParameter.getDirectMarketingFtlDateTo().matches(dateFormatRegex)) {
				return "campaignDetailParameter.directMarketingFtlDateTo: Date format not match YYYY-MM-DD";
			}


		if (campaignDetailParameter.getDirectMarketingNwg() != null) {
			return null;
		}

		if (campaignDetailParameter.getDirectMarketingNwgDateFrom() != null && !campaignDetailParameter.getDirectMarketingNwgDateFrom().matches(dateFormatRegex)) {
				return "campaignDetailParameter.directMarketingNwgDateFrom: Date format not match YYYY-MM-DD";
			}


		if (campaignDetailParameter.getDirectMarketingNwgDateTo() != null && !campaignDetailParameter.getDirectMarketingNwgDateTo().matches(dateFormatRegex)) {
				return "campaignDetailParameter.directMarketingNwgDateTo: Date format not match YYYY-MM-DD";
			}


		if (campaignDetailParameter.getCreatedDateFrom() != null && !campaignDetailParameter.getCreatedDateFrom().matches(dateFormatRegex)) {
				return "campaignDetailParameter.createdDateFrom: Date format not match YYYY-MM-DD";
			}

		if (campaignDetailParameter.getCreatedDateTo() != null && !campaignDetailParameter.getCreatedDateTo().matches(dateFormatRegex)) {
				return "campaignDetailParameter.createdDateTo: Date format not match YYYY-MM-DD";
			}


		if (campaignDetailParameter.getUpdatedDateFrom() != null && !campaignDetailParameter.getUpdatedDateFrom().matches(dateFormatRegex)) {
				return "campaignDetailParameter.updatedDateFrom: Date format not match YYYY-MM-DD";
			}


		if (campaignDetailParameter.getUpdatedDateTo() != null && !campaignDetailParameter.getUpdatedDateTo().matches(dateFormatRegex)) {
				return "campaignDetailParameter.updatedDateTo: Date format not match YYYY-MM-DD";
			}

		return null;
	}

	public static String validatePolicyListParameter(RequestParameter requestParameter) {

		if (requestParameter.getPolicyListParameter() == null) {
			return "missing policyListParameter";
		}

		return null;
	}

	public static String validateDocumentParameter(RequestParameter requestParameter) {

		if (requestParameter.getDocumentParameter() == null) {
			return "missing documentParameter";
		}
		DocumentParameter documentParameter = requestParameter.getDocumentParameter();

		if (documentParameter.getExpiryDate() != null && !documentParameter.getExpiryDate().matches(dateFormatRegex)) {
				return "campaignDetailParameter.expiryDate: Date format not match YYYY-MM-DD";
			}


		if (documentParameter.getEffectiveDate() != null && !documentParameter.getEffectiveDate().matches(dateFormatRegex)) {
				return "campaignDetailParameter.effectiveDate: Date format not match YYYY-MM-DD";
			}


		return null;
	}

	public static String validateDocumentCenterParameter(RequestParameter requestParameter) {
		if (requestParameter.getDocumentCenterParameter() == null) {
			return "missing documentCenterParameter";
		}
		DocumentCenterParameter documentCenterParameter = requestParameter.getDocumentCenterParameter();

		if (documentCenterParameter.getLevel1CategoryId() != null) {
			String check = documentCenterParameter.getLevel1CategoryId();
			try {
				Integer.parseInt(check);
				return null;
			} catch (NumberFormatException nfe) {
				return "documentCenterParameter.Level1CategoryId: incorrect format to a numeric value";
			}
		}

		if (documentCenterParameter.getLevel2CategoryId() != null) {
			String check = documentCenterParameter.getLevel2CategoryId();
			try {
				Integer.parseInt(check);
				return null;
			} catch (NumberFormatException nfe) {
				return "documentCenterParameter.Level2CategoryId: incorrect format to a numeric value";
			}
		}

		if (documentCenterParameter.getFile1Id() != null) {
			String check = documentCenterParameter.getFile1Id();
			try {
				Long.parseLong(check);
				return null;
			} catch (NumberFormatException nfe) {
				return "documentCenterParameter.File1Id: incorrect format to a numeric value";
			}
		}

		if (documentCenterParameter.getFile2Id() != null) {
			String check = documentCenterParameter.getFile2Id();
			try {
				Long.parseLong(check);
				return null;
			} catch (NumberFormatException nfe) {
				return "documentCenterParameter.File2Id: incorrect format to a numeric value";
			}
		}

		if (documentCenterParameter.getFile3Id() != null) {
			String check = documentCenterParameter.getFile3Id();
			try {
				Long.parseLong(check);
				return null;
			} catch (NumberFormatException nfe) {
				return "documentCenterParameter.File3Id: incorrect format to a numeric value";
			}
		}

		if (documentCenterParameter.getEffectiveDateFrom() != null) {
			if (!documentCenterParameter.getEffectiveDateFrom().matches(dateFormatRegex)) {
				return "documentCenterParameter.effectiveDateFrom: Date format not match YYYY-MM-DD";
			}
		}

		if (documentCenterParameter.getEffectiveDateTo() != null && !documentCenterParameter.getEffectiveDateTo().matches(dateFormatRegex)) {
				return "documentCenterParameter.effectiveDateTo: Date format not match YYYY-MM-DD";
			}


		return null;

	}

}