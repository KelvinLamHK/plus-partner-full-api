package com.ftlife.plus.partner.parameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequestParameterTest {
    @Test
    void testPojo() {
        RequestParameter requestParameter = new RequestParameter();
        PolicyListParameter policyListParameter = new PolicyListParameter();
        PageableParameter pageableParameter = new PageableParameter();
        DocumentParameter documentParameter = new DocumentParameter();
        UserParameter userParameter = new UserParameter();
        CampaignListParameter campaignListParameter = new CampaignListParameter();
        CampaignHeaderParameter campaignHeaderParameter = new CampaignHeaderParameter();
        CampaignDetailParameter campaignDetailParameter = new CampaignDetailParameter();
        CampaignDetailListParameter campaignDetailListParameter = new CampaignDetailListParameter();

        requestParameter.setPolicyListParameter(policyListParameter);
        requestParameter.setUserParameter(userParameter);
        requestParameter.setDocumentParameter(documentParameter);
        requestParameter.setPageableParameter(pageableParameter);
        requestParameter.setCampaignListParameter(campaignListParameter);
        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
        requestParameter.setCampaignDetailParameter(campaignDetailParameter);
        requestParameter.setCampaignDetailListParameter(campaignDetailListParameter);

        assertEquals(PolicyListParameter.class ,requestParameter.getPolicyListParameter().getClass());
        assertEquals(UserParameter.class ,requestParameter.getUserParameter().getClass());
        assertEquals(DocumentParameter.class ,requestParameter.getDocumentParameter().getClass());
        assertEquals(PageableParameter.class ,requestParameter.getPageableParameter().getClass());
        assertEquals(CampaignListParameter.class ,requestParameter.getCampaignListParameter().getClass());
        assertEquals(CampaignHeaderParameter.class ,requestParameter.getCampaignHeaderParameter().getClass());
        assertEquals(CampaignDetailParameter.class ,requestParameter.getCampaignDetailParameter().getClass());
        assertEquals(CampaignDetailListParameter.class ,requestParameter.getCampaignDetailListParameter().getClass());




    }
}
