package com.ftlife.plus.partner.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VCampaignHeaderBrokerEntityTest {
    @Test
    public void testPojo(){
        VCampaignHeaderBrokerEntity vCampaignHeaderBrokerEntity = new VCampaignHeaderBrokerEntity();
        vCampaignHeaderBrokerEntity.setCampaignHeaderId(1);
        vCampaignHeaderBrokerEntity.setServAgentCode("a");
        assertEquals(1, vCampaignHeaderBrokerEntity.getCampaignHeaderId());
        assertEquals("a", vCampaignHeaderBrokerEntity.getServAgentCode());
    }
}
