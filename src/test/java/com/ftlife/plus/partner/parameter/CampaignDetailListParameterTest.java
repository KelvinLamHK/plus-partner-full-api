package com.ftlife.plus.partner.parameter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CampaignDetailListParameterTest {

    @Test
    public void testPojo() {
        CampaignDetailParameter a1 = new CampaignDetailParameter();
        CampaignDetailParameter a2 = new CampaignDetailParameter();
        List<CampaignDetailParameter> campaignDetailParameterList = new ArrayList<CampaignDetailParameter>();
        campaignDetailParameterList.add(a1);
        campaignDetailParameterList.add(a2);
        CampaignDetailListParameter CampaignDetailListParameter = new CampaignDetailListParameter();
        CampaignDetailListParameter.setCampaignHeaderId("a");
        CampaignDetailListParameter.setCampaignDetailList(campaignDetailParameterList);

        assertEquals("a", CampaignDetailListParameter.getCampaignHeaderId());
        assertEquals(campaignDetailParameterList.get(0), CampaignDetailListParameter.getCampaignDetailList().get(0));
    }

}
