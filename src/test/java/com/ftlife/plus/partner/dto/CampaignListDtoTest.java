package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.TCampaignHeaderEntity;
import com.ftlife.plus.partner.entity.VCampaignHeaderAgentEntity;
import com.ftlife.plus.partner.entity.VCampaignHeaderBrokerEntity;
import com.ftlife.plus.partner.parameter.PageableParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.util.QuerySetupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CampaignListDtoTest {

    QuerySetupUtil querySetupUtil = new QuerySetupUtil();

    RequestParameter requestParameter = new RequestParameter();

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);

    public CampaignListDtoTest() throws ParseException {
    }

    @Test
    void testPojo() {

        var tCampaignHeaderEntity = new TCampaignHeaderEntity();
        var tCampaignHeaderEntityList = new ArrayList<TCampaignHeaderEntity>();
        tCampaignHeaderEntityList.add(tCampaignHeaderEntity);
        var pageableParameter = new PageableParameter();
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(999);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(123);
        requestParameter.setPageableParameter(pageableParameter);

        var pageable = querySetupUtil.setPageable(requestParameter);
        var tCampaignHeaderEntityPage = new PageImpl<>(tCampaignHeaderEntityList, pageable, tCampaignHeaderEntityList.size());
        var campaignListDto = new CampaignListDto(tCampaignHeaderEntityPage);

        assertEquals(pageableParameter.getPageNumber(), campaignListDto.getPagination().getPageNumber());
        assertEquals(pageableParameter.getPageSize(), campaignListDto.getPagination().getPageSize());
    }

    @Test
    public void testNoArgsConstructor(){
        CampaignListDto campaignListDto = new CampaignListDto();
        assertEquals(CampaignListDto.class, campaignListDto.getClass());
    }

    @Test
    void testCampaignListDtoBroker(){

        TCampaignHeaderEntity tCampaignHeaderEntity = new TCampaignHeaderEntity();
        tCampaignHeaderEntity.setCampaignCode("abCompany");
        tCampaignHeaderEntity.setCampaignEndDate(date);
        tCampaignHeaderEntity.setCampaignHeaderId(11);
        tCampaignHeaderEntity.setCampaignNameEng("XXEng");
        tCampaignHeaderEntity.setCampaignNameZHCN("XXCn");
        tCampaignHeaderEntity.setCampaignNameZHTW("XXTw");
        tCampaignHeaderEntity.setCampaignStartDate(date);
        tCampaignHeaderEntity.setCreatedBy("tester");
        tCampaignHeaderEntity.setCreatedDate(date);
        tCampaignHeaderEntity.setIfaCaIndicator("XX1");
        tCampaignHeaderEntity.setRemark("remark");
        tCampaignHeaderEntity.setThumbnailDocID(999);
        tCampaignHeaderEntity.setUpdatedBy("Ke");
        tCampaignHeaderEntity.setUpdatedDate(date);

        TCampaignHeaderEntity tCampaignHeaderEntity1 = new TCampaignHeaderEntity();
        tCampaignHeaderEntity1.setCampaignCode("abCompany");
        tCampaignHeaderEntity1.setCampaignEndDate(date);
        tCampaignHeaderEntity1.setCampaignHeaderId(11);
        tCampaignHeaderEntity1.setCampaignNameEng("XXEng");
        tCampaignHeaderEntity1.setCampaignNameZHCN("XXCn");
        tCampaignHeaderEntity1.setCampaignNameZHTW("XXTw");
        tCampaignHeaderEntity1.setCampaignStartDate(date);
        tCampaignHeaderEntity1.setCreatedBy("tester");
        tCampaignHeaderEntity1.setCreatedDate(date);
        tCampaignHeaderEntity1.setIfaCaIndicator("XX1");
        tCampaignHeaderEntity1.setRemark("remark");
        tCampaignHeaderEntity1.setThumbnailDocID(999);
        tCampaignHeaderEntity1.setUpdatedBy("Ke");
        tCampaignHeaderEntity1.setUpdatedDate(date);

        var tCampaignHeaderEntityArrayList = new ArrayList<TCampaignHeaderEntity>();
        tCampaignHeaderEntityArrayList.add(tCampaignHeaderEntity);
        tCampaignHeaderEntityArrayList.add(tCampaignHeaderEntity1);
        var pageableParameter = new PageableParameter();
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(123);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(321);
        requestParameter.setPageableParameter(pageableParameter);

        var pageable = querySetupUtil.setPageable(requestParameter);
        var tCampaignHeaderEntityPage = new PageImpl<>(tCampaignHeaderEntityArrayList,pageable, tCampaignHeaderEntityArrayList.size()) ;
        var campaignListDto = new CampaignListDto();
        campaignListDto.campaignListDtoBroker(tCampaignHeaderEntityPage);

        assertEquals(tCampaignHeaderEntity.getCampaignHeaderId(), campaignListDto.getCampaignList().get(0).getCampaignHeaderId());
        assertEquals(tCampaignHeaderEntity.getCampaignCode(), campaignListDto.getCampaignList().get(0).getCampaignCode());
        assertEquals(tCampaignHeaderEntity.getCampaignNameEng(), campaignListDto.getCampaignList().get(0).getCampaignNameEng());
        assertEquals(tCampaignHeaderEntity.getCampaignNameZHTW(), campaignListDto.getCampaignList().get(0).getCampaignNameZHTW());
        assertEquals(tCampaignHeaderEntity.getCampaignNameZHCN(), campaignListDto.getCampaignList().get(0).getCampaignNameZHCN());
        assertEquals(tCampaignHeaderEntity.getIfaCaIndicator(), campaignListDto.getCampaignList().get(0).getIfaCaIndicator());
        assertEquals(tCampaignHeaderEntity.getRemark(), campaignListDto.getCampaignList().get(0).getRemark());
        assertEquals(tCampaignHeaderEntity.getCampaignStartDate(), campaignListDto.getCampaignList().get(0).getCampaignStartDate());
        assertEquals(tCampaignHeaderEntity.getCampaignEndDate(), campaignListDto.getCampaignList().get(0).getCampaignEndDate());
        assertEquals(tCampaignHeaderEntity.getThumbnailDocID(), campaignListDto.getCampaignList().get(0).getThumbnailDocID());
        assertEquals(tCampaignHeaderEntity.getCreatedDate(), campaignListDto.getCampaignList().get(0).getCreatedDate());
        assertEquals(tCampaignHeaderEntity.getUpdatedDate(), campaignListDto.getCampaignList().get(0).getUpdatedDate());
        assertEquals(tCampaignHeaderEntity.getCreatedBy(), campaignListDto.getCampaignList().get(0).getCreatedBy());
        assertEquals(tCampaignHeaderEntity.getUpdatedBy(), campaignListDto.getCampaignList().get(0).getUpdatedBy());
        assertEquals(pageableParameter.getPageNumber(), campaignListDto.getPagination().getPageNumber());
        assertEquals(pageableParameter.getPageSize(), campaignListDto.getPagination().getPageSize());

    }

    @Test
    void testCampaignListDtoAgent(){
        VCampaignHeaderAgentEntity vCampaignHeaderAgentEntity = new VCampaignHeaderAgentEntity();
        vCampaignHeaderAgentEntity.setCampaignCode("abCompany");
        vCampaignHeaderAgentEntity.setCampaignEndDate(date);
        vCampaignHeaderAgentEntity.setCampaignHeaderId(11);
        vCampaignHeaderAgentEntity.setCampaignNameEng("XXEng");
        vCampaignHeaderAgentEntity.setCampaignNameZHCN("XXCn");
        vCampaignHeaderAgentEntity.setCampaignNameZHTW("XXTw");
        vCampaignHeaderAgentEntity.setCampaignStartDate(date);
        vCampaignHeaderAgentEntity.setCreatedBy("tester");
        vCampaignHeaderAgentEntity.setCreatedDate(date);
        vCampaignHeaderAgentEntity.setIfaCaIndicator("XX1");
        vCampaignHeaderAgentEntity.setRemark("remark");
        vCampaignHeaderAgentEntity.setThumbnailDocID(999);
        vCampaignHeaderAgentEntity.setUpdatedBy("Ke");
        vCampaignHeaderAgentEntity.setUpdatedDate(date);

        VCampaignHeaderAgentEntity vCampaignHeaderAgentEntity1 = new VCampaignHeaderAgentEntity();
        vCampaignHeaderAgentEntity1.setCampaignCode("abCompany");
        vCampaignHeaderAgentEntity1.setCampaignEndDate(date);
        vCampaignHeaderAgentEntity1.setCampaignHeaderId(11);
        vCampaignHeaderAgentEntity1.setCampaignNameEng("XXEng");
        vCampaignHeaderAgentEntity1.setCampaignNameZHCN("XXCn");
        vCampaignHeaderAgentEntity1.setCampaignNameZHTW("XXTw");
        vCampaignHeaderAgentEntity1.setCampaignStartDate(date);
        vCampaignHeaderAgentEntity1.setCreatedBy("tester");
        vCampaignHeaderAgentEntity1.setCreatedDate(date);
        vCampaignHeaderAgentEntity1.setIfaCaIndicator("XX1");
        vCampaignHeaderAgentEntity1.setRemark("remark");
        vCampaignHeaderAgentEntity1.setThumbnailDocID(999);
        vCampaignHeaderAgentEntity1.setUpdatedBy("Ke");
        vCampaignHeaderAgentEntity1.setUpdatedDate(date);

        var vCampaignHeaderAgentEntityArrayList = new ArrayList<VCampaignHeaderAgentEntity>();
        vCampaignHeaderAgentEntityArrayList.add(vCampaignHeaderAgentEntity);
        vCampaignHeaderAgentEntityArrayList.add(vCampaignHeaderAgentEntity1);
        var pageableParameter = new PageableParameter();
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(123);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(321);
        requestParameter.setPageableParameter(pageableParameter);

        var pageable = querySetupUtil.setPageable(requestParameter);
        var vCampaignHeaderAgentEntityPage = new PageImpl<>(vCampaignHeaderAgentEntityArrayList,pageable, vCampaignHeaderAgentEntityArrayList.size()) ;
        var campaignListDto = new CampaignListDto();
        campaignListDto.campaignListDtoAgent(vCampaignHeaderAgentEntityPage);
        assertEquals(vCampaignHeaderAgentEntity.getCampaignHeaderId(), campaignListDto.getCampaignList().get(0).getCampaignHeaderId());
        assertEquals(vCampaignHeaderAgentEntity.getCampaignCode(), campaignListDto.getCampaignList().get(0).getCampaignCode());
        assertEquals(vCampaignHeaderAgentEntity.getCampaignNameEng(), campaignListDto.getCampaignList().get(0).getCampaignNameEng());
        assertEquals(vCampaignHeaderAgentEntity.getCampaignNameZHTW(), campaignListDto.getCampaignList().get(0).getCampaignNameZHTW());
        assertEquals(vCampaignHeaderAgentEntity.getCampaignNameZHCN(), campaignListDto.getCampaignList().get(0).getCampaignNameZHCN());
        assertEquals(vCampaignHeaderAgentEntity.getIfaCaIndicator(), campaignListDto.getCampaignList().get(0).getIfaCaIndicator());
        assertEquals(vCampaignHeaderAgentEntity.getRemark(), campaignListDto.getCampaignList().get(0).getRemark());
        assertEquals(vCampaignHeaderAgentEntity.getCampaignStartDate(), campaignListDto.getCampaignList().get(0).getCampaignStartDate());
        assertEquals(vCampaignHeaderAgentEntity.getCampaignEndDate(), campaignListDto.getCampaignList().get(0).getCampaignEndDate());
        assertEquals(vCampaignHeaderAgentEntity.getThumbnailDocID(), campaignListDto.getCampaignList().get(0).getThumbnailDocID());
        assertEquals(vCampaignHeaderAgentEntity.getCreatedDate(), campaignListDto.getCampaignList().get(0).getCreatedDate());
        assertEquals(vCampaignHeaderAgentEntity.getUpdatedDate(), campaignListDto.getCampaignList().get(0).getUpdatedDate());
        assertEquals(vCampaignHeaderAgentEntity.getCreatedBy(), campaignListDto.getCampaignList().get(0).getCreatedBy());
        assertEquals(vCampaignHeaderAgentEntity.getUpdatedBy(), campaignListDto.getCampaignList().get(0).getUpdatedBy());
        assertEquals(pageableParameter.getPageNumber(), campaignListDto.getPagination().getPageNumber());
        assertEquals(pageableParameter.getPageSize(), campaignListDto.getPagination().getPageSize());

    }

}
