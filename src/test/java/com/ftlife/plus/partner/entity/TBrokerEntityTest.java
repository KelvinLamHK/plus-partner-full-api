package com.ftlife.plus.partner.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TBrokerEntityTest {

    @Test
    public void testPojo(){
        TBrokerEntity tBrokerEntity = new TBrokerEntity();
        assertEquals(tBrokerEntity.getClass(), TBrokerEntity.class);
    }
}
