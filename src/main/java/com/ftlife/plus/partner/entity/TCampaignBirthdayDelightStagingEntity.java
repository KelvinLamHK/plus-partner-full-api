package com.ftlife.plus.partner.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "TCampaignBirthdayDelightStaging")
@Getter
@Setter
public class TCampaignBirthdayDelightStagingEntity extends PCampaignDetailCommon{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaignBirthdayDelightStagingId")
    private long campaignBirthdayDelightStagingId;

    @Column(name = "dateOfBirth" )
    private Date dateOfBirth;

    private String batchNumber;

    private String batchStatus;

    public TCampaignBirthdayDelightStagingEntity(){}

}
