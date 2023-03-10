package com.ftlife.plus.partner.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VCampaignHeaderAgentEntityTest {

    @Test
    public void testPojo(){
        VCampaignHeaderAgentEntity vCampaignHeaderAgentEntity = new VCampaignHeaderAgentEntity();
        vCampaignHeaderAgentEntity.setCampaignHeaderId(1);
        vCampaignHeaderAgentEntity.setServAgentCode("a");
        vCampaignHeaderAgentEntity.setTrCode("a");
        assertEquals(1, vCampaignHeaderAgentEntity.getCampaignHeaderId());
        assertEquals("a", vCampaignHeaderAgentEntity.getServAgentCode());
        assertEquals("a", vCampaignHeaderAgentEntity.getTrCode());
    }
}
