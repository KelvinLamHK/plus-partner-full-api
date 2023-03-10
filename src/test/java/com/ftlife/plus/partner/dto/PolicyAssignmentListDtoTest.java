package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.TPolicyAssignmentEntity;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolicyAssignmentListDtoTest {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);

    public PolicyAssignmentListDtoTest() throws ParseException {
    }

    @Test
    public void testPojo(){
        TPolicyAssignmentEntity tPolicyAssignmentEntity = new TPolicyAssignmentEntity();
        tPolicyAssignmentEntity.setPolicyNumber("1");
        tPolicyAssignmentEntity.setAgentCode("123456");
        tPolicyAssignmentEntity.setChannelCode("ChannelCode");
        tPolicyAssignmentEntity.setTrCode("TrCode");
        tPolicyAssignmentEntity.setTrNameChi("TrNameChi");
        tPolicyAssignmentEntity.setTrNameEng("TrNameEng");
        tPolicyAssignmentEntity.setTrPhoneNumber("TrPhoneNumber");
        tPolicyAssignmentEntity.setTrEmailAddress("TrEmailAddress");
        tPolicyAssignmentEntity.setUpdatedDate(date);
        PolicyAssignmentListDto policyAssignmentListDto = new PolicyAssignmentListDto();
        List<TPolicyAssignmentEntity> policyAssignmentList = new ArrayList<>();
        policyAssignmentList.add(tPolicyAssignmentEntity);
        PageableDto pagination = new PageableDto();
        pagination.setPageSize(99);
        pagination.setPageNumber(100);
        policyAssignmentListDto.setPolicyAssignmentList(policyAssignmentList);
        policyAssignmentListDto.setPagination(pagination);

        assertEquals(pagination.getPageSize(), policyAssignmentListDto.getPagination().getPageSize());
        assertEquals(pagination.getPageNumber(), policyAssignmentListDto.getPagination().getPageNumber());
        assertEquals(tPolicyAssignmentEntity.getPolicyNumber(), policyAssignmentListDto.getPolicyAssignmentList().get(0).getPolicyNumber());
        assertEquals(tPolicyAssignmentEntity.getAgentCode(), policyAssignmentListDto.getPolicyAssignmentList().get(0).getAgentCode());
        assertEquals(tPolicyAssignmentEntity.getTrCode(), policyAssignmentListDto.getPolicyAssignmentList().get(0).getTrCode());
        assertEquals(tPolicyAssignmentEntity.getChannelCode(), policyAssignmentListDto.getPolicyAssignmentList().get(0).getChannelCode());
        assertEquals(tPolicyAssignmentEntity.getTrNameEng(), policyAssignmentListDto.getPolicyAssignmentList().get(0).getTrNameEng());
        assertEquals(tPolicyAssignmentEntity.getTrNameChi(), policyAssignmentListDto.getPolicyAssignmentList().get(0).getTrNameChi());
        assertEquals(tPolicyAssignmentEntity.getTrEmailAddress(), policyAssignmentListDto.getPolicyAssignmentList().get(0).getTrEmailAddress());
        assertEquals(tPolicyAssignmentEntity.getTrPhoneNumber(), policyAssignmentListDto.getPolicyAssignmentList().get(0).getTrPhoneNumber());
        assertEquals(tPolicyAssignmentEntity.getUpdatedDate(), policyAssignmentListDto.getPolicyAssignmentList().get(0).getUpdatedDate());

    }
}
