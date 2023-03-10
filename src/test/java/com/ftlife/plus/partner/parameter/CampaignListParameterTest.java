package com.ftlife.plus.partner.parameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CampaignListParameterTest {
    @Test
    void testPojo() {
        CampaignListParameter campaignListParameter = new CampaignListParameter();
        campaignListParameter.setCampaignCode("a");
        campaignListParameter.setCampaignName("a");

        assertEquals("a",campaignListParameter.getCampaignCode());
        assertEquals("a",campaignListParameter.getCampaignName());


    }
}
