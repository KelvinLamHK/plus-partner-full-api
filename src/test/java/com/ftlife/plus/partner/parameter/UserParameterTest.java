package com.ftlife.plus.partner.parameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserParameterTest {
    @Test
    void testPojo()  {
        UserParameter userParameter = new UserParameter();
        userParameter.setLoginName("a");
        userParameter.setName("a");
        userParameter.setCompanyName("a");
        userParameter.setCompanyID("a");
        userParameter.setEmail("a");
        userParameter.setBrokerCode("a");
        userParameter.setIfaIdentity("a");
        userParameter.setPibaNumber("a");
        userParameter.setIfaCaNameEng("a");
        userParameter.setIfaCaNameOther("a");
        userParameter.setIfaCaLicenseNumber("a");
        userParameter.setRole("a");


        assertEquals("a",userParameter.getLoginName());
        assertEquals("a",userParameter.getName());
        assertEquals("a",userParameter.getCompanyName());
        assertEquals("a",userParameter.getCompanyID());
        assertEquals("a",userParameter.getEmail());
        assertEquals("a",userParameter.getBrokerCode());
        assertEquals("a",userParameter.getIfaIdentity());
        assertEquals("a",userParameter.getPibaNumber());
        assertEquals("a",userParameter.getIfaCaNameEng());
        assertEquals("a",userParameter.getIfaCaNameOther());
        assertEquals("a",userParameter.getIfaCaLicenseNumber());
        assertEquals("a",userParameter.getRole());


    }
}
