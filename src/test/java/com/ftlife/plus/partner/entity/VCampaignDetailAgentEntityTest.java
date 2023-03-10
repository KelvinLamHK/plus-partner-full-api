package com.ftlife.plus.partner.entity;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VCampaignDetailAgentEntityTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);
    String dateInString2 = "2022-01-02";
    Date date2 = formatter.parse(dateInString2);
    String dateInString3 = "2022-01-03";
    Date date3 = formatter.parse(dateInString3);


    public VCampaignDetailAgentEntityTest() throws ParseException {
    }

    @Test
    public void testPojo(){
        VCampaignDetailAgentEntity vCampaignDetailAgentEntity = new VCampaignDetailAgentEntity();
        vCampaignDetailAgentEntity.setCampaignDetailId(123);
        vCampaignDetailAgentEntity.setCampaignHeaderId(999);
        vCampaignDetailAgentEntity.setTrCode("trCode");
        vCampaignDetailAgentEntity.setCreatedDate(date);
        vCampaignDetailAgentEntity.setUpdatedDate(date2);
        vCampaignDetailAgentEntity.setCreatedBy("createdBy");
        vCampaignDetailAgentEntity.setUpdatedBy("updatedBy");
        vCampaignDetailAgentEntity.setRemark("remark");
        vCampaignDetailAgentEntity.setDateOfBirth(date3);
        assertEquals(123,vCampaignDetailAgentEntity.getCampaignDetailId() );
        assertEquals(999, vCampaignDetailAgentEntity.getCampaignHeaderId());
        assertEquals("trCode", vCampaignDetailAgentEntity.getTrCode());
        assertEquals(date, vCampaignDetailAgentEntity.getCreatedDate());
        assertEquals(date2, vCampaignDetailAgentEntity.getUpdatedDate());
        assertEquals("createdBy", vCampaignDetailAgentEntity.getCreatedBy());
        assertEquals("updatedBy", vCampaignDetailAgentEntity.getUpdatedBy());
        assertEquals("remark", vCampaignDetailAgentEntity.getRemark());
        assertEquals(date3, vCampaignDetailAgentEntity.getDateOfBirth());
    }
}
