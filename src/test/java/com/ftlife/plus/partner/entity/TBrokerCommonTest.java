package com.ftlife.plus.partner.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TBrokerCommonTest {


    @Test
    public void testPojo() {
        TBrokerCommon tBrokerCommon = new TBrokerStagingEntity();
        tBrokerCommon.setBrokerCode("a");
        tBrokerCommon.setBrokerName("a");
        tBrokerCommon.setBrokerShortForm("a");
        assertEquals("a", tBrokerCommon.getBrokerCode());
        assertEquals("a", tBrokerCommon.getBrokerName());
        assertEquals("a", tBrokerCommon.getBrokerShortForm());

    }
}
