package com.ftlife.plus.partner.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftlife.plus.partner.configuration.SchedulerConfig;
import com.ftlife.plus.partner.dto.BrokerListDto;
import com.ftlife.plus.partner.dto.CampaignBirthdayDelightListDto;
import com.ftlife.plus.partner.entity.TBrokerEntity;
import com.ftlife.plus.partner.entity.TCampaignBirthdayDelightStagingEntity;
import com.ftlife.plus.partner.parameter.*;
import com.ftlife.plus.partner.repository.*;
import com.ftlife.plus.partner.util.HttpUtil;
import com.ftlife.plus.partner.util.QuerySetupUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class SchedulerServiceImplTest {

    @Mock
    ObjectMapper objectMapper;

    @Mock
    SchedulerConfig schedulerConfig;
    @Mock
    HttpUtil httpUtil;
    @Mock
    TCampaignBirthdayDelightStagingRepository tCampaignBirthdayDelightStagingRepository;

    @Mock
    TBrokerRepository tBrokerRepository;
    @Mock
    TCampaignDetailRepository tCampaignDetailRepository;
    @Mock
    TBrokerStagingRepository tBrokerStagingRepository;
    @Mock
    SchedulerService schedulerService1;
    @Mock
    TCampaignHeaderRepository tCampaignHeaderRepository;

    @Mock
    TPolicyAssignmentStagingRepository tPolicyAssignmentStagingRepository;

    @Mock
    TPolicyAssignmentRepository tPolicyAssignmentRepository;

    @InjectMocks
    private static SchedulerService schedulerService = new SchedulerServiceImpl();

    RequestParameter requestParameter = new RequestParameter();
    PolicyListParameter policyListParameter = new PolicyListParameter();
    PageableParameter pageableParameter = new PageableParameter();
    DocumentParameter documentParameter = new DocumentParameter();
    UserParameter userParameter = new UserParameter();
    DocumentCenterParameter documentCenterParameter = new DocumentCenterParameter();
    CampaignListParameter campaignListParameter = new CampaignListParameter();
    CampaignHeaderParameter campaignHeaderParameter = new CampaignHeaderParameter();
    CampaignDetailParameter campaignDetailParameter = new CampaignDetailParameter();
    CampaignDetailListParameter campaignDetailListParameter = new CampaignDetailListParameter();
    DocumentCenterCategoryParameter documentCenterCategoryParameter = new DocumentCenterCategoryParameter();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testTruncateBrokerListTable(){
        schedulerService.truncateBrokerListTable();
        verify(tBrokerRepository, times(1)).truncateTBroker();
    }

    @Test
    public void testTruncatePolicyAssignmentListStagingTable() throws Exception {
        schedulerService.truncatePolicyAssignmentListStagingTable();
        verify(tPolicyAssignmentStagingRepository, times(1)).truncateTPolicyAssignmentStaging();
    }

    @Test
    public void testTruncatePolicyAssignmentListTable() throws Exception {
        schedulerService.truncatePolicyAssignmentListTable();
        verify(tPolicyAssignmentRepository, times(1)).truncateTPolicyAssignment();
    }

    @Test
    public void testTruncateBrokerListStagingTable() throws Exception {
        schedulerService.truncateBrokerListStagingTable();
        verify(tBrokerStagingRepository, times(1)).truncateTBrokerStaging();
    }

    @Test
    public void testSetAndSaveTCampaignBirthdayDelightStagingEntityList(){
        TCampaignBirthdayDelightStagingEntity tCampaignBirthdayDelightStagingEntity = new TCampaignBirthdayDelightStagingEntity();
        List<TCampaignBirthdayDelightStagingEntity> tCampaignBirthdayDelightStagingEntityList = new ArrayList<>();
        tCampaignBirthdayDelightStagingEntityList.add(tCampaignBirthdayDelightStagingEntity);
        UUID uuid = UUID.randomUUID();
        schedulerService.setAndSaveTCampaignBirthdayDelightStagingEntityList(tCampaignBirthdayDelightStagingEntityList,uuid );
    }


}
