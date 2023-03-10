package com.ftlife.plus.partner.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TBrokerStagingEntityTest {

    @Test
    public void testPojo(){
        TBrokerStagingEntity tBrokerStagingEntity = new TBrokerStagingEntity();
        assertEquals(TBrokerStagingEntity.class, tBrokerStagingEntity.getClass());
        String brokerCode = "a";
        String brokerShortForm = "a";
        String brokerName = "a";
        List<TBrokerEntity> tBrokerEntityList = new ArrayList<>();
        TBrokerEntity tBrokerEntity = new TBrokerEntity();
        tBrokerEntity.setBrokerCode("a");
        tBrokerEntity.setBrokerName("a");
        tBrokerEntity.setBrokerShortForm("a");
        tBrokerEntityList.add(tBrokerEntity);
        TBrokerStagingEntity tBrokerStagingEntityWithArgs = new TBrokerStagingEntity(brokerCode, brokerShortForm, brokerName);
        assertEquals("a", tBrokerStagingEntityWithArgs.getBrokerName());
        assertEquals("a", tBrokerStagingEntityWithArgs.getBrokerCode());
        assertEquals("a", tBrokerStagingEntityWithArgs.getBrokerShortForm());
        assertEquals("a", tBrokerStagingEntityWithArgs.covertTBrokerToTBrokerStagingListEntity(tBrokerEntityList).get(0).getBrokerCode());
    }
}
