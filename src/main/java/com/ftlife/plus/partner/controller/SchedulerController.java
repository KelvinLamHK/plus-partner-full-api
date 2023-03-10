//package com.ftlife.plus.partner.controller;
//
//import com.ftlife.plus.partner.service.SchedulerService;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Log4j2
//public class SchedulerController {
//
//    @Autowired
//    SchedulerService schedulerService;
//
//    @PostMapping("/scheduler/broker/list/execute-job")
//    public ResponseEntity<Object> schedulerBrokerListExecuteJob() throws Exception {
//        schedulerService.executeBrokerListJob();
//        return ResponseEntity.ok().body("broker list job executed");
//    }
//
//    @PostMapping("/scheduler/policy-assignment/list/execute-job")
//    public ResponseEntity<Object> schedulerPolicyAssignmentListExecuteJob() throws Exception {
//        schedulerService.executePolicyAssignmentListJob();
//        return ResponseEntity.ok().body("policyAssignment list job executed");
//    }
//
//    @PostMapping("/scheduler/campaignBirthdayDelight/list/execute-job")
//    public ResponseEntity<Object> schedulerCampaignBirthdayDelightListExecuteJob() throws Exception {
//        schedulerService.executeCampaignDetailListJob();
//        return ResponseEntity.ok().body("campaignBirthdayDelight list job executed");
//    }
//
//}
