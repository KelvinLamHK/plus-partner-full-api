package com.ftlife.plus.partner.util;

import com.ftlife.plus.partner.parameter.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class QuerySetupUtil {

    String dateInString = "yyyy-MM-dd";
    String servAgentCode = "servAgentCode";

    public Pageable setPageable (RequestParameter requestParameter){
        Pageable pageable = null;

        if (requestParameter.getPageableParameter().getOrderBy() == null || requestParameter.getPageableParameter().getOrderSequence() == null ){
            pageable = PageRequest
                    .of(requestParameter.getPageableParameter().getPageNumber()
                            , requestParameter.getPageableParameter().getPageSize());
        } else {
            if (requestParameter.getPageableParameter().getOrderSequence().equals("desc") ){
                pageable = PageRequest
                        .of(requestParameter.getPageableParameter().getPageNumber()
                                , requestParameter.getPageableParameter().getPageSize()
                                , Sort.by(requestParameter.getPageableParameter().getOrderBy()).descending());
            } else {
                pageable = PageRequest
                        .of(requestParameter.getPageableParameter().getPageNumber()
                                , requestParameter.getPageableParameter().getPageSize()
                                , Sort.by(requestParameter.getPageableParameter().getOrderBy()).ascending());
            }
        }


        return pageable;
    }


    public GenericSpecification<Object> setCampaignDetailListParameterWhereClause (RequestParameter requestParameter) throws ParseException {

        GenericSpecification<?> genericSpecification = new GenericSpecification<>();

        CampaignDetailParameter campaignDetailParameter = requestParameter.getCampaignDetailParameter();

        // for external user
        if (!requestParameter.getUserParameter().getRole().equals("internal-admin")){
            genericSpecification.add(new SearchCriteria(servAgentCode, requestParameter.getUserParameter().getBrokerCode(), SearchOperation.IN));
            // for broker agent user
            if(!requestParameter.getUserParameter().getIfaIdentity().equals("ADMIN") ){
                genericSpecification.add(new SearchCriteria("trCode", requestParameter.getUserParameter().getLoginName(), SearchOperation.EQUAL));
            }
        }

        if (campaignDetailParameter.getCampaignDetailId() != null)
            genericSpecification.add(new SearchCriteria("campaignDetailId", Long.parseLong(campaignDetailParameter.getCampaignDetailId()), SearchOperation.EQUAL));

        if (campaignDetailParameter.getLatestPolicyIssueDateFrom() != null)
            genericSpecification.add(new SearchCriteria("latestPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getLatestPolicyIssueDateFrom(),dateInString), SearchOperation.GREATER_THAN_EQUAL));

        if (campaignDetailParameter.getLatestPolicyIssueDateTo() != null)
            genericSpecification.add(new SearchCriteria("latestPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getLatestPolicyIssueDateTo(),dateInString), SearchOperation.LESS_THAN_EQUAL));

        if (campaignDetailParameter.getFirstPolicyIssueDateFrom() != null)
            genericSpecification.add(new SearchCriteria("firstPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getFirstPolicyIssueDateFrom(),dateInString), SearchOperation.GREATER_THAN_EQUAL));

        if (campaignDetailParameter.getFirstPolicyIssueDateTo() != null)
            genericSpecification.add(new SearchCriteria("firstPolicyIssueDate", StringUtil.stringToDate(campaignDetailParameter.getFirstPolicyIssueDateTo(),dateInString), SearchOperation.LESS_THAN_EQUAL));

        if (campaignDetailParameter.getDateOfBirthFrom() != null)
            genericSpecification.add(new SearchCriteria("dateOfBirth", StringUtil.stringToDate(campaignDetailParameter.getDateOfBirthFrom(),dateInString), SearchOperation.GREATER_THAN_EQUAL));

        if (campaignDetailParameter.getDateOfBirthTo() != null)
            genericSpecification.add(new SearchCriteria("dateOfBirth", StringUtil.stringToDate(campaignDetailParameter.getDateOfBirthTo(),dateInString), SearchOperation.LESS_THAN_EQUAL));

        if (campaignDetailParameter.getServAgentRegionName() != null){
            genericSpecification.add(new SearchCriteria("servAgentRegionName",campaignDetailParameter.getServAgentRegionName()   , SearchOperation.MATCH));
        }

        if (campaignDetailParameter.getCampaignHeaderId() != null)
            genericSpecification.add(new SearchCriteria("campaignHeaderId", Long.parseLong(campaignDetailParameter.getCampaignHeaderId()), SearchOperation.EQUAL));

        if (campaignDetailParameter.getClientFullNameEng() != null){
            genericSpecification.add(new SearchCriteria("clientFullNameEng",campaignDetailParameter.getClientFullNameEng()   , SearchOperation.MATCH));
        }

        if (campaignDetailParameter.getClientFullNameChi() != null){
            genericSpecification.add(new SearchCriteria("clientFullNameChi",campaignDetailParameter.getClientFullNameChi()  , SearchOperation.MATCH));
        }

        if (campaignDetailParameter.getLatestIssuedPolicy() != null){
            genericSpecification.add(new SearchCriteria("latestIssuedPolicy",campaignDetailParameter.getLatestIssuedPolicy()  , SearchOperation.MATCH));
        }

        if (campaignDetailParameter.getServAgentName() != null){
            genericSpecification.add(new SearchCriteria("servAgentName",campaignDetailParameter.getServAgentName()  , SearchOperation.MATCH));
        }

        if (campaignDetailParameter.getServAgentCode() != null){
            genericSpecification.add(new SearchCriteria(servAgentCode,campaignDetailParameter.getServAgentCode()  , SearchOperation.MATCH));
        }

        if (campaignDetailParameter.getSalesManager1() != null){
            genericSpecification.add(new SearchCriteria("salesManager1",campaignDetailParameter.getSalesManager1()  , SearchOperation.MATCH));
        }

        return (GenericSpecification<Object>) genericSpecification;
    }

    public GenericSpecification<Object> setDocumentCenterListWhereClause (RequestParameter requestParameter) throws ParseException {

        GenericSpecification<?> genericSpecification = new GenericSpecification<>();
        var userParameter = requestParameter.getUserParameter();
        var documentCenterParameter= requestParameter.getDocumentCenterParameter();

        if(userParameter.getBrokerCode() != null && !requestParameter.getUserParameter().getRole().equals("internal-admin")) {
            genericSpecification.add(new SearchCriteria("agentCode", requestParameter.getUserParameter().getBrokerCode(), SearchOperation.EXIST_DOCUMENT_CENTER));
        }

        if(documentCenterParameter.getTitleEnglish() != null){
            genericSpecification.add(new SearchCriteria("titleEnglish",documentCenterParameter.getTitleEnglish() , SearchOperation.MATCH));
        }

        if(documentCenterParameter.getTitleTraditionalChinese() != null){
            genericSpecification.add(new SearchCriteria("titleTraditionalChinese", documentCenterParameter.getTitleTraditionalChinese(), SearchOperation.MATCH));
        }

        if(documentCenterParameter.getTitleSimplifiedChinese() != null){
            genericSpecification.add(new SearchCriteria("titleSimplifiedChinese", documentCenterParameter.getTitleSimplifiedChinese(),SearchOperation.MATCH));
        }

        if(documentCenterParameter.getDocumentStatus() != null){
            genericSpecification.add(new SearchCriteria("documentStatus", documentCenterParameter.getDocumentStatus(),SearchOperation.MATCH));
        }

        if(documentCenterParameter.getLevel1CategoryId() != null){
            genericSpecification.add(new SearchCriteria("level1CategoryId", Integer.parseInt(documentCenterParameter.getLevel1CategoryId()),SearchOperation.EQUAL));
        }

        if(documentCenterParameter.getLevel2CategoryId() != null){
            genericSpecification.add(new SearchCriteria("level2CategoryId", Integer.parseInt(documentCenterParameter.getLevel2CategoryId()),SearchOperation.EQUAL));
        }

        if(documentCenterParameter.getDescriptionEnglish() != null){
            genericSpecification.add(new SearchCriteria("descriptionEnglish", documentCenterParameter.getDescriptionEnglish(),SearchOperation.MATCH));
        }

        if(documentCenterParameter.getDescriptionTraditionalChinese() != null){
            genericSpecification.add(new SearchCriteria("descriptionTraditionalChinese", documentCenterParameter.getDescriptionTraditionalChinese(),SearchOperation.MATCH));
        }

        if(documentCenterParameter.getDescriptionSimplifiedChinese() != null){
            genericSpecification.add(new SearchCriteria("descriptionSimplifiedChinese", documentCenterParameter.getDescriptionSimplifiedChinese(),SearchOperation.MATCH));
        }

        if(documentCenterParameter.getFile1Id() != null){
            genericSpecification.add(new SearchCriteria("file1Id", Long.parseLong(documentCenterParameter.getFile1Id()),SearchOperation.EQUAL));
        }

        if(documentCenterParameter.getFile2Id() != null){
            genericSpecification.add(new SearchCriteria("file2Id", Long.parseLong(documentCenterParameter.getFile2Id()),SearchOperation.EQUAL));
        }

        if(documentCenterParameter.getFile3Id() != null){
            genericSpecification.add(new SearchCriteria("file3Id", Long.parseLong(documentCenterParameter.getFile3Id()),SearchOperation.EQUAL));
        }

        if (documentCenterParameter.getEffectiveDateFrom() != null) {
            genericSpecification.add(new SearchCriteria("effectiveDateFrom", StringUtil.stringToDate(documentCenterParameter.getEffectiveDateFrom(), dateInString), SearchOperation.EQUAL));
        }

        if (documentCenterParameter.getEffectiveDateTo() != null) {
            genericSpecification.add(new SearchCriteria("effectiveDateTo", StringUtil.stringToDate(documentCenterParameter.getEffectiveDateTo(), dateInString), SearchOperation.EQUAL));
        }

        if (documentCenterParameter.getCreatedDateFrom() != null) {
            genericSpecification.add(new SearchCriteria("createdDate", StringUtil.stringToDate(documentCenterParameter.getCreatedDateFrom(), dateInString), SearchOperation.GREATER_THAN_EQUAL));
        }

        if (documentCenterParameter.getCreatedDateTo() != null) {
            genericSpecification.add(new SearchCriteria("createdDate", StringUtil.stringToDate(documentCenterParameter.getCreatedDateTo(), dateInString), SearchOperation.LESS_THAN_EQUAL));
        }

        if (documentCenterParameter.getUpdatedDateFrom() != null) {
            genericSpecification.add(new SearchCriteria("updatedDate", StringUtil.stringToDate(documentCenterParameter.getUpdatedDateFrom(), dateInString), SearchOperation.GREATER_THAN_EQUAL));
        }

        if (documentCenterParameter.getUpdatedDateTo() != null) {
            genericSpecification.add(new SearchCriteria("updatedDate", StringUtil.stringToDate(documentCenterParameter.getUpdatedDateTo(), dateInString), SearchOperation.LESS_THAN_EQUAL));
        }

        if(documentCenterParameter.getIsPin() != null){
            genericSpecification.add(new SearchCriteria("isPin", documentCenterParameter.getIsPin(),SearchOperation.MATCH));
        }

        if(documentCenterParameter.getIsPromo() != null){
            genericSpecification.add(new SearchCriteria("isPromo", documentCenterParameter.getIsPromo(),SearchOperation.MATCH));
        }

        if(documentCenterParameter.getIfaCaIndicator() != null){
            genericSpecification.add(new SearchCriteria("ifaCaIndicator", documentCenterParameter.getIfaCaIndicator(),SearchOperation.MATCH));
        }

        if(documentCenterParameter.getVisibilityList()!=null){
            List visibilityList = Arrays.asList(documentCenterParameter.getVisibilityList());
            if(!visibilityList.isEmpty()){
                genericSpecification.add(new SearchCriteria("agentCode", visibilityList,SearchOperation.EXIST_VISIBILITY_LIST));
            }
        }


        return (GenericSpecification<Object>) genericSpecification;

    }

    public GenericSpecification<Object> setCampaignListWhereClause (RequestParameter requestParameter) throws ParseException {

        GenericSpecification<?> genericSpecification = new GenericSpecification<>();
        var userParameter = requestParameter.getUserParameter();
        CampaignListParameter campaignParameter = requestParameter.getCampaignListParameter();


        if (campaignParameter.getCampaignCode() != null)
            genericSpecification.add(new SearchCriteria("campaignCode", campaignParameter.getCampaignCode(), SearchOperation.MATCH));

        if (campaignParameter.getCampaignName() != null){
            genericSpecification.add(new SearchCriteria("campaignNameEng;campaignNameZHTW;campaignNameZHCN", campaignParameter.getCampaignName(), SearchOperation.GROUP_OR));
        }


        // for external user
        if (!requestParameter.getUserParameter().getRole().equals("internal-admin")){
            genericSpecification.add(new SearchCriteria(servAgentCode, userParameter.getBrokerCode(), SearchOperation.EXIST_CAMPAIGN));
            // for broker agent user
            if(!requestParameter.getUserParameter().getIfaIdentity().equals("ADMIN") ){
                genericSpecification.add(new SearchCriteria("trCode", requestParameter.getUserParameter().getLoginName(), SearchOperation.EQUAL));
            }
        }
        return (GenericSpecification<Object>) genericSpecification;

    }

}
