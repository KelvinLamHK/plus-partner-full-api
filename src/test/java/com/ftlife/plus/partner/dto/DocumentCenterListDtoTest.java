package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.TDocumentCenterEntity;
import com.ftlife.plus.partner.entity.VDocumentCenterEntity;
import com.ftlife.plus.partner.parameter.*;
import com.ftlife.plus.partner.util.QuerySetupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentCenterListDtoTest {

    @Test
    public void testPojo() {
        RequestParameter requestParameter = new RequestParameter();
        PageableParameter pageableParameter = new PageableParameter();
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(123);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(321);
        requestParameter.setPageableParameter(pageableParameter);

        VDocumentCenterEntity vDocumentCenterEntity = new VDocumentCenterEntity();
        VDocumentCenterEntity vDocumentCenterEntityHasNext = new VDocumentCenterEntity();
        vDocumentCenterEntity.setDocumentCenterId(1);
        List<VDocumentCenterEntity> vDocumentCenterEntityList = new ArrayList<>();
        vDocumentCenterEntityList.add(vDocumentCenterEntity);
        vDocumentCenterEntityList.add(vDocumentCenterEntityHasNext);

        QuerySetupUtil querySetupUtil = new QuerySetupUtil();
        var pageable = querySetupUtil.setPageable(requestParameter);
        Page<VDocumentCenterEntity> vDocumentCenterEntityPage = new PageImpl<>(vDocumentCenterEntityList,pageable,vDocumentCenterEntityList.size());
        DocumentCenterListDto documentCenterListDto = new DocumentCenterListDto(vDocumentCenterEntityPage);


        assertEquals(pageableParameter.getPageSize(), documentCenterListDto.getPagination().getPageSize());
        assertEquals(pageableParameter.getPageNumber(), documentCenterListDto.getPagination().getPageNumber());


        List<VDocumentCenterEntity> vDocumentCenterEntityArrayList = new ArrayList<>();
        vDocumentCenterEntityArrayList.add(vDocumentCenterEntity);
        documentCenterListDto.setDocumentCenterList(vDocumentCenterEntityList);
        PageableDto pagination = new PageableDto();
        documentCenterListDto.setPagination(pagination);
        assertEquals(vDocumentCenterEntity.getDocumentCenterId(), documentCenterListDto.getDocumentCenterList().get(0).getDocumentCenterId());
        assertEquals(pagination, documentCenterListDto.getPagination());

    }
}
