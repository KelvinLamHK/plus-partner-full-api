package com.ftlife.plus.partner.entity;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TPolicyAssignmentCommonTest {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);

    public TPolicyAssignmentCommonTest() throws ParseException {
    }

    @Test
    public void testPojo(){
        TPolicyAssignmentCommon tPolicyAssignmentCommon = new TPolicyAssignmentCommon();
        tPolicyAssignmentCommon.setPolicyNumber("1");
        tPolicyAssignmentCommon.setAgentCode("AgentCode");
        tPolicyAssignmentCommon.setChannelCode("ChannelCode");
        tPolicyAssignmentCommon.setTrCode("TrCode");
        tPolicyAssignmentCommon.setTrNameChi("TrNameChi");
        tPolicyAssignmentCommon.setTrNameEng("TrNameEng");
        tPolicyAssignmentCommon.setTrPhoneNumber("TrPhoneNumber");
        tPolicyAssignmentCommon.setTrEmailAddress("TrEmailAddress");
        tPolicyAssignmentCommon.setUpdatedDate(date);

        assertEquals("1", tPolicyAssignmentCommon.getPolicyNumber());
        assertEquals("AgentCode", tPolicyAssignmentCommon.getAgentCode());
        assertEquals("TrCode", tPolicyAssignmentCommon.getTrCode());
        assertEquals("ChannelCode", tPolicyAssignmentCommon.getChannelCode());
        assertEquals("TrNameChi", tPolicyAssignmentCommon.getTrNameChi());
        assertEquals("TrNameEng", tPolicyAssignmentCommon.getTrNameEng());
        assertEquals("TrEmailAddress", tPolicyAssignmentCommon.getTrEmailAddress());
        assertEquals("TrPhoneNumber", tPolicyAssignmentCommon.getTrPhoneNumber());
        assertEquals(date, tPolicyAssignmentCommon.getUpdatedDate());
    }
}
