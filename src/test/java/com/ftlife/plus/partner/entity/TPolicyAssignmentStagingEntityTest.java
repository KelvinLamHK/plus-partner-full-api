package com.ftlife.plus.partner.entity;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TPolicyAssignmentStagingEntityTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);

    public TPolicyAssignmentStagingEntityTest() throws ParseException {
    }

    @Test
    public void testPojo(){
        TPolicyAssignmentStagingEntity tPolicyAssignmentStagingEntity = new TPolicyAssignmentStagingEntity();


        TPolicyAssignmentStagingEntity tPolicyAssignmentStagingEntityFullCon = new TPolicyAssignmentStagingEntity("a","a","a","a","a","a","a","a",date);

        List<TPolicyAssignmentEntity> tPolicyAssignmentEntityList = new ArrayList<>();
        TPolicyAssignmentEntity tPolicyAssignmentEntity = new TPolicyAssignmentEntity();
        tPolicyAssignmentEntityList.add(tPolicyAssignmentEntity);
        tPolicyAssignmentEntity.setPolicyNumber("a");
        tPolicyAssignmentEntity.setAgentCode("a");
        tPolicyAssignmentEntity.setChannelCode("a");
        tPolicyAssignmentEntity.setTrCode("a");
        tPolicyAssignmentEntity.setTrEmailAddress("a");
        tPolicyAssignmentEntity.setTrPhoneNumber("a");
        tPolicyAssignmentEntity.setTrNameEng("a");
        tPolicyAssignmentEntity.setTrNameChi("a");
        tPolicyAssignmentEntity.setUpdatedDate(date);
        tPolicyAssignmentEntityList.add(tPolicyAssignmentEntity);
        tPolicyAssignmentStagingEntityFullCon.covertTPolicyAssignmentToTPolicyAssignmentStagingListEntity(tPolicyAssignmentEntityList);


        assertEquals("a",tPolicyAssignmentStagingEntityFullCon.covertTPolicyAssignmentToTPolicyAssignmentStagingListEntity(tPolicyAssignmentEntityList).get(0).getPolicyNumber());

    }
}
