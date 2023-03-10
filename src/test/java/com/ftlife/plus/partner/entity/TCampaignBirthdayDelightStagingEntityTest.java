package com.ftlife.plus.partner.entity;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TCampaignBirthdayDelightStagingEntityTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);

    public TCampaignBirthdayDelightStagingEntityTest() throws ParseException {
    }

    @Test
    public void testPojo(){
        TCampaignBirthdayDelightStagingEntity tCampaignBirthdayDelightStagingEntity = new TCampaignBirthdayDelightStagingEntity();
        tCampaignBirthdayDelightStagingEntity.setCampaignBirthdayDelightStagingId(1123);
        tCampaignBirthdayDelightStagingEntity.setDateOfBirth(date);
        tCampaignBirthdayDelightStagingEntity.setBatchNumber("batchNumber");
        tCampaignBirthdayDelightStagingEntity.setBatchStatus("batchStatus");

        assertEquals(1123, tCampaignBirthdayDelightStagingEntity.getCampaignBirthdayDelightStagingId());
        assertEquals(date, tCampaignBirthdayDelightStagingEntity.getDateOfBirth());
        assertEquals("batchNumber", tCampaignBirthdayDelightStagingEntity.getBatchNumber());
        assertEquals("batchStatus", tCampaignBirthdayDelightStagingEntity.getBatchStatus());

    }
}
