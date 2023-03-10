package com.ftlife.plus.partner.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "TPolicyAssignmentStaging")
@Getter
@Setter
public class TPolicyAssignmentStagingEntity extends TPolicyAssignmentCommon{

    public TPolicyAssignmentStagingEntity(){

    }

    public TPolicyAssignmentStagingEntity(String policyNumber, String agentCode, String trCode, String trEmailAddress, String trPhoneNumber, String trNameEng, String trNameChi, String channelCode, Date updatedDate) {
        this.policyNumber = policyNumber;
        this.agentCode = agentCode;
        this.trCode = trCode;
        this.trEmailAddress = trEmailAddress;
        this.trPhoneNumber = trPhoneNumber;
        this.trNameEng = trNameEng;
        this.trNameChi = trNameChi;
        this.ChannelCode = channelCode;
        this.updatedDate = updatedDate;
    }

    public List<TPolicyAssignmentStagingEntity> covertTPolicyAssignmentToTPolicyAssignmentStagingListEntity(List<TPolicyAssignmentEntity> tPolicyAssignmentEntityList){
        return tPolicyAssignmentEntityList
                .stream()
                .map( b -> new TPolicyAssignmentStagingEntity(b.getPolicyNumber(), b.getAgentCode(), b.getTrCode(), b.getTrEmailAddress(), b.trPhoneNumber, b.getTrNameEng(), b.getTrNameChi(), b.getChannelCode(), b.getUpdatedDate()))
                .collect(Collectors.toList());
    }
}
