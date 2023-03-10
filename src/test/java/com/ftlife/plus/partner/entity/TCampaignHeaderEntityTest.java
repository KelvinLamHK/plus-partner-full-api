package com.ftlife.plus.partner.entity;

import com.ftlife.plus.partner.parameter.CampaignHeaderParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.parameter.UserParameter;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TCampaignHeaderEntityTest {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);

    public TCampaignHeaderEntityTest() throws ParseException {
    }

    @Test
    void testPojo() throws ParseException {
        TCampaignHeaderEntity tCampaignHeaderEntity = new TCampaignHeaderEntity();
        tCampaignHeaderEntity.setCampaignHeaderId(0);
        tCampaignHeaderEntity.setCampaignCode("a");
        tCampaignHeaderEntity.setCampaignNameEng("a");
        tCampaignHeaderEntity.setCampaignNameZHTW("a");
        tCampaignHeaderEntity.setCampaignNameZHCN("a");
        tCampaignHeaderEntity.setIfaCaIndicator("a");
        tCampaignHeaderEntity.setRemark("a");
        tCampaignHeaderEntity.setCampaignStartDate(date);
        tCampaignHeaderEntity.setCampaignEndDate(date);
        tCampaignHeaderEntity.setThumbnailDocID(0);
        tCampaignHeaderEntity.setCreatedDate(date);
        tCampaignHeaderEntity.setUpdatedDate(date);
        tCampaignHeaderEntity.setCreatedBy("a");
        tCampaignHeaderEntity.setUpdatedBy("a");


        assertEquals(date,tCampaignHeaderEntity.getCampaignStartDate());
        assertEquals(date,tCampaignHeaderEntity.getCampaignEndDate());
        assertEquals(date,tCampaignHeaderEntity.getCreatedDate());
        assertEquals(date,tCampaignHeaderEntity.getUpdatedDate());

        assertEquals(0,tCampaignHeaderEntity.getCampaignHeaderId());
        assertEquals(0,tCampaignHeaderEntity.getThumbnailDocID());

        assertEquals("a",tCampaignHeaderEntity.getCampaignCode());
        assertEquals("a",tCampaignHeaderEntity.getCampaignNameEng());
        assertEquals("a",tCampaignHeaderEntity.getCampaignNameZHTW());
        assertEquals("a",tCampaignHeaderEntity.getCampaignNameZHCN());
        assertEquals("a",tCampaignHeaderEntity.getIfaCaIndicator());
        assertEquals("a",tCampaignHeaderEntity.getRemark());
        assertEquals("a",tCampaignHeaderEntity.getCreatedBy());
        assertEquals("a",tCampaignHeaderEntity.getUpdatedBy());

        CampaignHeaderParameter campaignHeaderParameter = new CampaignHeaderParameter();
        UserParameter userParameter = new UserParameter();
        RequestParameter requestParameter = new RequestParameter();
        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
        requestParameter.setUserParameter(userParameter);

        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
        requestParameter.setUserParameter(userParameter);


        TCampaignHeaderEntity tCampaignHeaderNullEntity = new TCampaignHeaderEntity(requestParameter);
        tCampaignHeaderNullEntity.setCreatedDate(date);
        tCampaignHeaderNullEntity.setUpdatedDate(date);

        assertEquals(null,tCampaignHeaderNullEntity.getCampaignCode());
    }

    @Test
    void tCampaignHeaderEntityTest() throws ParseException {
        CampaignHeaderParameter campaignHeaderParameter = new CampaignHeaderParameter();
        UserParameter userParameter = new UserParameter();
        RequestParameter requestParameter = new RequestParameter();
        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
        requestParameter.setUserParameter(userParameter);

        campaignHeaderParameter.setCampaignHeaderId(String.valueOf(0));
        campaignHeaderParameter.setCampaignCode("a");
        campaignHeaderParameter.setCampaignNameEng("a");
        campaignHeaderParameter.setCampaignNameZHTW("a");
        campaignHeaderParameter.setCampaignNameZHCN("a");
        campaignHeaderParameter.setIfaCaIndicator("a");
        campaignHeaderParameter.setThumbnailDocID("0");
        campaignHeaderParameter.setRemark("a");
        campaignHeaderParameter.setCampaignStartDate("2022-01-01");
        campaignHeaderParameter.setCampaignEndDate("2022-01-01");




        userParameter.setLoginName("a");


        requestParameter.setCampaignHeaderParameter(campaignHeaderParameter);
        requestParameter.setUserParameter(userParameter);


        TCampaignHeaderEntity tCampaignHeaderEntity = new TCampaignHeaderEntity(requestParameter);
        tCampaignHeaderEntity.setCreatedDate(date);
        tCampaignHeaderEntity.setUpdatedDate(date);




        assertEquals(date,tCampaignHeaderEntity.getCampaignStartDate());
        assertEquals(date,tCampaignHeaderEntity.getCampaignEndDate());
        assertEquals(date,tCampaignHeaderEntity.getCreatedDate());
        assertEquals(date,tCampaignHeaderEntity.getUpdatedDate());

        assertEquals(0,tCampaignHeaderEntity.getCampaignHeaderId());
        assertEquals(0,tCampaignHeaderEntity.getThumbnailDocID());

        assertEquals("a",tCampaignHeaderEntity.getCampaignCode());
        assertEquals("a",tCampaignHeaderEntity.getCampaignNameEng());
        assertEquals("a",tCampaignHeaderEntity.getCampaignNameZHTW());
        assertEquals("a",tCampaignHeaderEntity.getCampaignNameZHCN());
        assertEquals("a",tCampaignHeaderEntity.getIfaCaIndicator());
        assertEquals("a",tCampaignHeaderEntity.getRemark());
        assertEquals("a",tCampaignHeaderEntity.getCreatedBy());
        assertEquals("a",tCampaignHeaderEntity.getUpdatedBy());
    }
    
}
