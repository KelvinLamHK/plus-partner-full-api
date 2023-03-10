package com.ftlife.plus.partner.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftlife.plus.partner.configuration.SchedulerConfig;
import com.ftlife.plus.partner.dto.BrokerListDto;
import com.ftlife.plus.partner.dto.CampaignBirthdayDelightListDto;
import com.ftlife.plus.partner.dto.PolicyAssignmentListDto;
import com.ftlife.plus.partner.entity.*;
import com.ftlife.plus.partner.parameter.PageableParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.repository.*;
import com.ftlife.plus.partner.util.HttpUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Log4j2
public class SchedulerServiceImpl implements SchedulerService{

    @Autowired
    SchedulerConfig schedulerConfig;

    @Autowired
    TBrokerRepository tBrokerRepository;

    @Autowired
    TBrokerStagingRepository tBrokerStagingRepository;

    @Autowired
    TPolicyAssignmentRepository tPolicyAssignmentRepository;

    @Autowired
    TPolicyAssignmentStagingRepository tPolicyAssignmentStagingRepository;

    @Autowired
    TCampaignHeaderRepository tCampaignHeaderRepository;

    @Autowired
    TCampaignDetailRepository tCampaignDetailRepository;

    @Autowired
    TCampaignBirthdayDelightStagingRepository tCampaignBirthdayDelightStagingRepository;

    @Override
    public List<TBrokerEntity> getBrokerListFromCoreApi() throws IOException {

        HttpUtil httpUtil = new HttpUtil();
        ObjectMapper objectMapper = new ObjectMapper();
        List<TBrokerEntity> tBrokerEntityList = new ArrayList<>();

        // Fetch first 1000 row
        var requestParameter = new RequestParameter();
        var pageableParameter = new PageableParameter();
        pageableParameter.setPageNumber(0);
        pageableParameter.setPageSize(1000);
        pageableParameter.setOrderBy("brokerCode");
        pageableParameter.setOrderSequence("asc");
        requestParameter.setPageableParameter(pageableParameter);
        var brokerListDto = objectMapper.readValue(httpUtil.httpPostRequest(schedulerConfig.getBrokerListApiUrl(), objectMapper.writeValueAsString(requestParameter)), BrokerListDto.class);
        tBrokerEntityList.addAll(brokerListDto.getBrokerList());
        // Fetch remaining rows
        while (brokerListDto.getPagination().isHasNext()){
            pageableParameter.setPageNumber(brokerListDto.getPagination().getPageNumber() + 1);
            brokerListDto = objectMapper.readValue(httpUtil.httpPostRequest(schedulerConfig.getBrokerListApiUrl(), objectMapper.writeValueAsString(requestParameter)), BrokerListDto.class);
            tBrokerEntityList.addAll(brokerListDto.getBrokerList());
        }

        if(brokerListDto.getPagination().getTotalNumberOfRecords() != tBrokerEntityList.size())
            throw new IllegalArgumentException("Fetched list size not match with original");

        return tBrokerEntityList;

    }

    @Override
    public void truncateBrokerListTable() {
        tBrokerRepository.truncateTBroker();
    }

    @Override
    @Transactional
    public void truncateBrokerListStagingTable() {
        tBrokerStagingRepository.truncateTBrokerStaging();
    }

    @Override
    @Transactional
    public void executeBrokerListJob() throws Exception {
        log.info("BrokerListJob: truncateBrokerListStagingTable");
        truncateBrokerListStagingTable();
        log.info("BrokerListJob: getBrokerListFromCoreApi");
        TBrokerStagingEntity tBrokerStagingEntity = new TBrokerStagingEntity();
        List<TBrokerStagingEntity> tBrokerStagingEntityList = tBrokerStagingEntity.covertTBrokerToTBrokerStagingListEntity(getBrokerListFromCoreApi());
        log.info("BrokerListJob: insert record to staging table");
        tBrokerStagingRepository.saveAll(tBrokerStagingEntityList);
        log.info("BrokerListJob: truncateBrokerListTable");
        truncateBrokerListTable();
        log.info("BrokerListJob: copyTBrokerStagingToTBroker");
        tBrokerRepository.copyTBrokerStagingToTBroker();
    }

    @Override
    public List<TPolicyAssignmentEntity> getPolicyAssignmentListFromCoreApi() throws IOException {
        HttpUtil httpUtil = new HttpUtil();
        ObjectMapper objectMapper = new ObjectMapper();
        List<TPolicyAssignmentEntity> tPolicyAssignmentEntityList = new ArrayList<>();

        // Fetch first 1000 row
        var requestParameter = new RequestParameter();
        var pageableParameter = new PageableParameter();
        pageableParameter.setPageNumber(0);
        pageableParameter.setPageSize(1000);
        pageableParameter.setOrderBy("policyNumber");
        pageableParameter.setOrderSequence("asc");
        requestParameter.setPageableParameter(pageableParameter);
        var policyAssignmentDto = objectMapper.readValue(httpUtil.httpPostRequest(schedulerConfig.getPolicyAssignmentListApiUrl(), objectMapper.writeValueAsString(requestParameter)), PolicyAssignmentListDto.class);
        tPolicyAssignmentEntityList.addAll(policyAssignmentDto.getPolicyAssignmentList());
        // Fetch remaining rows
        while (policyAssignmentDto.getPagination().isHasNext()){
            pageableParameter.setPageNumber(policyAssignmentDto.getPagination().getPageNumber() + 1);
            policyAssignmentDto = objectMapper.readValue(httpUtil.httpPostRequest(schedulerConfig.getPolicyAssignmentListApiUrl(), objectMapper.writeValueAsString(requestParameter)), PolicyAssignmentListDto.class);
            tPolicyAssignmentEntityList.addAll(policyAssignmentDto.getPolicyAssignmentList());
        }

        if(policyAssignmentDto.getPagination().getTotalNumberOfRecords() != tPolicyAssignmentEntityList.size())
            throw new IllegalArgumentException("Fetched list size not match with original");

        return tPolicyAssignmentEntityList;
    }

    @Override
    public void truncatePolicyAssignmentListTable() {
        tPolicyAssignmentRepository.truncateTPolicyAssignment();
    }

    @Override
    @Transactional
    public void truncatePolicyAssignmentListStagingTable() {
        tPolicyAssignmentStagingRepository.truncateTPolicyAssignmentStaging();
    }

    @Override
    @Transactional
    public void executePolicyAssignmentListJob() throws IOException {
        log.info("PolicyAssignmentListJob: truncatePolicyAssignmentListStagingTable");
        truncatePolicyAssignmentListStagingTable();
        log.info("PolicyAssignmentListJob: getPolicyAssignmentListFromCoreApi");
        TPolicyAssignmentStagingEntity tPolicyAssignmentStagingEntity = new TPolicyAssignmentStagingEntity();
        List<TPolicyAssignmentStagingEntity> tPolicyAssignmentStagingEntityList = tPolicyAssignmentStagingEntity.covertTPolicyAssignmentToTPolicyAssignmentStagingListEntity(getPolicyAssignmentListFromCoreApi());
        log.info("PolicyAssignmentListJob: insert record to staging table");
        tPolicyAssignmentStagingRepository.saveAll(tPolicyAssignmentStagingEntityList);
        log.info("PolicyAssignmentListJob: truncatePolicyAssignmentListTable");
        truncatePolicyAssignmentListTable();
        log.info("PolicyAssignmentListJob: copyTPolicyAssignmentStagingToTPolicyAssignment");
        tPolicyAssignmentRepository.copyTPolicyAssignmentStagingToTPolicyAssignment();
    }

    @Override
    public List<TCampaignBirthdayDelightStagingEntity> getCampaignDetailListFromCoreApi() throws IOException {
        List<TCampaignBirthdayDelightStagingEntity> tCampaignBirthdayDelightStagingEntityList = new ArrayList<>();
        HttpUtil httpUtil = new HttpUtil();
        ObjectMapper objectMapper = new ObjectMapper();
        UUID uuid = UUID.randomUUID();

        // Fetch first 1000 row
        var requestParameter = new RequestParameter();
        var pageableParameter = new PageableParameter();
        pageableParameter.setPageNumber(0);
        pageableParameter.setPageSize(1000);
        pageableParameter.setOrderBy("latestIssuedPolicy");
        pageableParameter.setOrderSequence("desc");
        requestParameter.setPageableParameter(pageableParameter);


        var campaignBirthdayDelightListDto = objectMapper.readValue(httpUtil.httpPostRequest(schedulerConfig.getCampaignBirthdayDelightListApiUrl(), objectMapper.writeValueAsString(requestParameter)), CampaignBirthdayDelightListDto.class);
        tCampaignBirthdayDelightStagingEntityList.addAll(campaignBirthdayDelightListDto.getCampaignOriginalDetailList());
        tCampaignBirthdayDelightStagingEntityList = setAndSaveTCampaignBirthdayDelightStagingEntityList(tCampaignBirthdayDelightStagingEntityList,uuid);
        // Fetch remaining rows
        while (campaignBirthdayDelightListDto.getPagination().isHasNext()){
            pageableParameter.setPageNumber(campaignBirthdayDelightListDto.getPagination().getPageNumber() + 1);
            campaignBirthdayDelightListDto = objectMapper.readValue(httpUtil.httpPostRequest(schedulerConfig.getCampaignBirthdayDelightListApiUrl(), objectMapper.writeValueAsString(requestParameter)), CampaignBirthdayDelightListDto.class);
            tCampaignBirthdayDelightStagingEntityList.addAll(campaignBirthdayDelightListDto.getCampaignOriginalDetailList());
            tCampaignBirthdayDelightStagingEntityList = setAndSaveTCampaignBirthdayDelightStagingEntityList(tCampaignBirthdayDelightStagingEntityList,uuid);
        }

        Optional<List<TCampaignBirthdayDelightStagingEntity>> tCampaignBirthdayDelightStagingReposByBatchNumber = tCampaignBirthdayDelightStagingRepository.findByBatchNumber(uuid.toString());
            if (tCampaignBirthdayDelightStagingReposByBatchNumber.isPresent()&&campaignBirthdayDelightListDto.getPagination().getTotalNumberOfRecords() != tCampaignBirthdayDelightStagingReposByBatchNumber.get().size()) {
                for (TCampaignBirthdayDelightStagingEntity x : tCampaignBirthdayDelightStagingEntityList) {
                    x.setBatchStatus("Fail");
                    tCampaignBirthdayDelightStagingRepository.save(x);
                }
                throw new IllegalArgumentException("Fetched list size not match with original");
            }

        return tCampaignBirthdayDelightStagingEntityList;

    }

    @Override
    public void executeCampaignDetailListJob() throws IOException, ParseException {
        TCampaignHeaderEntity tCampaignHeaderEntity = new TCampaignHeaderEntity();
        tCampaignHeaderEntity.setCampaignCode("BDelight");
        Date date = new Date();
        SimpleDateFormat yearDateFormat = new SimpleDateFormat();
        SimpleDateFormat monthDateFormat = new SimpleDateFormat();
        yearDateFormat.applyPattern("yyyy");
        String year = yearDateFormat.format(date);
        monthDateFormat.applyPattern("MM");
        String month = monthDateFormat.format(date);
        String campaignNameEng = "Birthday Delight " + year + " - " + month;
        tCampaignHeaderEntity.setCampaignNameEng(campaignNameEng);

        //Fix Later
        tCampaignHeaderEntity.setCampaignStartDate(date);
        tCampaignHeaderEntity.setUpdatedDate(date);
        tCampaignHeaderEntity.setCreatedDate(date);
        tCampaignHeaderEntity.setCreatedBy("auto");
        tCampaignHeaderEntity.setUpdatedBy("auto");
        tCampaignHeaderEntity.setCampaignEndDate(date);
        tCampaignHeaderEntity.setIfaCaIndicator("test");
        tCampaignHeaderRepository.save(tCampaignHeaderEntity);

        List<TCampaignBirthdayDelightStagingEntity> tCampaignBirthdayDelightStagingEntityList = getCampaignDetailListFromCoreApi();
        TCampaignDetailEntity tCampaignDetailEntity = new TCampaignDetailEntity();
        List<TCampaignDetailEntity> tCampaignDetailEntityList = tCampaignDetailEntity.convertTCampaignBirthdayDelightStagingEntityToTCampaignDetailEntity(tCampaignBirthdayDelightStagingEntityList, tCampaignHeaderEntity.getCampaignHeaderId());
        tCampaignDetailRepository.saveAll(tCampaignDetailEntityList);
        for(TCampaignBirthdayDelightStagingEntity x:tCampaignBirthdayDelightStagingEntityList){
            x.setBatchStatus("Success");
        }
        tCampaignBirthdayDelightStagingRepository.saveAll(tCampaignBirthdayDelightStagingEntityList);
    }
    @Override
    public List<TCampaignBirthdayDelightStagingEntity> setAndSaveTCampaignBirthdayDelightStagingEntityList(List<TCampaignBirthdayDelightStagingEntity> tCampaignBirthdayDelightStagingEntityList, UUID uuid){
        for(TCampaignBirthdayDelightStagingEntity x: tCampaignBirthdayDelightStagingEntityList){
            x.setBatchNumber(uuid.toString());
            x.setBatchStatus("Ready");
        }
        tCampaignBirthdayDelightStagingRepository.saveAll(tCampaignBirthdayDelightStagingEntityList);
        return tCampaignBirthdayDelightStagingEntityList;
    }

}
