package com.ftlife.plus.partner.parameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CampaignHeaderParameterTest {
    @Test
    void testPojo()  {

        CampaignHeaderParameter campaignHeaderParameter = new CampaignHeaderParameter();
        campaignHeaderParameter.setCampaignHeaderId("a");
        campaignHeaderParameter.setCampaignCode("a");
        campaignHeaderParameter.setCampaignNameEng("a");
        campaignHeaderParameter.setCampaignNameZHTW("a");
        campaignHeaderParameter.setCampaignNameZHCN("a");
        campaignHeaderParameter.setIfaCaIndicator("a");
        campaignHeaderParameter.setRemark("a");
        campaignHeaderParameter.setThumbnailDocID("a");
        campaignHeaderParameter.setCampaignStartDate("a");
        campaignHeaderParameter.setCampaignEndDate("a");


        assertEquals("a",campaignHeaderParameter.getCampaignHeaderId());
        assertEquals("a",campaignHeaderParameter.getCampaignCode());
        assertEquals("a",campaignHeaderParameter.getCampaignNameEng());
        assertEquals("a",campaignHeaderParameter.getCampaignNameZHTW());
        assertEquals("a",campaignHeaderParameter.getCampaignNameZHCN());
        assertEquals("a",campaignHeaderParameter.getIfaCaIndicator());
        assertEquals("a",campaignHeaderParameter.getRemark());
        assertEquals("a",campaignHeaderParameter.getThumbnailDocID());
        assertEquals("a",campaignHeaderParameter.getCampaignEndDate());

    }
}
