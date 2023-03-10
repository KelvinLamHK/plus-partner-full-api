package com.ftlife.plus.partner.scheduler;


import com.ftlife.plus.partner.service.SchedulerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class DataSyncScheduler {

    @Autowired
    SchedulerService schedulerService;

    @Scheduled(cron = "${scheduler.brokerListSchedule}")
    public void brokerListDataSyncScheduler() throws Exception {
        log.info("brokerListDataSyncScheduler start");
        schedulerService.executeBrokerListJob();
        log.info("brokerListDataSyncScheduler end");
    };

    @Scheduled(cron = "${scheduler.policyAssignmentListSchedule}")
    public void policyAssignmentListDataSyncScheduler() throws Exception {
        log.info("policyAssignmentListDataSyncScheduler start");
        schedulerService.executePolicyAssignmentListJob();
        log.info("policyAssignmentListDataSyncScheduler end");
    };

    @Scheduled(cron = "${scheduler.campaignBirthdayDelightListSchedule}")
    public void campaignBirthdayDelightListScheduler() throws Exception {
        log.info("campaignBirthdayDelightListSchedule start");
        schedulerService.executeCampaignDetailListJob();
        log.info("campaignBirthdayDelightListSchedule end");
    };
}
