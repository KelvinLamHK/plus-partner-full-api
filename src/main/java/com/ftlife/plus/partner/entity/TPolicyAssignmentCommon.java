package com.ftlife.plus.partner.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class TPolicyAssignmentCommon {

    @Id
    @Column(name = "policyNumber")
    String policyNumber;

    @Column(name = "agentCode")
    String agentCode;

    @Column(name = "trCode")
    String trCode;

    @Column(name = "trEmailAddress")
    String trEmailAddress;

    @Column(name = "trPhoneNumber")
    String trPhoneNumber;

    @Column(name = "trNameEng")
    String trNameEng;

    @Column(name = "trNameChi")
    String trNameChi;

    @Column(name = "ChannelCode")
    String ChannelCode;

    @Column(name = "updatedDate")
    Date updatedDate;

}
