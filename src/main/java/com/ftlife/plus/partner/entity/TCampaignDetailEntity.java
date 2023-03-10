package com.ftlife.plus.partner.entity;


import com.ftlife.plus.partner.parameter.CampaignDetailParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.parameter.UserParameter;
import com.ftlife.plus.partner.util.StringUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.NumberUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Entity
@Table(name = "TCampaignDetail")
@Getter
@Setter
public class TCampaignDetailEntity extends PCampaignDetailCommon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "campaignDetailId")
    long campaignDetailId;

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

    @Column(name = "campaignHeaderId" ,nullable = false)
    long campaignHeaderId;

    @Size(max = 4000)
    @Column(name = "remark" )
    String remark;

    @Size(max = 4000)
    @Column(name = "remarkAgent")
    String remarkAgent;

    @Column(name = "dateOfBirth" )
    Date dateOfBirth;


    public TCampaignDetailEntity(){}

    public TCampaignDetailEntity(RequestParameter requestParameter) throws ParseException {
    	CampaignDetailParameter campaignDetailParameter = requestParameter.getCampaignDetailParameter();
        UserParameter userParameter = requestParameter.getUserParameter();
        String format = "yyyy-MM-dd";

        if(campaignDetailParameter.getCampaignDetailId() != null) {
        	this.campaignDetailId = Long.parseLong(campaignDetailParameter.getCampaignDetailId());
        }
        
        if(campaignDetailParameter.getCampaignHeaderId() != null) {
        	this.campaignHeaderId = Long.parseLong(campaignDetailParameter.getCampaignHeaderId());
        }

        Optional<String> FullNameEngOptional = Optional.ofNullable(campaignDetailParameter.getClientFullNameEng());
        this.clientFullNameEng=FullNameEngOptional.orElse(campaignDetailParameter.getClientFullNameEng());

        Optional<String> FullNameChiOptional = Optional.ofNullable(campaignDetailParameter.getClientFullNameChi());
        this.clientFullNameChi=FullNameChiOptional.orElse(campaignDetailParameter.getClientFullNameChi());

        Optional<String> ClientIdOptional = Optional.ofNullable(campaignDetailParameter.getClientId());
        this.clientId=ClientIdOptional.orElse(campaignDetailParameter.getClientId());
        
        if(campaignDetailParameter.getPartyId() != null) {
        	this.partyId = Integer.parseInt(campaignDetailParameter.getPartyId());
        }

        Optional<String> ClientGenderOptional = Optional.ofNullable(campaignDetailParameter.getClientGender());
        this.clientGender=ClientGenderOptional.orElse(campaignDetailParameter.getClientGender());
        
        if(campaignDetailParameter.getDateOfBirth() != null) {
        	this.dateOfBirth = StringUtil.stringToDate(campaignDetailParameter.getDateOfBirth(),format);
        }

        Optional<String> BirthdayMonthOptional = Optional.ofNullable(campaignDetailParameter.getBirthdayMonth());
        this.birthdayMonth=BirthdayMonthOptional.orElse(campaignDetailParameter.getBirthdayMonth());

        Optional<String> LanguageForCommunicationOptional = Optional.ofNullable(campaignDetailParameter.getLanguageForCommunication());
        this.languageForCommunication=LanguageForCommunicationOptional.orElse(campaignDetailParameter.getLanguageForCommunication());

        Optional<String> DeathClaimOptional = Optional.ofNullable(campaignDetailParameter.getDeathClaim());
        this.deathClaim=DeathClaimOptional.orElse(campaignDetailParameter.getDeathClaim());
        
        if(campaignDetailParameter.getLatestPolicyIssueDate() != null) {
        	this.latestPolicyIssueDate = StringUtil.stringToDate(campaignDetailParameter.getLatestPolicyIssueDate(),format);
        }

        if(campaignDetailParameter.getFirstPolicyIssueDate() != null) {
        	this.firstPolicyIssueDate = StringUtil.stringToDate(campaignDetailParameter.getFirstPolicyIssueDate(),format);
        }

        Optional<String> LatestIssuedPolicyOptional = Optional.ofNullable(campaignDetailParameter.getLatestIssuedPolicy());
        this.latestIssuedPolicy=LatestIssuedPolicyOptional.orElse(campaignDetailParameter.getLatestIssuedPolicy());
        
        if(campaignDetailParameter.getNoOfInForcePolicy() != null) {
        	this.noOfInForcePolicy = Integer.parseInt(campaignDetailParameter.getNoOfInForcePolicy());
        } else {
            this.noOfInForcePolicy = 0;
        }
        
        if(campaignDetailParameter.getLastYearPremium() != null) {
        	this.lastYearPremium = NumberUtils.parseNumber(campaignDetailParameter.getLastYearPremium(), BigDecimal.class);
        }
        
        if(campaignDetailParameter.getThisYearPremium() != null) {
        	this.thisYearPremium = NumberUtils.parseNumber(campaignDetailParameter.getThisYearPremium(),BigDecimal.class);
        }

        Optional<String> SalesChannelOptional = Optional.ofNullable(campaignDetailParameter.getSalesChannel());
        this.salesChannel=SalesChannelOptional.orElse(campaignDetailParameter.getSalesChannel());

        Optional<String> ProduceAgent1RegionOptional = Optional.ofNullable(campaignDetailParameter.getProduceAgent1Region());
        this.produceAgent1Region=ProduceAgent1RegionOptional.orElse(campaignDetailParameter.getProduceAgent1Region());

        Optional<String> ProduceAgent2RegionOptional = Optional.ofNullable(campaignDetailParameter.getProduceAgent2Region());
        this.produceAgent2Region=ProduceAgent2RegionOptional.orElse(campaignDetailParameter.getProduceAgent2Region());

        Optional<String> ProduceAgent1CodeOptional = Optional.ofNullable(campaignDetailParameter.getProduceAgent1Code());
        this.produceAgent1Code=ProduceAgent1CodeOptional.orElse(campaignDetailParameter.getProduceAgent1Code());

        Optional<String> ProduceAgent2CodeOptional = Optional.ofNullable(campaignDetailParameter.getProduceAgent2Code());
        this.produceAgent2Code=ProduceAgent2CodeOptional.orElse(campaignDetailParameter.getProduceAgent2Code());

        Optional<String> ProduceAgent1NameOptional = Optional.ofNullable(campaignDetailParameter.getProduceAgent1Name());
        this.produceAgent1Name=ProduceAgent1NameOptional.orElse(campaignDetailParameter.getProduceAgent1Name());

        Optional<String> ProduceAgent2NameOptional = Optional.ofNullable(campaignDetailParameter.getProduceAgent2Name());
        this.produceAgent2Name=ProduceAgent2NameOptional.orElse(campaignDetailParameter.getProduceAgent2Name());

        Optional<String> ServAgentRegionOptional = Optional.ofNullable(campaignDetailParameter.getServAgentRegion());
        this.servAgentRegion=ServAgentRegionOptional.orElse(campaignDetailParameter.getServAgentRegion());

        Optional<String> ServAgentRegionNameOptional = Optional.ofNullable(campaignDetailParameter.getServAgentRegionName());
        this.servAgentRegionName=ServAgentRegionNameOptional.orElse(campaignDetailParameter.getServAgentRegionName());

        Optional<String> ServAgentDistrictCodeOptional = Optional.ofNullable(campaignDetailParameter.getServAgentDistrictCode());
        this.servAgentDistrictCode=ServAgentDistrictCodeOptional.orElse(campaignDetailParameter.getServAgentDistrictCode());

        Optional<String> ServAgentEmailOptional = Optional.ofNullable(campaignDetailParameter.getServAgentEmail());
        this.servAgentEmail=ServAgentEmailOptional.orElse(campaignDetailParameter.getServAgentEmail());

        Optional<String> ServAgentCodeOptional = Optional.ofNullable(campaignDetailParameter.getServAgentCode());
        this.servAgentCode =ServAgentCodeOptional.orElse(campaignDetailParameter.getServAgentCode());

        Optional<String> ServAgentNameOptional = Optional.ofNullable(campaignDetailParameter.getServAgentName());
        this.servAgentName=ServAgentNameOptional.orElse(campaignDetailParameter.getServAgentName());

        Optional<String> SalesManager1Optional = Optional.ofNullable(campaignDetailParameter.getSalesManager1());
        this.salesManager1=SalesManager1Optional.orElse(campaignDetailParameter.getSalesManager1());

        Optional<String> MobileAreaCodeOptional = Optional.ofNullable(campaignDetailParameter.getMobileAreaCode());
        this.mobileAreaCode=MobileAreaCodeOptional.orElse(campaignDetailParameter.getMobileAreaCode());

        Optional<String> MobileOptional = Optional.ofNullable(campaignDetailParameter.getMobile());
        this.mobile=MobileOptional.orElse(campaignDetailParameter.getMobile());

        Optional<String> ValidityOptional = Optional.ofNullable(campaignDetailParameter.getValidity());
        this.validity=ValidityOptional.orElse(campaignDetailParameter.getValidity());

        Optional<String> EmailOptional = Optional.ofNullable(campaignDetailParameter.getEmail());
        this.email=EmailOptional.orElse(campaignDetailParameter.getEmail());

        Optional<String> MailAddressAreaCodeOptional = Optional.ofNullable(campaignDetailParameter.getMailAddressAreaCode());
        this.mailAddressAreaCode=MailAddressAreaCodeOptional.orElse(campaignDetailParameter.getMailAddressAreaCode());

        Optional<String> ForeignIndicatorOptional = Optional.ofNullable(campaignDetailParameter.getForeignIndicator());
        this.foreignIndicator=ForeignIndicatorOptional.orElse(campaignDetailParameter.getForeignIndicator());

        Optional<String> MailingAddress1Optional = Optional.ofNullable(campaignDetailParameter.getMailingAddress1());
        this.mailingAddress1=MailingAddress1Optional.orElse(campaignDetailParameter.getMailingAddress1());

        Optional<String> MailingAddress2Optional = Optional.ofNullable(campaignDetailParameter.getMailingAddress2());
        this.mailingAddress2=MailingAddress2Optional.orElse(campaignDetailParameter.getMailingAddress2());

        Optional<String> MailingAddress3Optional = Optional.ofNullable(campaignDetailParameter.getMailingAddress3());
        this.mailingAddress3=MailingAddress3Optional.orElse(campaignDetailParameter.getMailingAddress3());

        Optional<String> MailingAddress4Optional = Optional.ofNullable(campaignDetailParameter.getMailingAddress4());
        this.mailingAddress4=MailingAddress4Optional.orElse(campaignDetailParameter.getMailingAddress4());

        Optional<String> MailingAddress5Optional = Optional.ofNullable(campaignDetailParameter.getMailingAddress5());
        this.mailingAddress5=MailingAddress5Optional.orElse(campaignDetailParameter.getMailingAddress5());

        Optional<String> OptOutOptional = Optional.ofNullable(campaignDetailParameter.getOptOut());
        this.optOut=OptOutOptional.orElse(campaignDetailParameter.getOptOut());

        Optional<String> PicsIndicatorOptional = Optional.ofNullable(campaignDetailParameter.getPicsIndicator());
        this.picsIndicator=PicsIndicatorOptional.orElse(campaignDetailParameter.getPicsIndicator());
        
        if(campaignDetailParameter.getPicsIndicatorDate() != null) {
        	this.picsIndicatorDate = StringUtil.stringToDate(campaignDetailParameter.getPicsIndicatorDate(),format);
        }

        Optional<String> DirectMarketingFtlOptional = Optional.ofNullable(campaignDetailParameter.getDirectMarketingFtl());
        this.directMarketingFtl=DirectMarketingFtlOptional.orElse(campaignDetailParameter.getDirectMarketingFtl());

        if(campaignDetailParameter.getDirectMarketingFtlDate() != null) {
        	this.directMarketingFtlDate = StringUtil.stringToDate(campaignDetailParameter.getDirectMarketingFtlDate(),format);
        }

        Optional<String> DirectMarketingNwgOptional = Optional.ofNullable(campaignDetailParameter.getDirectMarketingNwg());
        this.directMarketingNwg=DirectMarketingNwgOptional.orElse(campaignDetailParameter.getDirectMarketingNwg());

        if(campaignDetailParameter.getDirectMarketingNwgDate() != null) {
        	this.directMarketingNwgDate = StringUtil.stringToDate(campaignDetailParameter.getDirectMarketingNwgDate(),format);
        }

        Optional<String> BdOptional = Optional.ofNullable(campaignDetailParameter.getBd());
        this.bd=BdOptional.orElse(campaignDetailParameter.getBd());

        Optional<String> HaveP10AccountOptional = Optional.ofNullable(campaignDetailParameter.getHaveP10Account());
        this.haveP10Account=HaveP10AccountOptional.orElse(campaignDetailParameter.getHaveP10Account());

        Optional<String> CommunicationChannelOptional = Optional.ofNullable(campaignDetailParameter.getCommunicationChannel());
        this.communicationChannel=CommunicationChannelOptional.orElse(campaignDetailParameter.getCommunicationChannel());

        Optional<String> ServicingAgentMobileOptional = Optional.ofNullable(campaignDetailParameter.getServicingAgentMobile());
        this.servicingAgentMobile=ServicingAgentMobileOptional.orElse(campaignDetailParameter.getServicingAgentMobile());

        Optional<String> ServicingAgentEmailOptional = Optional.ofNullable(campaignDetailParameter.getServicingAgentEmail());
        this.servicingAgentEmail=ServicingAgentEmailOptional.orElse(campaignDetailParameter.getServicingAgentEmail());

        Optional<String> ServicingAgentStatusOptional = Optional.ofNullable(campaignDetailParameter.getServicingAgentStatus());
        this.servicingAgentStatus=ServicingAgentStatusOptional.orElse(campaignDetailParameter.getServicingAgentStatus());

        Optional<String> OptInOptional = Optional.ofNullable(campaignDetailParameter.getOptIn());
        this.optIn=OptInOptional.orElse(campaignDetailParameter.getOptIn());

        Optional<String> RemarkOptional = Optional.ofNullable(campaignDetailParameter.getRemark());
        this.remark=RemarkOptional.orElse(campaignDetailParameter.getRemark());

        Optional<String> RemarkAgentOptional = Optional.ofNullable(campaignDetailParameter.getRemarkAgent());
        this.remarkAgent=RemarkAgentOptional.orElse(campaignDetailParameter.getRemarkAgent());
        
        if(campaignDetailParameter.getCreatedDateFrom() != null) {
        	this.createdDate = StringUtil.stringToDate(campaignDetailParameter.getCreatedDate(),format);
        }
        
        if(campaignDetailParameter.getUpdatedDate() != null) {
        	this.updatedDate = StringUtil.stringToDate(campaignDetailParameter.getUpdatedDate(), format);
        }

        Optional<String> createdByOptional = Optional.ofNullable(userParameter.getLoginName());
        this.createdBy=createdByOptional.orElse(userParameter.getLoginName());

        Optional<String> updatedByOptional = Optional.ofNullable(userParameter.getLoginName());
        this.updatedBy=updatedByOptional.orElse(userParameter.getLoginName());

        this.createdDate = new Date();
        this.updatedDate = new Date();
    }
    public List<TCampaignDetailEntity> convertTCampaignBirthdayDelightStagingEntityToTCampaignDetailEntity(List<TCampaignBirthdayDelightStagingEntity> tCampaignBirthdayDelightStagingEntityList, long tCampaignHeaderId) throws ParseException {
        List<TCampaignDetailEntity> tCampaignDetailEntityList = new ArrayList<>();
        for(TCampaignBirthdayDelightStagingEntity x: tCampaignBirthdayDelightStagingEntityList){
            TCampaignDetailEntity tCampaignDetailEntity = new TCampaignDetailEntity();

            tCampaignDetailEntity.setClientFullNameEng(x.getClientFullNameEng());
            tCampaignDetailEntity.setClientFullNameChi(x.getClientFullNameChi());
            tCampaignDetailEntity.setClientId(x.getClientId());
            tCampaignDetailEntity.setPartyId(tCampaignDetailEntity.getPartyId());
            tCampaignDetailEntity.setClientGender(x.getClientGender());
            tCampaignDetailEntity.setDateOfBirth(x.getDateOfBirth());
            tCampaignDetailEntity.setBirthdayMonth(x.getBirthdayMonth());
            tCampaignDetailEntity.setLanguageForCommunication(x.getLanguageForCommunication());
            tCampaignDetailEntity.setDeathClaim(x.getDeathClaim());
            tCampaignDetailEntity.setLatestPolicyIssueDate(x.getLatestPolicyIssueDate());
            tCampaignDetailEntity.setFirstPolicyIssueDate(x.getFirstPolicyIssueDate());
            tCampaignDetailEntity.setLatestIssuedPolicy(x.getLatestIssuedPolicy());
            tCampaignDetailEntity.setNoOfInForcePolicy(x.getNoOfInForcePolicy());
            tCampaignDetailEntity.setLastYearPremium(x.getLastYearPremium());
            tCampaignDetailEntity.setThisYearPremium(x.getThisYearPremium());
            tCampaignDetailEntity.setSalesChannel(x.getSalesChannel());
            tCampaignDetailEntity.setProduceAgent1Region(x.getProduceAgent1Region());
            tCampaignDetailEntity.setProduceAgent1Code(x.getProduceAgent1Code());
            tCampaignDetailEntity.setProduceAgent1Name(x.getProduceAgent1Name());
            tCampaignDetailEntity.setProduceAgent2Region(x.getProduceAgent2Region());
            tCampaignDetailEntity.setProduceAgent2Code(x.getProduceAgent2Code());
            tCampaignDetailEntity.setProduceAgent2Name(x.getProduceAgent2Name());
            tCampaignDetailEntity.setServAgentRegion(x.getServAgentRegion());
            tCampaignDetailEntity.setServAgentRegionName(x.getServAgentRegionName());
            tCampaignDetailEntity.setServAgentDistrictCode(x.getServAgentDistrictCode());
            tCampaignDetailEntity.setServAgentEmail(x.getServAgentEmail());
            tCampaignDetailEntity.setServAgentCode(x.getServAgentCode());
            tCampaignDetailEntity.setServAgentName(x.getServAgentName());
            tCampaignDetailEntity.setSalesManager1(x.getSalesManager1());
            tCampaignDetailEntity.setMobileAreaCode(x.getMobileAreaCode());
            tCampaignDetailEntity.setMobile(x.getMobile());
            tCampaignDetailEntity.setValidity(x.getValidity());
            tCampaignDetailEntity.setEmail(x.getEmail());
            tCampaignDetailEntity.setMailAddressAreaCode(x.getMailAddressAreaCode());
            tCampaignDetailEntity.setForeignIndicator(x.getForeignIndicator());
            tCampaignDetailEntity.setMailingAddress1(x.getMailingAddress1());
            tCampaignDetailEntity.setMailingAddress2(x.getMailingAddress2());
            tCampaignDetailEntity.setMailingAddress3(x.getMailingAddress3());
            tCampaignDetailEntity.setMailingAddress4(x.getMailingAddress4());
            tCampaignDetailEntity.setMailingAddress5(x.getMailingAddress5());
            tCampaignDetailEntity.setOptOut(x.getOptOut());
            tCampaignDetailEntity.setPicsIndicator(x.getPicsIndicator());
            tCampaignDetailEntity.setPicsIndicatorDate(x.getPicsIndicatorDate());
            tCampaignDetailEntity.setDirectMarketingFtl(x.getDirectMarketingFtl());
            tCampaignDetailEntity.setDirectMarketingFtlDate(x.getDirectMarketingFtlDate());
            tCampaignDetailEntity.setDirectMarketingNwg(x.getDirectMarketingNwg());
            tCampaignDetailEntity.setDirectMarketingNwgDate(x.getDirectMarketingNwgDate());
            tCampaignDetailEntity.setBd(x.getBd());
            tCampaignDetailEntity.setHaveP10Account(x.getHaveP10Account());
            tCampaignDetailEntity.setCommunicationChannel(x.getCommunicationChannel());
            tCampaignDetailEntity.setServicingAgentMobile(x.getServicingAgentMobile());
            tCampaignDetailEntity.setServicingAgentEmail(x.getServicingAgentEmail());
            tCampaignDetailEntity.setServicingAgentStatus(x.getServicingAgentStatus());
            tCampaignDetailEntity.setOptIn(x.getOptIn());
            tCampaignDetailEntity.setCreatedDate(new Date());
            tCampaignDetailEntity.setUpdatedDate(new Date());
            tCampaignDetailEntity.setCreatedBy("Auto");
            tCampaignDetailEntity.setUpdatedBy("Auto");
            tCampaignDetailEntity.setCampaignHeaderId(tCampaignHeaderId);
            tCampaignDetailEntityList.add(tCampaignDetailEntity);
        }
        return tCampaignDetailEntityList;
    }

}
