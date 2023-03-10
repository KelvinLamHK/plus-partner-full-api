//package com.ftlife.plus.partner.controller;
//
//import com.ftlife.plus.partner.service.SchedulerService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class     SchedulerControllerTest {
//
//    @Mock
//    SchedulerService schedulerService;
//
//    @InjectMocks
//    SchedulerController schedulerController = new SchedulerController();
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testSchedulerBrokerList() throws Exception {
//        assertEquals("broker list job executed",schedulerController.schedulerBrokerListExecuteJob().getBody());
//        verify(schedulerService, times(1)).executeBrokerListJob();
//    }
//
//    @Test
//    public void testSchedulerPolicyAssignmentListExecuteJob() throws Exception {
//        assertEquals("policyAssignment list job executed",schedulerController.schedulerPolicyAssignmentListExecuteJob().getBody());
//        verify(schedulerService, times(1)).executePolicyAssignmentListJob();
//
//    }
//
//    @Test
//    public void testSchedulerCampaignBirthdayDelightListExecuteJob() throws Exception {
//        assertEquals("campaignBirthdayDelight list job executed",schedulerController.schedulerCampaignBirthdayDelightListExecuteJob().getBody());
//        verify(schedulerService, times(1)).executeCampaignDetailListJob();
//
//    }
//
//}
