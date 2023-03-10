package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.TCampaignBirthdayDelightStagingEntity;
import com.ftlife.plus.partner.parameter.PageableParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.util.QuerySetupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CampaignBirthdayDelightListDtoTest {
    QuerySetupUtil querySetupUtil = new QuerySetupUtil();
    RequestParameter requestParameter = new RequestParameter();
    @Test
    public void testPojo(){
        TCampaignBirthdayDelightStagingEntity tCampaignBirthdayDelightStagingEntity = new TCampaignBirthdayDelightStagingEntity();
        PageableDto pageableDto = new PageableDto();
        List<TCampaignBirthdayDelightStagingEntity> campaignOriginalDetailList = new ArrayList<>();
        campaignOriginalDetailList.add(tCampaignBirthdayDelightStagingEntity);
        var pageableParameter = new PageableParameter();
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(456);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(999);
        requestParameter.setPageableParameter(pageableParameter);

        var pageable = querySetupUtil.setPageable(requestParameter);
        var vCampaignDetailAgentEntityPage = new PageImpl<>(campaignOriginalDetailList,pageable, campaignOriginalDetailList.size()) ;

        CampaignBirthdayDelightListDto campaignBirthdayDelightListDto = new CampaignBirthdayDelightListDto(vCampaignDetailAgentEntityPage);
        assertEquals(pageableParameter.getPageSize(), campaignBirthdayDelightListDto.getPagination().getPageSize());
        assertEquals(pageableParameter.getPageNumber(), campaignBirthdayDelightListDto.getPagination().getPageNumber());
        assertEquals(campaignOriginalDetailList, campaignBirthdayDelightListDto.getCampaignOriginalDetailList());
        campaignBirthdayDelightListDto.setPagination(pageableDto);
        assertEquals(0, campaignBirthdayDelightListDto.getPagination().getPageSize());

        CampaignBirthdayDelightListDto campaignBirthdayDelightListDto1 = new CampaignBirthdayDelightListDto();
        assertEquals(CampaignBirthdayDelightListDto.class, campaignBirthdayDelightListDto1.getClass());

    }
}
