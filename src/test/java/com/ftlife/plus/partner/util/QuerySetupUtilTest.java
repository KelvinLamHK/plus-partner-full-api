package com.ftlife.plus.partner.util;

import com.ftlife.plus.partner.entity.TCampaignHeaderEntity;
import com.ftlife.plus.partner.parameter.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuerySetupUtilTest {

    QuerySetupUtil querySetupUtil = new QuerySetupUtil();

    RequestParameter requestParameter = new RequestParameter();

    PageableParameter pageableParameter = new PageableParameter();

    CampaignListParameter campaignListParameter = new CampaignListParameter();

    CampaignDetailParameter campaignDetailParameter = new CampaignDetailParameter();
    @Test
    void setPageableOrderTest() {
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageSize(1);
        pageableParameter.setPageNumber(0);
        pageableParameter.setOrderSequence(null);
        requestParameter.setPageableParameter(pageableParameter);
        assertEquals(0, querySetupUtil.setPageable(requestParameter).getPageNumber());

    }

    @Test
    void setPageableOrderDefaultTest() {
        pageableParameter.setPageNumber(0);
        pageableParameter.setPageSize(1);
        requestParameter.setPageableParameter(pageableParameter);

        assertEquals(0, querySetupUtil.setPageable(requestParameter).getPageNumber());

    }

    @Test
    void setPageableOrderDescTest() {
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(0);
        pageableParameter.setOrderSequence("desc");
        pageableParameter.setPageSize(1);
        requestParameter.setPageableParameter(pageableParameter);

        assertEquals(0, querySetupUtil.setPageable(requestParameter).getPageNumber());

    }

    @Test
    void setPageableOrderAscTest() {
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(0);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(1);
        requestParameter.setPageableParameter(pageableParameter);

        assertEquals(0, querySetupUtil.setPageable(requestParameter).getPageNumber());

    }

    @Test
    void setCampaignMasterListParameterWhereClauseTest() throws ParseException {

        UserParameter userParameter = new UserParameter();
        userParameter.setLoginName("a");
        userParameter.setName("a");
        userParameter.setCompanyName("a");
        userParameter.setCompanyID("a");
        userParameter.setEmail("a");
        userParameter.setBrokerCode("a");
        userParameter.setIfaIdentity("a");
        userParameter.setPibaNumber("a");
        userParameter.setIfaCaNameEng("a");
        userParameter.setIfaCaNameOther("a");
        userParameter.setIfaCaLicenseNumber("a");
        userParameter.setRole("a");

        campaignListParameter.setCampaignCode("a");
        campaignListParameter.setCampaignName("a");
        requestParameter.setCampaignListParameter(campaignListParameter);
        requestParameter.setUserParameter(userParameter);

        GenericSpecification genericSpecification = new GenericSpecification<TCampaignHeaderEntity>();


        assertEquals(genericSpecification.getClass(), querySetupUtil.setCampaignListWhereClause(requestParameter).getClass());


    }

    @Test
    public void setCampaignDetailParameterWhereClauseTest() throws ParseException {
        GenericSpecification genericSpecification = new GenericSpecification<>();
        UserParameter userParameter = new UserParameter();
        userParameter.setRole("A");
        userParameter.setBrokerCode("A");
        userParameter.setIfaIdentity("A");
        userParameter.setLoginName("A");
        requestParameter.setUserParameter(userParameter);
        campaignDetailParameter.setCampaignDetailId("1");
        campaignDetailParameter.setLatestPolicyIssueDateFrom("2022-01-01");
        campaignDetailParameter.setLatestPolicyIssueDateTo("2022-01-01");
        campaignDetailParameter.setFirstPolicyIssueDateFrom("2022-01-01");
        campaignDetailParameter.setFirstPolicyIssueDateTo("2022-01-01");
        campaignDetailParameter.setDateOfBirthFrom("2022-01-01");
        campaignDetailParameter.setDateOfBirthTo("2022-01-01");
        campaignDetailParameter.setServAgentRegionName("A");
        campaignDetailParameter.setCampaignHeaderId("1");
        campaignDetailParameter.setClientFullNameEng("A");
        campaignDetailParameter.setClientFullNameChi("A");
        campaignDetailParameter.setLatestIssuedPolicy("A");
        campaignDetailParameter.setServAgentName("A");
        campaignDetailParameter.setServAgentCode("A");
        campaignDetailParameter.setSalesManager1("A");
        requestParameter.setCampaignDetailParameter(campaignDetailParameter);

        genericSpecification.add(new SearchCriteria("servicingAgentCode", requestParameter.getUserParameter().getBrokerCode(), SearchOperation.IN));
        genericSpecification.add(new SearchCriteria("trCode", requestParameter.getUserParameter().getLoginName(), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("campaignDetailId", Long.parseLong(campaignDetailParameter.getCampaignDetailId()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("latestPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getLatestPolicyIssueDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("latestPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getLatestPolicyIssueDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("firstPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getFirstPolicyIssueDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("firstPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getFirstPolicyIssueDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("dateOfBirth", StringUtil.stringToDate(campaignDetailParameter.getDateOfBirthFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("dateOfBirth", StringUtil.stringToDate(campaignDetailParameter.getDateOfBirthTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("servAgentRegionName", campaignDetailParameter.getServAgentRegionName(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("campaignHeaderId", Long.parseLong(campaignDetailParameter.getCampaignHeaderId()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("clientFullNameEng", campaignDetailParameter.getClientFullNameEng(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("clientFullNameChi", campaignDetailParameter.getClientFullNameChi(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("latestIssuedPolicy", campaignDetailParameter.getLatestIssuedPolicy(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("servAgentName", campaignDetailParameter.getServAgentName(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("servicingAgentCode", campaignDetailParameter.getServAgentCode(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("salesManager1", campaignDetailParameter.getSalesManager1(), SearchOperation.MATCH));
        assertEquals(genericSpecification.getClass(), querySetupUtil.setCampaignDetailListParameterWhereClause(requestParameter).getClass());
    }

            @Test
            public void setCampaignDetailParameterWhereClauseTest2() throws ParseException {
                        GenericSpecification genericSpecification = new GenericSpecification<>();
                        UserParameter userParameter = new UserParameter();
                        userParameter.setRole("internal-admin");
                        userParameter.setBrokerCode("A");
                        userParameter.setIfaIdentity("A");
                        userParameter.setLoginName("A");
                        requestParameter.setUserParameter(userParameter);
                        campaignDetailParameter.setCampaignDetailId("1");
                        campaignDetailParameter.setLatestPolicyIssueDateFrom("2022-01-01");
                        campaignDetailParameter.setLatestPolicyIssueDateTo("2022-01-01");
                        campaignDetailParameter.setFirstPolicyIssueDateFrom("2022-01-01");
                        campaignDetailParameter.setFirstPolicyIssueDateTo("2022-01-01");
                        campaignDetailParameter.setDateOfBirthFrom("2022-01-01");
                        campaignDetailParameter.setDateOfBirthTo("2022-01-01");
                        campaignDetailParameter.setServAgentRegionName("A");
                        campaignDetailParameter.setCampaignHeaderId("1");
                        campaignDetailParameter.setClientFullNameEng("A");
                        campaignDetailParameter.setClientFullNameChi("A");
                        campaignDetailParameter.setLatestIssuedPolicy("A");
                        campaignDetailParameter.setServAgentName("A");
                        campaignDetailParameter.setServAgentCode("A");
                        campaignDetailParameter.setSalesManager1("A");
                        requestParameter.setCampaignDetailParameter(campaignDetailParameter);

                        genericSpecification.add(new SearchCriteria("servicingAgentCode", requestParameter.getUserParameter().getBrokerCode(), SearchOperation.IN));
                        genericSpecification.add(new SearchCriteria("trCode", requestParameter.getUserParameter().getLoginName(), SearchOperation.EQUAL));
                        genericSpecification.add(new SearchCriteria("campaignDetailId", Long.parseLong(campaignDetailParameter.getCampaignDetailId()), SearchOperation.EQUAL));
                        genericSpecification.add(new SearchCriteria("latestPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getLatestPolicyIssueDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
                        genericSpecification.add(new SearchCriteria("latestPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getLatestPolicyIssueDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
                        genericSpecification.add(new SearchCriteria("firstPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getFirstPolicyIssueDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
                        genericSpecification.add(new SearchCriteria("firstPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getFirstPolicyIssueDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
                        genericSpecification.add(new SearchCriteria("dateOfBirth", StringUtil.stringToDate(campaignDetailParameter.getDateOfBirthFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
                        genericSpecification.add(new SearchCriteria("dateOfBirth", StringUtil.stringToDate(campaignDetailParameter.getDateOfBirthTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
                        genericSpecification.add(new SearchCriteria("servAgentRegionName", campaignDetailParameter.getServAgentRegionName(), SearchOperation.MATCH));
                        genericSpecification.add(new SearchCriteria("campaignHeaderId", Long.parseLong(campaignDetailParameter.getCampaignHeaderId()), SearchOperation.EQUAL));
                        genericSpecification.add(new SearchCriteria("clientFullNameEng", campaignDetailParameter.getClientFullNameEng(), SearchOperation.MATCH));
                        genericSpecification.add(new SearchCriteria("clientFullNameChi", campaignDetailParameter.getClientFullNameChi(), SearchOperation.MATCH));
                        genericSpecification.add(new SearchCriteria("latestIssuedPolicy", campaignDetailParameter.getLatestIssuedPolicy(), SearchOperation.MATCH));
                        genericSpecification.add(new SearchCriteria("servAgentName", campaignDetailParameter.getServAgentName(), SearchOperation.MATCH));
                        genericSpecification.add(new SearchCriteria("servicingAgentCode", campaignDetailParameter.getServAgentCode(), SearchOperation.MATCH));
                        genericSpecification.add(new SearchCriteria("salesManager1", campaignDetailParameter.getSalesManager1(), SearchOperation.MATCH));
                        assertEquals(genericSpecification.getClass(), querySetupUtil.setCampaignDetailListParameterWhereClause(requestParameter).getClass());
                    }

    @Test
    public void setCampaignDetailParameterWhereClauseTest3() throws ParseException {

                GenericSpecification genericSpecification = new GenericSpecification<>();
                UserParameter userParameter = new UserParameter();
                userParameter.setRole("ADMIN");
                userParameter.setBrokerCode("A");
                userParameter.setIfaIdentity("A");
                userParameter.setLoginName("A");
                requestParameter.setUserParameter(userParameter);
                campaignDetailParameter.setCampaignDetailId("1");
                campaignDetailParameter.setLatestPolicyIssueDateFrom("2022-01-01");
                campaignDetailParameter.setLatestPolicyIssueDateTo("2022-01-01");
                campaignDetailParameter.setFirstPolicyIssueDateFrom("2022-01-01");
                campaignDetailParameter.setFirstPolicyIssueDateTo("2022-01-01");
                campaignDetailParameter.setDateOfBirthFrom("2022-01-01");
                campaignDetailParameter.setDateOfBirthTo("2022-01-01");
                campaignDetailParameter.setServAgentRegionName("A");
                campaignDetailParameter.setCampaignHeaderId("1");
                campaignDetailParameter.setClientFullNameEng("A");
                campaignDetailParameter.setClientFullNameChi("A");
                campaignDetailParameter.setLatestIssuedPolicy("A");
                campaignDetailParameter.setServAgentName("A");
                campaignDetailParameter.setServAgentCode("A");
                campaignDetailParameter.setSalesManager1("A");
                requestParameter.setCampaignDetailParameter(campaignDetailParameter);

                genericSpecification.add(new SearchCriteria("servicingAgentCode", requestParameter.getUserParameter().getBrokerCode(), SearchOperation.IN));
                genericSpecification.add(new SearchCriteria("trCode", requestParameter.getUserParameter().getLoginName(), SearchOperation.EQUAL));
                genericSpecification.add(new SearchCriteria("campaignDetailId", Long.parseLong(campaignDetailParameter.getCampaignDetailId()), SearchOperation.EQUAL));
                genericSpecification.add(new SearchCriteria("latestPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getLatestPolicyIssueDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
                genericSpecification.add(new SearchCriteria("latestPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getLatestPolicyIssueDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
                genericSpecification.add(new SearchCriteria("firstPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getFirstPolicyIssueDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
                genericSpecification.add(new SearchCriteria("firstPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getFirstPolicyIssueDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
                genericSpecification.add(new SearchCriteria("dateOfBirth", StringUtil.stringToDate(campaignDetailParameter.getDateOfBirthFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
                genericSpecification.add(new SearchCriteria("dateOfBirth", StringUtil.stringToDate(campaignDetailParameter.getDateOfBirthTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
                genericSpecification.add(new SearchCriteria("servAgentRegionName", campaignDetailParameter.getServAgentRegionName(), SearchOperation.MATCH));
                genericSpecification.add(new SearchCriteria("campaignHeaderId", Long.parseLong(campaignDetailParameter.getCampaignHeaderId()), SearchOperation.EQUAL));
                genericSpecification.add(new SearchCriteria("clientFullNameEng", campaignDetailParameter.getClientFullNameEng(), SearchOperation.MATCH));
                genericSpecification.add(new SearchCriteria("clientFullNameChi", campaignDetailParameter.getClientFullNameChi(), SearchOperation.MATCH));
                genericSpecification.add(new SearchCriteria("latestIssuedPolicy", campaignDetailParameter.getLatestIssuedPolicy(), SearchOperation.MATCH));
                genericSpecification.add(new SearchCriteria("servAgentName", campaignDetailParameter.getServAgentName(), SearchOperation.MATCH));
                genericSpecification.add(new SearchCriteria("servicingAgentCode", campaignDetailParameter.getServAgentCode(), SearchOperation.MATCH));
                genericSpecification.add(new SearchCriteria("salesManager1", campaignDetailParameter.getSalesManager1(), SearchOperation.MATCH));
                assertEquals(genericSpecification.getClass(), querySetupUtil.setCampaignDetailListParameterWhereClause(requestParameter).getClass());
            }

    @Test
    public void setCampaignDetailParameterWhereClauseNullTest() throws ParseException {
        GenericSpecification genericSpecification = new GenericSpecification<>();
        UserParameter userParameter = new UserParameter();
        userParameter.setRole("A");
        userParameter.setBrokerCode("A");
        userParameter.setIfaIdentity("A");
        userParameter.setLoginName("A");
        requestParameter.setUserParameter(userParameter);
        requestParameter.setCampaignDetailParameter(campaignDetailParameter);

        assertEquals(genericSpecification.getClass(), querySetupUtil.setCampaignDetailListParameterWhereClause(requestParameter).getClass());
    }

    @SneakyThrows
    @Test
    public void setDocumentCenterListWhereClauseTest() {
        GenericSpecification genericSpecification = new GenericSpecification<>();
        UserParameter userParameter = new UserParameter();
        userParameter.setRole("internal-admin");
        userParameter.setBrokerCode("a");
        DocumentCenterParameter documentCenterParameter = new DocumentCenterParameter();
        documentCenterParameter.setTitleEnglish("a");
        documentCenterParameter.setTitleTraditionalChinese("a");
        documentCenterParameter.setTitleSimplifiedChinese("a");
        documentCenterParameter.setDocumentStatus("a");
        documentCenterParameter.setLevel1CategoryId("1");
        documentCenterParameter.setLevel2CategoryId("1");
        documentCenterParameter.setDescriptionEnglish("a");
        documentCenterParameter.setDescriptionTraditionalChinese("a");
        documentCenterParameter.setDescriptionSimplifiedChinese("a");
        documentCenterParameter.setFile1Id("1");
        documentCenterParameter.setFile2Id("1");
        documentCenterParameter.setFile3Id("1");
        documentCenterParameter.setEffectiveDateFrom("2022-01-01");
        documentCenterParameter.setEffectiveDateTo("2022-01-01");
        documentCenterParameter.setCreatedDateFrom("2022-01-01");
        documentCenterParameter.setCreatedDateTo("2022-01-01");
        documentCenterParameter.setUpdatedDateFrom("2022-01-01");
        documentCenterParameter.setUpdatedDateTo("2022-01-01");
        documentCenterParameter.setIsPin("a");
        documentCenterParameter.setIsPromo("a");
        documentCenterParameter.setIfaCaIndicator("a");
        String visibility[]={"1","2","3"};
        documentCenterParameter.setVisibilityList(visibility);
        requestParameter.setUserParameter(userParameter);
        requestParameter.setDocumentCenterParameter(documentCenterParameter);

        genericSpecification.add(new SearchCriteria("agentCode", requestParameter.getUserParameter().getBrokerCode(), SearchOperation.EXIST_DOCUMENT_CENTER));
        genericSpecification.add(new SearchCriteria("titleEnglish", documentCenterParameter.getTitleEnglish(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("titleTraditionalChinese", documentCenterParameter.getTitleTraditionalChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("titleSimplifiedChinese", documentCenterParameter.getTitleSimplifiedChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("documentStatus", documentCenterParameter.getDocumentStatus(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("level1CategoryId", Integer.parseInt(documentCenterParameter.getLevel1CategoryId()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("level2CategoryId", Integer.parseInt(documentCenterParameter.getLevel2CategoryId()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("descriptionEnglish", documentCenterParameter.getDescriptionEnglish(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("descriptionTraditionalChinese", documentCenterParameter.getDescriptionTraditionalChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("descriptionSimplifiedChinese", documentCenterParameter.getDescriptionSimplifiedChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("file1Id", Long.parseLong(documentCenterParameter.getFile1Id()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("file2Id", Long.parseLong(documentCenterParameter.getFile2Id()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("file3Id", Long.parseLong(documentCenterParameter.getFile3Id()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("effectiveDateFrom", StringUtil.stringToDate(documentCenterParameter.getEffectiveDateFrom(), "yyyy-MM-dd"), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("effectiveDateTo", StringUtil.stringToDate(documentCenterParameter.getEffectiveDateTo(), "yyyy-MM-dd"), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("createdDate", StringUtil.stringToDate(documentCenterParameter.getCreatedDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("createdDate", StringUtil.stringToDate(documentCenterParameter.getCreatedDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("updatedDate", StringUtil.stringToDate(documentCenterParameter.getUpdatedDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("updatedDate", StringUtil.stringToDate(documentCenterParameter.getUpdatedDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("isPin", documentCenterParameter.getIsPin(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("isPromo", documentCenterParameter.getIsPromo(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("ifaCaIndicator", documentCenterParameter.getIfaCaIndicator(), SearchOperation.MATCH));

        assertEquals(genericSpecification.getClass(), querySetupUtil.setDocumentCenterListWhereClause(requestParameter).getClass());

    }

    @Test
    public void setDocumentCenterListWhereClauseTest2() throws ParseException {
        GenericSpecification genericSpecification = new GenericSpecification<>();
        UserParameter userParameter = new UserParameter();
        userParameter.setRole("internal-admin");
        userParameter.setBrokerCode("a");
        DocumentCenterParameter documentCenterParameter = new DocumentCenterParameter();
        documentCenterParameter.setTitleEnglish("a");
        documentCenterParameter.setTitleTraditionalChinese("a");
        documentCenterParameter.setTitleSimplifiedChinese("a");
        documentCenterParameter.setDocumentStatus("a");
        documentCenterParameter.setLevel1CategoryId("1");
        documentCenterParameter.setLevel2CategoryId("1");
        documentCenterParameter.setDescriptionEnglish("a");
        documentCenterParameter.setDescriptionTraditionalChinese("a");
        documentCenterParameter.setDescriptionSimplifiedChinese("a");
        documentCenterParameter.setFile1Id("1");
        documentCenterParameter.setFile2Id("1");
        documentCenterParameter.setFile3Id("1");
        documentCenterParameter.setEffectiveDateFrom("2022-01-01");
        documentCenterParameter.setEffectiveDateTo("2022-01-01");
        documentCenterParameter.setCreatedDateFrom("2022-01-01");
        documentCenterParameter.setCreatedDateTo("2022-01-01");
        documentCenterParameter.setUpdatedDateFrom("2022-01-01");
        documentCenterParameter.setUpdatedDateTo("2022-01-01");
        documentCenterParameter.setIsPin("a");
        documentCenterParameter.setIsPromo("a");
        documentCenterParameter.setIfaCaIndicator("a");

        documentCenterParameter.setVisibilityList(null);
        requestParameter.setUserParameter(userParameter);
        requestParameter.setDocumentCenterParameter(documentCenterParameter);

        genericSpecification.add(new SearchCriteria("agentCode", requestParameter.getUserParameter().getBrokerCode(), SearchOperation.EXIST_DOCUMENT_CENTER));
        genericSpecification.add(new SearchCriteria("titleEnglish", documentCenterParameter.getTitleEnglish(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("titleTraditionalChinese", documentCenterParameter.getTitleTraditionalChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("titleSimplifiedChinese", documentCenterParameter.getTitleSimplifiedChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("documentStatus", documentCenterParameter.getDocumentStatus(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("level1CategoryId", Integer.parseInt(documentCenterParameter.getLevel1CategoryId()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("level2CategoryId", Integer.parseInt(documentCenterParameter.getLevel2CategoryId()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("descriptionEnglish", documentCenterParameter.getDescriptionEnglish(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("descriptionTraditionalChinese", documentCenterParameter.getDescriptionTraditionalChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("descriptionSimplifiedChinese", documentCenterParameter.getDescriptionSimplifiedChinese(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("file1Id", Long.parseLong(documentCenterParameter.getFile1Id()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("file2Id", Long.parseLong(documentCenterParameter.getFile2Id()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("file3Id", Long.parseLong(documentCenterParameter.getFile3Id()), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("effectiveDateFrom", StringUtil.stringToDate(documentCenterParameter.getEffectiveDateFrom(), "yyyy-MM-dd"), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("effectiveDateTo", StringUtil.stringToDate(documentCenterParameter.getEffectiveDateTo(), "yyyy-MM-dd"), SearchOperation.EQUAL));
        genericSpecification.add(new SearchCriteria("createdDate", StringUtil.stringToDate(documentCenterParameter.getCreatedDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("createdDate", StringUtil.stringToDate(documentCenterParameter.getCreatedDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("updatedDate", StringUtil.stringToDate(documentCenterParameter.getUpdatedDateFrom(), "yyyy-MM-dd"), SearchOperation.GREATER_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("updatedDate", StringUtil.stringToDate(documentCenterParameter.getUpdatedDateTo(), "yyyy-MM-dd"), SearchOperation.LESS_THAN_EQUAL));
        genericSpecification.add(new SearchCriteria("isPin", documentCenterParameter.getIsPin(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("isPromo", documentCenterParameter.getIsPromo(), SearchOperation.MATCH));
        genericSpecification.add(new SearchCriteria("ifaCaIndicator", documentCenterParameter.getIfaCaIndicator(), SearchOperation.MATCH));

        assertEquals(genericSpecification.getClass(), querySetupUtil.setDocumentCenterListWhereClause(requestParameter).getClass());

    }

    @Test
    public void setDocumentCenterListWhereClauseNullTest() throws ParseException {
        GenericSpecification genericSpecification = new GenericSpecification<>();
        UserParameter userParameter = new UserParameter();
        userParameter.setBrokerCode("a");
        userParameter.setRole("internal-admin");
        DocumentCenterParameter documentCenterParameter = new DocumentCenterParameter();
        requestParameter.setUserParameter(userParameter);
        requestParameter.setDocumentCenterParameter(documentCenterParameter);

        assertEquals(genericSpecification.getClass(), querySetupUtil.setDocumentCenterListWhereClause(requestParameter).getClass());

    }
}
