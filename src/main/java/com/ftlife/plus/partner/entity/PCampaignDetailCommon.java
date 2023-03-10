package com.ftlife.plus.partner.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class PCampaignDetailCommon {
    @Size(max = 141)
    @Column(name = "clientFullNameEng" )
    String clientFullNameEng;

    @Size(max = 140)
    @Column(name = "clientFullNameChi" )
    String clientFullNameChi;

    @Size(max = 50)
    @Column(name = "clientId" )
    String clientId;

    @Column(name = "partyId" )
    int partyId;

    @Size(max = 1)
    @Column(name = "clientGender" )
    String clientGender;

    @Size(max = 2)
    @Column(name = "birthdayMonth" )
    String birthdayMonth;

    @Size(max = 2)
    @Column(name = "languageForCommunication" )
    String languageForCommunication;

    @Size(max = 1)
    @Column(name = "deathClaim" )
    String deathClaim;

    @Column(name = "latestPolicyIssueDate" )
    Date latestPolicyIssueDate;

    @Column(name = "firstPolicyIssueDate" )
    Date firstPolicyIssueDate;

    @Size(max = 20)
    @Column(name = "latestIssuedPolicy" )
    String latestIssuedPolicy;

    @Column(name = "noOfInForcePolicy" )
    Integer noOfInForcePolicy;

    @Column(name = "lastYearPremium" )
    BigDecimal lastYearPremium;

    @Column(name = "thisYearPremium" )
    BigDecimal thisYearPremium;

    @Size(max = 4)
    @Column(name = "salesChannel" )
    String salesChannel;

    @Size(max = 20)
    @Column(name = "produceAgent1Region" )
    String produceAgent1Region;

    @Size(max = 20)
    @Column(name = "produceAgent1Code" )
    String produceAgent1Code;

    @Size(max = 150)
    @Column(name = "produceAgent1Name" )
    String produceAgent1Name;

    @Size(max = 20)
    @Column(name = "produceAgent2Region" )
    String produceAgent2Region;

    @Size(max = 20)
    @Column(name = "produceAgent2Code" )
    String produceAgent2Code;

    @Size(max = 150)
    @Column(name = "produceAgent2Name" )
    String produceAgent2Name;

    @Size(max = 4000)
    @Column(name = "servAgentRegion" )
    String servAgentRegion;

    @Size(max = 600)
    @Column(name = "servAgentRegionName" )
    String servAgentRegionName;

    @Size(max = 4000)
    @Column(name = "servAgentDistrictCode" )
    String servAgentDistrictCode;

    @Size(max = 4000)
    @Column(name = "servAgentEmail" )
    String servAgentEmail;

    @Size(max = 20)
    @Column(name = "servAgentCode" )
    String servAgentCode;

    @Size(max = 150)
    @Column(name = "servAgentName" )
    String servAgentName;

    @Size(max = 50)
    @Column(name = "salesManager1" )
    String salesManager1;

    @Size(max = 10)
    @Column(name = "mobileAreaCode" )
    String mobileAreaCode;

    @Size(max = 20)
    @Column(name = "mobile" )
    String mobile;

    @Size(max = 1)
    @Column(name = "validity" )
    String validity;

    @Size(max = 100)
    @Column(name = "email" )
    String email;

    @Size(max = 60)
    @Column(name = "mailAddressAreaCode" )
    String mailAddressAreaCode;

    @Size(max = 1)
    @Column(name = "foreignIndicator" )
    String foreignIndicator;

    @Size(max = 4000)
    @Column(name = "mailingAddress1" )
    String mailingAddress1;

    @Size(max = 4000)
    @Column(name = "mailingAddress2" )
    String mailingAddress2;

    @Size(max = 4000)
    @Column(name = "mailingAddress3" )
    String mailingAddress3;

    @Size(max = 4000)
    @Column(name = "mailingAddress4" )
    String mailingAddress4;

    @Size(max = 4000)
    @Column(name = "mailingAddress5" )
    String mailingAddress5;

    @Size(max = 1)
    @Column(name = "optOut" )
    String optOut;

    @Size(max = 1)
    @Column(name = "picsIndicator" )
    String picsIndicator;

    @Column(name = "picsIndicatorDate" )
    Date picsIndicatorDate;

    @Size(max = 1)
    @Column(name = "directMarketingFtl" )
    String directMarketingFtl;

    @Column(name = "directMarketingFtlDate" )
    Date directMarketingFtlDate;

    @Size(max = 1)
    @Column(name = "directMarketingNwg" )
    String directMarketingNwg;

    @Column(name = "directMarketingNwgDate" )
    Date directMarketingNwgDate;

    @Size(max = 3)
    @Column(name = "bd" )
    String bd;

    @Size(max = 1)
    @Column(name = "haveP10Account" )
    String haveP10Account;

    @Size(max = 3)
    @Column(name = "communicationChannel" )
    String communicationChannel;

    @Size(max = 20)
    @Column(name = "servicingAgentMobile" )
    String servicingAgentMobile;

    @Size(max = 100)
    @Column(name = "servicingAgentEmail" )
    String servicingAgentEmail;

    @Size(max = 30)
    @Column(name = "servicingAgentStatus" )
    String servicingAgentStatus;

    @Size(max = 3)
    @Column(name = "optIn" )
    String optIn;


}
