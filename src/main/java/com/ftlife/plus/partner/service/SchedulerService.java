package com.ftlife.plus.partner.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ftlife.plus.partner.entity.TBrokerEntity;
import com.ftlife.plus.partner.entity.TCampaignBirthdayDelightStagingEntity;
import com.ftlife.plus.partner.entity.TPolicyAssignmentEntity;

import javax.transaction.Transactional;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

public interface SchedulerService {

    List<TBrokerEntity> getBrokerListFromCoreApi() throws IOException;

    void truncateBrokerListTable();

    @Transactional
    void truncateBrokerListStagingTable();

    void executeBrokerListJob() throws Exception;

    List<TPolicyAssignmentEntity> getPolicyAssignmentListFromCoreApi() throws IOException;

    void truncatePolicyAssignmentListTable();

    @Transactional
    void truncatePolicyAssignmentListStagingTable();

    void executePolicyAssignmentListJob() throws IOException;

    List<TCampaignBirthdayDelightStagingEntity> getCampaignDetailListFromCoreApi() throws IOException;

    void executeCampaignDetailListJob() throws IOException, ParseException;

    List<TCampaignBirthdayDelightStagingEntity> setAndSaveTCampaignBirthdayDelightStagingEntityList(List<TCampaignBirthdayDelightStagingEntity> tCampaignBirthdayDelightStagingEntityList, UUID uuid);
}
