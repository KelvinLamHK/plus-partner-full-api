package com.ftlife.plus.partner.util;

import com.ftlife.plus.partner.parameter.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ValidationUtilTest {



    @Test
    void validateUserParameterTest (){
        RequestParameter requestParameter = new RequestParameter();
        UserParameter userParameter = new UserParameter();
        assertEquals("missing userParameter",ValidationUtil.validateUserParameter(requestParameter));
        requestParameter.setUserParameter(userParameter);
        assertEquals("missing userParameter.name",ValidationUtil.validateUserParameter(requestParameter));
        userParameter.setName("a");
        assertEquals("missing userParameter.loginName",ValidationUtil.validateUserParameter(requestParameter));
        userParameter.setLoginName("a");
        assertEquals("missing userParameter.role",ValidationUtil.validateUserParameter(requestParameter));
        userParameter.setRole("a");
        assertNull(ValidationUtil.validateUserParameter(requestParameter));
    }

    @Test
    void validateCampaignHeaderParameterTest(){
        var campaignHeaderParameter = new CampaignHeaderParameter();
        var requestParameter = new RequestParameter();
        assertEquals("missing campaignHeaderParameter",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
        campaignHeaderParameter.setCampaignHeaderId(null);
        assertEquals("missing campaignHeaderParameter.campaignCode",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        campaignHeaderParameter.setCampaignHeaderId("a");
        assertEquals("campaignHeaderParameter.campaignHeaderId: incorrect format to a numeric value",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        campaignHeaderParameter.setCampaignHeaderId("1");
        assertEquals("missing campaignHeaderParameter.campaignCode",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        campaignHeaderParameter.setCampaignCode("a");
        assertEquals("missing campaignHeaderParameter.campaignNameEng",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        campaignHeaderParameter.setCampaignNameEng("a");
        assertEquals("missing campaignHeaderParameter.ifaCaIndicator",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        campaignHeaderParameter.setIfaCaIndicator("a");
        campaignHeaderParameter.setThumbnailDocID("a");
        assertEquals("campaignHeaderParameter.thumbnailDocID: incorrect format to a numeric value",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        campaignHeaderParameter.setThumbnailDocID("1");
        assertEquals("missing campaignHeaderParameter.campaignStartDate",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        campaignHeaderParameter.setThumbnailDocID(null);
        assertEquals("missing campaignHeaderParameter.campaignStartDate",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        campaignHeaderParameter.setCampaignStartDate("a");
        assertEquals("campaignHeaderParameter.campaignStartDate: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        campaignHeaderParameter.setCampaignStartDate("2022-01-01");
        assertEquals("missing campaignHeaderParameter.campaignEndDate",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        campaignHeaderParameter.setCampaignEndDate("a");
        assertEquals("campaignHeaderParameter.campaignEndDate: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignHeaderParameter(requestParameter));
        campaignHeaderParameter.setCampaignEndDate("2022-01-01");
        assertNull(ValidationUtil.validateCampaignHeaderParameter(requestParameter));

    }

    @Test
    void validateCampaignDetailParameterTest(){
        var requestParameter = new RequestParameter();
        CampaignDetailParameter campaignDetailParameter = new CampaignDetailParameter();
        assertEquals("missing campaignDetailParameter",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        requestParameter.setCampaignDetailParameter(campaignDetailParameter);

        campaignDetailParameter.setCampaignDetailId("a");
        assertEquals("campaignDetailParameter.CampaignDetailId: incorrect format to a numeric value",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setCampaignDetailId("1");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setCampaignDetailId(null);
        campaignDetailParameter.setCampaignHeaderId("a");
        assertEquals("campaignDetailParameter.CampaignHeaderId: incorrect format to a numeric value",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setCampaignHeaderId("1");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setCampaignHeaderId(null);
        campaignDetailParameter.setPartyId("a");
        assertEquals("campaignDetailParameter.PartyId: incorrect format to a numeric value",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setPartyId("1");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setPartyId(null);
        campaignDetailParameter.setLatestPolicyIssueDateFrom("a");
        assertEquals("campaignDetailParameter.latestPolicyIssueDateFrom: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setLatestPolicyIssueDateFrom("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setLatestPolicyIssueDateFrom(null);
        campaignDetailParameter.setLatestPolicyIssueDateTo("a");
        assertEquals("campaignDetailParameter.latestPolicyIssueDateTo: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setLatestPolicyIssueDateTo("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setLatestPolicyIssueDateTo(null);
        campaignDetailParameter.setFirstPolicyIssueDateFrom("a");
        assertEquals("campaignDetailParameter.firstPolicyIssueDateFrom: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setFirstPolicyIssueDateFrom("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setFirstPolicyIssueDateFrom(null);
        campaignDetailParameter.setFirstPolicyIssueDateTo("a");
        assertEquals("campaignDetailParameter.firstPolicyIssueDateTo: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setFirstPolicyIssueDateTo("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setFirstPolicyIssueDateTo(null);
        campaignDetailParameter.setNoOfInForcePolicy("a");
        assertEquals("campaignDetailParameter.NoOfInForcePolicy: incorrect format to a numeric value",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setNoOfInForcePolicy("1");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setNoOfInForcePolicy(null);
        campaignDetailParameter.setLastYearPremium("a");
        assertEquals("campaignDetailParameter.LastYearPremium: incorrect format to a numeric value",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setLastYearPremium("1.1");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setLastYearPremium(null);
        campaignDetailParameter.setThisYearPremium("a");
        assertEquals("campaignDetailParameter.ThisYearPremium: incorrect format to a numeric value",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setThisYearPremium("1.1");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setThisYearPremium(null);
        campaignDetailParameter.setPicsIndicatorDateFrom("a");
        assertEquals("campaignDetailParameter.picsIndicatorDateFrom: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setPicsIndicatorDateFrom("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setPicsIndicatorDateFrom(null);
        campaignDetailParameter.setPicsIndicatorDateTo("a");
        assertEquals("campaignDetailParameter.picsIndicatorDateTo: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setPicsIndicatorDateTo("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setPicsIndicatorDateTo(null);
        campaignDetailParameter.setDirectMarketingFtl("a");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setDirectMarketingFtl(null);
        campaignDetailParameter.setDirectMarketingFtlDateFrom("a");
        assertEquals("campaignDetailParameter.directMarketingFtlDateFrom: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setDirectMarketingFtlDateFrom("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setDirectMarketingFtlDateFrom(null);
        campaignDetailParameter.setDirectMarketingFtlDateTo("a");
        assertEquals("campaignDetailParameter.directMarketingFtlDateTo: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setDirectMarketingFtlDateTo("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setDirectMarketingFtlDateTo(null);
        campaignDetailParameter.setDirectMarketingNwg("a");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setDirectMarketingNwg(null);
        campaignDetailParameter.setDirectMarketingNwgDateFrom("a");
        assertEquals("campaignDetailParameter.directMarketingNwgDateFrom: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setDirectMarketingNwgDateFrom("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setDirectMarketingNwgDateFrom(null);
        campaignDetailParameter.setDirectMarketingNwgDateTo("a");
        assertEquals("campaignDetailParameter.directMarketingNwgDateTo: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setDirectMarketingNwgDateTo("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setDirectMarketingNwgDateTo(null);
        campaignDetailParameter.setCreatedDateFrom("a");
        assertEquals("campaignDetailParameter.createdDateFrom: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setCreatedDateFrom("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setCreatedDateFrom(null);
        campaignDetailParameter.setCreatedDateTo("a");
        assertEquals("campaignDetailParameter.createdDateTo: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setCreatedDateTo("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setCreatedDateTo(null);
        campaignDetailParameter.setUpdatedDateFrom("a");
        assertEquals("campaignDetailParameter.updatedDateFrom: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setUpdatedDateFrom("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setUpdatedDateFrom(null);
        campaignDetailParameter.setUpdatedDateTo("a");
        assertEquals("campaignDetailParameter.updatedDateTo: Date format not match YYYY-MM-DD",ValidationUtil.validateCampaignDetailParameter(requestParameter));
        campaignDetailParameter.setUpdatedDateTo("2022-09-29");
        assertNull(ValidationUtil.validateCampaignDetailParameter(requestParameter));
    }

    @Test
    void validatePolicyListParameterTest(){
        RequestParameter requestParameter = new RequestParameter();
        var policyListParameter = new PolicyListParameter();
        assertEquals("missing policyListParameter",ValidationUtil.validatePolicyListParameter(requestParameter));
        requestParameter.setPolicyListParameter(policyListParameter);

        policyListParameter.setPolicyNumber("a");
        assertNull(ValidationUtil.validatePolicyListParameter(requestParameter));

        policyListParameter.setServiceAgentName("a");
        assertNull(ValidationUtil.validatePolicyListParameter(requestParameter));

        policyListParameter.setPolicyHolderNameEn("a");
        assertNull(ValidationUtil.validatePolicyListParameter(requestParameter));

        policyListParameter.setPolicyHolderNameCN("a");
        assertNull(ValidationUtil.validatePolicyListParameter(requestParameter));
    }

    @Test
    void validateDocumentParameterTest(){
        var requestParameter = new RequestParameter();
        var documentParameter = new DocumentParameter();
        assertEquals("missing documentParameter",ValidationUtil.validateDocumentParameter(requestParameter));
        requestParameter.setDocumentParameter(documentParameter);

        documentParameter.setDocumentName("a");
        assertNull(ValidationUtil.validateDocumentParameter(requestParameter));
        documentParameter.setDocumentName(null);
        documentParameter.setBase64FileString("a");
        assertNull(ValidationUtil.validateDocumentParameter(requestParameter));
        documentParameter.setBase64FileString(null);
        documentParameter.setDocumentType("a");
        assertNull(ValidationUtil.validateDocumentParameter(requestParameter));
        documentParameter.setDocumentType(null);
        documentParameter.setPolicyCode("a");
        assertNull(ValidationUtil.validateDocumentParameter(requestParameter));
        documentParameter.setPolicyCode(null);
        documentParameter.setExpiryDate("a");
        assertEquals("campaignDetailParameter.expiryDate: Date format not match YYYY-MM-DD",ValidationUtil.validateDocumentParameter(requestParameter));
        documentParameter.setExpiryDate("2022-09-29");
        assertNull(ValidationUtil.validateDocumentParameter(requestParameter));
        documentParameter.setExpiryDate(null);
        documentParameter.setEffectiveDate("a");
        assertEquals("campaignDetailParameter.effectiveDate: Date format not match YYYY-MM-DD",ValidationUtil.validateDocumentParameter(requestParameter));
        documentParameter.setEffectiveDate("2022-09-29");
        assertNull(ValidationUtil.validateDocumentParameter(requestParameter));
        documentParameter.setEffectiveDate(null);
        assertNull(ValidationUtil.validateDocumentParameter(requestParameter));
    }

    @Test
    void validateDocumentCenterParameterTest() {
        var requestParameter = new RequestParameter();
        var documentCenterParameter = new DocumentCenterParameter();
        assertEquals("missing documentCenterParameter",ValidationUtil.validateDocumentCenterParameter(requestParameter));
        requestParameter.setDocumentCenterParameter(documentCenterParameter);
        documentCenterParameter.setTitleEnglish("a");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setTitleEnglish(null);
        documentCenterParameter.setTitleSimplifiedChinese("a");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setTitleSimplifiedChinese(null);
        documentCenterParameter.setTitleTraditionalChinese("a");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setTitleTraditionalChinese(null);
        documentCenterParameter.setDocumentStatus("a");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setDocumentStatus(null);
        documentCenterParameter.setLevel1CategoryId("a");
        assertEquals("documentCenterParameter.Level1CategoryId: incorrect format to a numeric value",ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setLevel1CategoryId("1");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setLevel1CategoryId(null);
        documentCenterParameter.setLevel2CategoryId("a");
        assertEquals("documentCenterParameter.Level2CategoryId: incorrect format to a numeric value",ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setLevel2CategoryId("1");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setLevel2CategoryId(null);
        documentCenterParameter.setDescriptionEnglish("a");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setDescriptionEnglish(null);
        documentCenterParameter.setDescriptionSimplifiedChinese("a");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setDescriptionSimplifiedChinese(null);
        documentCenterParameter.setDescriptionTraditionalChinese("a");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setDescriptionTraditionalChinese(null);
        documentCenterParameter.setFile1Id("a");
		assertEquals("documentCenterParameter.File1Id: incorrect format to a numeric value",ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setFile1Id("1");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
        documentCenterParameter.setFile1Id(null);
		documentCenterParameter.setFile2Id("a");
		assertEquals("documentCenterParameter.File2Id: incorrect format to a numeric value",ValidationUtil.validateDocumentCenterParameter(requestParameter));
		documentCenterParameter.setFile2Id("1");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
		documentCenterParameter.setFile2Id(null);
		documentCenterParameter.setFile3Id("a");
		assertEquals("documentCenterParameter.File3Id: incorrect format to a numeric value",ValidationUtil.validateDocumentCenterParameter(requestParameter));
		documentCenterParameter.setFile3Id("1");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
		documentCenterParameter.setFile3Id(null);
		documentCenterParameter.setEffectiveDateFrom("a");
        assertEquals("documentCenterParameter.effectiveDateFrom: Date format not match YYYY-MM-DD",ValidationUtil.validateDocumentCenterParameter(requestParameter));
		documentCenterParameter.setEffectiveDateFrom("2022-09-29");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
		documentCenterParameter.setEffectiveDateFrom(null);
		documentCenterParameter.setEffectiveDateTo("a");
        assertEquals("documentCenterParameter.effectiveDateTo: Date format not match YYYY-MM-DD",ValidationUtil.validateDocumentCenterParameter(requestParameter));
		documentCenterParameter.setEffectiveDateTo("2022-09-29");
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));
		documentCenterParameter.setEffectiveDateTo(null);
        assertNull(ValidationUtil.validateDocumentCenterParameter(requestParameter));

    }

}
