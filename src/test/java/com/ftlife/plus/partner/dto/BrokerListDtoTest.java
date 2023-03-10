package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.TBrokerEntity;
import com.ftlife.plus.partner.parameter.PageableParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.util.QuerySetupUtil;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrokerListDtoTest {
    QuerySetupUtil querySetupUtil = new QuerySetupUtil();

    RequestParameter requestParameter = new RequestParameter();

    @Test
    public void testPojo(){
        var tBrokerEntity = new TBrokerEntity();
        var tBrokerEntityArrayList = new ArrayList<TBrokerEntity>();
        tBrokerEntityArrayList.add(tBrokerEntity);
        var pageableParameter = new PageableParameter();
        pageableParameter.setOrderBy("a");
        pageableParameter.setPageNumber(99);
        pageableParameter.setOrderSequence("asc");
        pageableParameter.setPageSize(11);
        requestParameter.setPageableParameter(pageableParameter);
        var pageable = querySetupUtil.setPageable(requestParameter);
        var tBrokerEntityPage = new PageImpl<>(tBrokerEntityArrayList,pageable, tBrokerEntityArrayList.size()) ;
        BrokerListDto brokerListDto = new BrokerListDto(tBrokerEntityPage);

        assertEquals(pageableParameter.getPageSize(), brokerListDto.getPagination().getPageSize());
        assertEquals(pageableParameter.getPageNumber(), brokerListDto.getPagination().getPageNumber());
        assertEquals(tBrokerEntityArrayList.get(0), brokerListDto.getBrokerList().get(0));

        PageableDto pagination = new PageableDto();
        List<TBrokerEntity> brokerList = new ArrayList<>();
        brokerList.add(tBrokerEntity);
        brokerListDto.setBrokerList(brokerList);
        brokerListDto.setPagination(pagination);

        assertEquals(pagination, brokerListDto.getPagination());
        assertEquals(brokerList.get(0), brokerListDto.getBrokerList().get(0));
    }

}
