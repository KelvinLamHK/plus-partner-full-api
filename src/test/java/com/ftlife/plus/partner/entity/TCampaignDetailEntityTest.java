package com.ftlife.plus.partner.entity;

import com.ftlife.plus.partner.parameter.CampaignDetailParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.parameter.UserParameter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TCampaignDetailEntityTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);

    public TCampaignDetailEntityTest() throws ParseException {
    }

    @Test
    void testPojoDate()  {
        TCampaignDetailEntity tCampaignDetailEntity = new TCampaignDetailEntity();
        tCampaignDetailEntity.setDateOfBirth(date);
        tCampaignDetailEntity.setLatestPolicyIssueDate(date);
        tCampaignDetailEntity.setFirstPolicyIssueDate(date);
        tCampaignDetailEntity.setPicsIndicatorDate(date);
        tCampaignDetailEntity.setDirectMarketingFtlDate(date);
        tCampaignDetailEntity.setDirectMarketingNwgDate(date);
        tCampaignDetailEntity.setCreatedDate(date);
        tCampaignDetailEntity.setUpdatedDate(date);

        assertEquals(date,tCampaignDetailEntity.getCreatedDate());
        assertEquals(date,tCampaignDetailEntity.getUpdatedDate());
        assertEquals(date,tCampaignDetailEntity.getDirectMarketingNwgDate());
        assertEquals(date,tCampaignDetailEntity.getDirectMarketingFtlDate());
        assertEquals(date,tCampaignDetailEntity.getPicsIndicatorDate());
        assertEquals(date,tCampaignDetailEntity.getFirstPolicyIssueDate());
        assertEquals(date,tCampaignDetailEntity.getLatestPolicyIssueDate());
    }

    @Test
    void testPojoInt()  {
        TCampaignDetailEntity tCampaignDetailEntity = new TCampaignDetailEntity();
        tCampaignDetailEntity.setCampaignDetailId(0);
        tCampaignDetailEntity.setCampaignHeaderId(0);
        tCampaignDetailEntity.setPartyId(0);
        tCampaignDetailEntity.setNoOfInForcePolicy(0);
        tCampaignDetailEntity.setLastYearPremium(BigDecimal.valueOf(0));
        tCampaignDetailEntity.setThisYearPremium(BigDecimal.valueOf(0));

        assertEquals(0,tCampaignDetailEntity.getPartyId());
        assertEquals(0,tCampaignDetailEntity.getCampaignDetailId());
        assertEquals(0,tCampaignDetailEntity.getCampaignHeaderId());
        assertEquals(0,tCampaignDetailEntity.getNoOfInForcePolicy());
        assertEquals("0",tCampaignDetailEntity.getLastYearPremium().toString());
        assertEquals("0",tCampaignDetailEntity.getThisYearPremium().toString());
    }

    @Test
    void testPojo()  {
        TCampaignDetailEntity tCampaignDetailEntity = new TCampaignDetailEntity();
        tCampaignDetailEntity.setMailingAddress1("a");
        tCampaignDetailEntity.setMailingAddress2("a");
        tCampaignDetailEntity.setMailingAddress3("a");
        tCampaignDetailEntity.setMailingAddress4("a");
        tCampaignDetailEntity.setMailingAddress5("a");
        tCampaignDetailEntity.setOptOut("a");
        tCampaignDetailEntity.setPicsIndicator("a");
        tCampaignDetailEntity.setDirectMarketingFtl("a");
        tCampaignDetailEntity.setDirectMarketingNwg("a");
        tCampaignDetailEntity.setBd("a");
        tCampaignDetailEntity.setHaveP10Account("a");
        tCampaignDetailEntity.setCommunicationChannel("a");
        tCampaignDetailEntity.setServicingAgentMobile("a");
        tCampaignDetailEntity.setServicingAgentEmail("a");
        tCampaignDetailEntity.setServicingAgentStatus("a");
        tCampaignDetailEntity.setOptIn("a");
        tCampaignDetailEntity.setRemark("a");
        tCampaignDetailEntity.setCreatedBy("a");
        tCampaignDetailEntity.setUpdatedBy("a");

        assertEquals("a",tCampaignDetailEntity.getMailingAddress1());
        assertEquals("a",tCampaignDetailEntity.getMailingAddress2());
        assertEquals("a",tCampaignDetailEntity.getMailingAddress3());
        assertEquals("a",tCampaignDetailEntity.getMailingAddress4());
        assertEquals("a",tCampaignDetailEntity.getMailingAddress5());
        assertEquals("a",tCampaignDetailEntity.getOptOut());
        assertEquals("a",tCampaignDetailEntity.getPicsIndicator());
        assertEquals("a",tCampaignDetailEntity.getDirectMarketingFtl());
        assertEquals("a",tCampaignDetailEntity.getDirectMarketingNwg());
        assertEquals("a",tCampaignDetailEntity.getBd());
        assertEquals("a",tCampaignDetailEntity.getHaveP10Account());
        assertEquals("a",tCampaignDetailEntity.getCommunicationChannel());
        assertEquals("a",tCampaignDetailEntity.getServicingAgentMobile());
        assertEquals("a",tCampaignDetailEntity.getServicingAgentEmail());
        assertEquals("a",tCampaignDetailEntity.getServicingAgentStatus());
        assertEquals("a",tCampaignDetailEntity.getOptIn());
        assertEquals("a",tCampaignDetailEntity.getRemark());
        assertEquals("a",tCampaignDetailEntity.getCreatedBy());
        assertEquals("a",tCampaignDetailEntity.getUpdatedBy());
    }

    @Test
    void testPojo2()  {
        TCampaignDetailEntity tCampaignDetailEntity = new TCampaignDetailEntity();
        tCampaignDetailEntity.setClientFullNameEng("a");
        tCampaignDetailEntity.setClientFullNameChi("a");
        tCampaignDetailEntity.setClientId("a");
        tCampaignDetailEntity.setClientGender("a");
        tCampaignDetailEntity.setBirthdayMonth("a");
        tCampaignDetailEntity.setLanguageForCommunication("a");
        tCampaignDetailEntity.setDeathClaim("a");
        tCampaignDetailEntity.setLatestIssuedPolicy("a");
        tCampaignDetailEntity.setSalesChannel("a");
        tCampaignDetailEntity.setProduceAgent1Region("a");
        tCampaignDetailEntity.setProduceAgent1Code("a");
        tCampaignDetailEntity.setProduceAgent1Name("a");
        tCampaignDetailEntity.setProduceAgent2Region("a");
        tCampaignDetailEntity.setProduceAgent2Code("a");
        tCampaignDetailEntity.setProduceAgent2Name("a");
        tCampaignDetailEntity.setServAgentRegion("a");
        tCampaignDetailEntity.setServAgentRegionName("a");
        tCampaignDetailEntity.setServAgentDistrictCode("a");
        tCampaignDetailEntity.setServAgentEmail("a");
        tCampaignDetailEntity.setServAgentCode("a");
        tCampaignDetailEntity.setServAgentName("a");
        tCampaignDetailEntity.setSalesManager1("a");
        tCampaignDetailEntity.setMobileAreaCode("a");
        tCampaignDetailEntity.setMobile("a");
        tCampaignDetailEntity.setValidity("a");
        tCampaignDetailEntity.setEmail("a");
        tCampaignDetailEntity.setMailAddressAreaCode("a");
        tCampaignDetailEntity.setForeignIndicator("a");

        assertEquals("a", tCampaignDetailEntity.getClientFullNameEng());
        assertEquals("a", tCampaignDetailEntity.getClientFullNameChi());
        assertEquals("a", tCampaignDetailEntity.getClientId());
        assertEquals("a", tCampaignDetailEntity.getClientGender());
        assertEquals("a", tCampaignDetailEntity.getBirthdayMonth());
        assertEquals("a", tCampaignDetailEntity.getLanguageForCommunication());
        assertEquals("a", tCampaignDetailEntity.getDeathClaim());
        assertEquals("a",tCampaignDetailEntity.getLatestIssuedPolicy());
        assertEquals("a",tCampaignDetailEntity.getSalesChannel());
        assertEquals("a",tCampaignDetailEntity.getProduceAgent1Region());
        assertEquals("a",tCampaignDetailEntity.getProduceAgent1Code());
        assertEquals("a",tCampaignDetailEntity.getProduceAgent1Name());
        assertEquals("a",tCampaignDetailEntity.getProduceAgent2Region());
        assertEquals("a",tCampaignDetailEntity.getProduceAgent2Code());
        assertEquals("a",tCampaignDetailEntity.getProduceAgent2Name());
        assertEquals("a",tCampaignDetailEntity.getServAgentRegion());
        assertEquals("a",tCampaignDetailEntity.getServAgentRegionName());
        assertEquals("a",tCampaignDetailEntity.getServAgentDistrictCode());
        assertEquals("a",tCampaignDetailEntity.getServAgentEmail());
        assertEquals("a",tCampaignDetailEntity.getServAgentCode());
        assertEquals("a",tCampaignDetailEntity.getServAgentName());
        assertEquals("a",tCampaignDetailEntity.getSalesManager1());
        assertEquals("a",tCampaignDetailEntity.getMobile());
        assertEquals("a",tCampaignDetailEntity.getMobileAreaCode());
        assertEquals("a",tCampaignDetailEntity.getValidity());
        assertEquals("a",tCampaignDetailEntity.getEmail());
        assertEquals("a",tCampaignDetailEntity.getMailAddressAreaCode());
        assertEquals("a",tCampaignDetailEntity.getForeignIndicator());

    }
    
    @Test
    public void testTCampaignDetailEntity() throws ParseException {
    	 CampaignDetailParameter campaignDetailParameter = new CampaignDetailParameter();
         UserParameter userParameter = new UserParameter();
         RequestParameter requestParameter = new RequestParameter();
         requestParameter.setCampaignDetailParameter(campaignDetailParameter);
         requestParameter.setUserParameter(userParameter);
         
         campaignDetailParameter.setCampaignDetailId("0");
         campaignDetailParameter.setCampaignHeaderId("0");
         campaignDetailParameter.setClientFullNameEng("a");
         campaignDetailParameter.setClientFullNameChi("a");
         campaignDetailParameter.setClientId("a");
         campaignDetailParameter.setPartyId("0");
         campaignDetailParameter.setClientGender("a");
         campaignDetailParameter.setDateOfBirth("2022-01-01");
         campaignDetailParameter.setBirthdayMonth("a");
         campaignDetailParameter.setLanguageForCommunication("a");
         campaignDetailParameter.setDeathClaim("a");
         campaignDetailParameter.setLatestPolicyIssueDate("2022-01-01");
         campaignDetailParameter.setFirstPolicyIssueDate("2022-01-01");
         campaignDetailParameter.setLatestIssuedPolicy("a");
         campaignDetailParameter.setNoOfInForcePolicy("0");
         campaignDetailParameter.setLastYearPremium("0");
         campaignDetailParameter.setThisYearPremium("0");
         campaignDetailParameter.setSalesChannel("a");
         campaignDetailParameter.setProduceAgent1Region("a");
         campaignDetailParameter.setProduceAgent1Code("a");
         campaignDetailParameter.setProduceAgent1Name("a");
         campaignDetailParameter.setProduceAgent2Region("a");
         campaignDetailParameter.setProduceAgent2Code("a");
         campaignDetailParameter.setProduceAgent2Name("a");
         campaignDetailParameter.setServAgentRegion("a");
         campaignDetailParameter.setServAgentRegionName("a");
         campaignDetailParameter.setServAgentDistrictCode("a");
         campaignDetailParameter.setServAgentEmail("a");
         campaignDetailParameter.setServAgentCode("a");
         campaignDetailParameter.setServAgentName("a");
         campaignDetailParameter.setSalesManager1("a");
         campaignDetailParameter.setMobileAreaCode("a");
         campaignDetailParameter.setMobile("a");
         campaignDetailParameter.setValidity("a");
         campaignDetailParameter.setEmail("a");
         campaignDetailParameter.setMailAddressAreaCode("a");
         campaignDetailParameter.setForeignIndicator("a");
         campaignDetailParameter.setMailingAddress1("a");
         campaignDetailParameter.setMailingAddress2("a");
         campaignDetailParameter.setMailingAddress3("a");
         campaignDetailParameter.setMailingAddress4("a");
         campaignDetailParameter.setMailingAddress5("a");
         campaignDetailParameter.setOptOut("a");
         campaignDetailParameter.setPicsIndicator("a");
         campaignDetailParameter.setPicsIndicatorDate("2022-01-01");
         campaignDetailParameter.setDirectMarketingFtl("a");
         campaignDetailParameter.setDirectMarketingFtlDate("2022-01-01");
         campaignDetailParameter.setDirectMarketingNwg("a");
         campaignDetailParameter.setDirectMarketingNwgDate("2022-01-01");
         campaignDetailParameter.setBd("a");
         campaignDetailParameter.setHaveP10Account("a");
         campaignDetailParameter.setCommunicationChannel("a");
         campaignDetailParameter.setServicingAgentMobile("a");
         campaignDetailParameter.setServicingAgentEmail("a");
         campaignDetailParameter.setServicingAgentStatus("a");
         campaignDetailParameter.setOptIn("a");
         campaignDetailParameter.setRemark("a");
         campaignDetailParameter.setCreatedDate("2022-01-01");
         campaignDetailParameter.setUpdatedDate("2022-01-01");
         campaignDetailParameter.setCreatedBy("a");
         campaignDetailParameter.setUpdatedBy("a");
         campaignDetailParameter.setCreatedDateFrom("2022-01-01");
         userParameter.setLoginName("a");


         requestParameter.setCampaignDetailParameter(campaignDetailParameter);
         requestParameter.setUserParameter(userParameter);
         
         TCampaignDetailEntity tCampaignDetailEntity = new TCampaignDetailEntity(requestParameter);
         tCampaignDetailEntity.setCreatedDate(date);
         tCampaignDetailEntity.setUpdatedDate(date);
         
         assertEquals(date,tCampaignDetailEntity.getCreatedDate());
         assertEquals(date,tCampaignDetailEntity.getUpdatedDate());
         assertEquals(date,tCampaignDetailEntity.getDirectMarketingNwgDate());
         assertEquals(date,tCampaignDetailEntity.getDirectMarketingFtlDate());
         assertEquals(date,tCampaignDetailEntity.getPicsIndicatorDate());
         assertEquals(date,tCampaignDetailEntity.getFirstPolicyIssueDate());
         assertEquals(date,tCampaignDetailEntity.getLatestPolicyIssueDate());


         assertEquals(0,tCampaignDetailEntity.getPartyId());
         assertEquals(0,tCampaignDetailEntity.getCampaignDetailId());
         assertEquals(0,tCampaignDetailEntity.getCampaignHeaderId());
         assertEquals(0,tCampaignDetailEntity.getNoOfInForcePolicy());
         assertEquals("0",tCampaignDetailEntity.getLastYearPremium().toString());
         assertEquals("0",tCampaignDetailEntity.getThisYearPremium().toString());

         assertEquals("a", tCampaignDetailEntity.getClientFullNameEng());
         assertEquals("a", tCampaignDetailEntity.getClientFullNameChi());
         assertEquals("a", tCampaignDetailEntity.getClientId());
         assertEquals("a", tCampaignDetailEntity.getClientGender());
         assertEquals(date, tCampaignDetailEntity.getDateOfBirth());
         assertEquals("a", tCampaignDetailEntity.getBirthdayMonth());
         assertEquals("a", tCampaignDetailEntity.getLanguageForCommunication());
         assertEquals("a", tCampaignDetailEntity.getDeathClaim());
         assertEquals("a",tCampaignDetailEntity.getLatestIssuedPolicy());
         assertEquals("a",tCampaignDetailEntity.getSalesChannel());
         assertEquals("a",tCampaignDetailEntity.getProduceAgent1Region());
         assertEquals("a",tCampaignDetailEntity.getProduceAgent1Code());
         assertEquals("a",tCampaignDetailEntity.getProduceAgent1Name());
         assertEquals("a",tCampaignDetailEntity.getProduceAgent2Region());
         assertEquals("a",tCampaignDetailEntity.getProduceAgent2Code());
         assertEquals("a",tCampaignDetailEntity.getProduceAgent2Name());
         assertEquals("a",tCampaignDetailEntity.getServAgentRegion());
         assertEquals("a",tCampaignDetailEntity.getServAgentRegionName());
         assertEquals("a",tCampaignDetailEntity.getServAgentDistrictCode());
         assertEquals("a",tCampaignDetailEntity.getServAgentEmail());
         assertEquals("a",tCampaignDetailEntity.getServAgentCode());
         assertEquals("a",tCampaignDetailEntity.getServAgentName());
         assertEquals("a",tCampaignDetailEntity.getSalesManager1());
         assertEquals("a",tCampaignDetailEntity.getMobile());
         assertEquals("a",tCampaignDetailEntity.getMobileAreaCode());
         assertEquals("a",tCampaignDetailEntity.getValidity());
         assertEquals("a",tCampaignDetailEntity.getEmail());
         assertEquals("a",tCampaignDetailEntity.getMailAddressAreaCode());
         assertEquals("a",tCampaignDetailEntity.getForeignIndicator());
         assertEquals("a",tCampaignDetailEntity.getMailingAddress1());
         assertEquals("a",tCampaignDetailEntity.getMailingAddress2());
         assertEquals("a",tCampaignDetailEntity.getMailingAddress3());
         assertEquals("a",tCampaignDetailEntity.getMailingAddress4());
         assertEquals("a",tCampaignDetailEntity.getMailingAddress5());
         assertEquals("a",tCampaignDetailEntity.getOptOut());
         assertEquals("a",tCampaignDetailEntity.getPicsIndicator());
         assertEquals("a",tCampaignDetailEntity.getDirectMarketingFtl());
         assertEquals("a",tCampaignDetailEntity.getDirectMarketingNwg());
         assertEquals("a",tCampaignDetailEntity.getBd());
         assertEquals("a",tCampaignDetailEntity.getHaveP10Account());
         assertEquals("a",tCampaignDetailEntity.getCommunicationChannel());
         assertEquals("a",tCampaignDetailEntity.getServicingAgentMobile());
         assertEquals("a",tCampaignDetailEntity.getServicingAgentEmail());
         assertEquals("a",tCampaignDetailEntity.getServicingAgentStatus());
         assertEquals("a",tCampaignDetailEntity.getOptIn());
         assertEquals("a",tCampaignDetailEntity.getRemark());
         assertEquals("a",tCampaignDetailEntity.getCreatedBy());
         assertEquals("a",tCampaignDetailEntity.getUpdatedBy());

        campaignDetailParameter.setNoOfInForcePolicy(null);
        requestParameter.setCampaignDetailParameter(campaignDetailParameter);
        TCampaignDetailEntity tCampaignDetailEntity1 = new TCampaignDetailEntity(requestParameter);
        assertEquals(0,tCampaignDetailEntity.getNoOfInForcePolicy());

    }

    @Test
    public void testConvertTCampaignBirthdayDelightStagingEntityToTCampaignDetailEntity() throws ParseException {
        TCampaignDetailEntity tCampaignDetailEntity1 = new TCampaignDetailEntity();
        TCampaignBirthdayDelightStagingEntity tCampaignBirthdayDelightStagingEntity = new TCampaignBirthdayDelightStagingEntity();
        tCampaignBirthdayDelightStagingEntity.setCampaignBirthdayDelightStagingId(1123);
        tCampaignBirthdayDelightStagingEntity.setDateOfBirth(date);
        tCampaignBirthdayDelightStagingEntity.setBatchNumber("batchNumber");
        tCampaignBirthdayDelightStagingEntity.setBatchStatus("batchStatus");
        tCampaignBirthdayDelightStagingEntity.setClientFullNameEng("a");
        tCampaignBirthdayDelightStagingEntity.setClientFullNameChi("a");
        tCampaignBirthdayDelightStagingEntity.setClientId("1");
        tCampaignBirthdayDelightStagingEntity.setPartyId(2);
        tCampaignBirthdayDelightStagingEntity.setClientGender("a");
        tCampaignBirthdayDelightStagingEntity.setDateOfBirth(date);
        tCampaignBirthdayDelightStagingEntity.setBirthdayMonth("a");
        tCampaignBirthdayDelightStagingEntity.setLanguageForCommunication("a");
        tCampaignBirthdayDelightStagingEntity.setDeathClaim("a");
        tCampaignBirthdayDelightStagingEntity.setLatestPolicyIssueDate(date);
        tCampaignBirthdayDelightStagingEntity.setFirstPolicyIssueDate(date);
        tCampaignBirthdayDelightStagingEntity.setLatestIssuedPolicy("a");
        tCampaignBirthdayDelightStagingEntity.setNoOfInForcePolicy(1);

        tCampaignBirthdayDelightStagingEntity.setSalesChannel("a");
        tCampaignBirthdayDelightStagingEntity.setProduceAgent1Region("a");
        tCampaignBirthdayDelightStagingEntity.setProduceAgent1Code("a");
        tCampaignBirthdayDelightStagingEntity.setProduceAgent1Name("a");
        tCampaignBirthdayDelightStagingEntity.setProduceAgent2Region("a");
        tCampaignBirthdayDelightStagingEntity.setProduceAgent2Code("a");
        tCampaignBirthdayDelightStagingEntity.setProduceAgent2Name("a");
        tCampaignBirthdayDelightStagingEntity.setServAgentRegion("a");
        tCampaignBirthdayDelightStagingEntity.setServAgentRegionName("a");
        tCampaignBirthdayDelightStagingEntity.setServAgentDistrictCode("a");
        tCampaignBirthdayDelightStagingEntity.setServAgentEmail("a");
        tCampaignBirthdayDelightStagingEntity.setServAgentCode("a");
        tCampaignBirthdayDelightStagingEntity.setServAgentName("a");
        tCampaignBirthdayDelightStagingEntity.setSalesManager1("a");
        tCampaignBirthdayDelightStagingEntity.setMobileAreaCode("a");
        tCampaignBirthdayDelightStagingEntity.setMobile("a");
        tCampaignBirthdayDelightStagingEntity.setValidity("a");
        tCampaignBirthdayDelightStagingEntity.setEmail("a");
        tCampaignBirthdayDelightStagingEntity.setMailAddressAreaCode("a");
        tCampaignBirthdayDelightStagingEntity.setForeignIndicator("a");
        tCampaignBirthdayDelightStagingEntity.setMailingAddress1("a");
        tCampaignBirthdayDelightStagingEntity.setMailingAddress2("a");
        tCampaignBirthdayDelightStagingEntity.setMailingAddress3("a");
        tCampaignBirthdayDelightStagingEntity.setMailingAddress4("a");
        tCampaignBirthdayDelightStagingEntity.setMailingAddress5("a");
        tCampaignBirthdayDelightStagingEntity.setOptOut("a");
        tCampaignBirthdayDelightStagingEntity.setPicsIndicator("a");
        tCampaignBirthdayDelightStagingEntity.setPicsIndicatorDate(date);
        tCampaignBirthdayDelightStagingEntity.setDirectMarketingFtl("a");
        tCampaignBirthdayDelightStagingEntity.setDirectMarketingFtlDate(date);
        tCampaignBirthdayDelightStagingEntity.setDirectMarketingNwg("a");
        tCampaignBirthdayDelightStagingEntity.setDirectMarketingNwgDate(date);
        tCampaignBirthdayDelightStagingEntity.setBd("a");
        tCampaignBirthdayDelightStagingEntity.setHaveP10Account("a");
        tCampaignBirthdayDelightStagingEntity.setCommunicationChannel("a");
        tCampaignBirthdayDelightStagingEntity.setServicingAgentMobile("a");
        tCampaignBirthdayDelightStagingEntity.setServicingAgentEmail("a");
        tCampaignBirthdayDelightStagingEntity.setServicingAgentStatus("a");
        tCampaignBirthdayDelightStagingEntity.setOptIn("a");

        List<TCampaignBirthdayDelightStagingEntity> tCampaignBirthdayDelightStagingEntityList = new ArrayList<>();
        tCampaignBirthdayDelightStagingEntityList.add(tCampaignBirthdayDelightStagingEntity);
        long tCampaignHeaderId = 5;
        tCampaignDetailEntity1.convertTCampaignBirthdayDelightStagingEntityToTCampaignDetailEntity(tCampaignBirthdayDelightStagingEntityList, tCampaignHeaderId);
    }
}
