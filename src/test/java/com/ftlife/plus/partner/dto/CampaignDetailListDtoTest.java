package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.VCampaignDetailAgentEntity;
import com.ftlife.plus.partner.parameter.PageableParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.util.QuerySetupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CampaignDetailListDtoTest {

    QuerySetupUtil querySetupUtil = new QuerySetupUtil();

    RequestParameter requestParameter = new RequestParameter();

    @Test
    public void testPojo(){

        var vCampaignDetailAgentEntity = new VCampaignDetailAgentEntity();
        var vCampaignDetailAgentEntityArrayList = new ArrayList<VCampaignDetailAgentEntity>();
        vCampaignDetailAgentEntityArrayList.add(vCampaignDetailAgentEntity);
        var pageableParameter = new PageableParameter();
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(456);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(999);
        requestParameter.setPageableParameter(pageableParameter);

        var pageable = querySetupUtil.setPageable(requestParameter);
        var vCampaignDetailAgentEntityPage = new PageImpl<>(vCampaignDetailAgentEntityArrayList,pageable, vCampaignDetailAgentEntityArrayList.size()) ;

        CampaignDetailListDto campaignDetailListDto = new CampaignDetailListDto(vCampaignDetailAgentEntityPage);

        assertEquals(pageableParameter.getPageSize(), campaignDetailListDto.getPagination().getPageSize());
        assertEquals(pageableParameter.getPageNumber(), campaignDetailListDto.getPagination().getPageNumber());
        assertEquals(vCampaignDetailAgentEntityArrayList, campaignDetailListDto.getCampaignDetailList());
    }
}
