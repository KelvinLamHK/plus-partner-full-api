package com.ftlife.plus.partner.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "VCampaignDetailAgent")
@Getter
@Setter
@Immutable
public class VCampaignDetailAgentEntity extends PCampaignDetailCommon {
    @Id
    @Column(name = "campaignDetailId")
    private long campaignDetailId;

    @Column(name = "campaignHeaderId" ,nullable = false)
    long campaignHeaderId;

    @Column(name = "trCode",nullable = false)
    private String trCode;

    @Column(name = "createdDate",nullable = false)
    Date createdDate;

    @Column(name = "updatedDate",nullable = false)
    Date updatedDate;

    @Size(min = 1, max=200)
    @Column(name = "createdBy",nullable = false)
    String createdBy;

    @Size(min = 1, max=200)
    @Column(name = "updatedBy",nullable = false)
    String updatedBy;

    @Size(max = 4000)
    @Column(name = "remark" )
    String remark;

    @Size(max = 4000)
    @Column(name = "remarkAgent" )
    String remarkAgent;

    @Size(max = 500)
    @Column(name = "trNameEng" )
    String trNameEng;

    @Column(name = "dateOfBirth" )
    Date dateOfBirth;

}
