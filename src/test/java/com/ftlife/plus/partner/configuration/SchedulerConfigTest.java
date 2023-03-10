package com.ftlife.plus.partner.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SchedulerConfigTest {

    @Test
    public void testPojo() {
        SchedulerConfig schedulerConfig = new SchedulerConfig();

        schedulerConfig.setBrokerListApiUrl("apiUrl");
        schedulerConfig.setPolicyAssignmentListApiUrl("policyAssignmentListApiUrl");
        schedulerConfig.setCampaignBirthdayDelightListApiUrl("campaignUrl");

        assertTrue(schedulerConfig.getBrokerListApiUrl().equals("apiUrl") &&
                schedulerConfig.getPolicyAssignmentListApiUrl().equals("policyAssignmentListApiUrl") &&
                schedulerConfig.getCampaignBirthdayDelightListApiUrl().equals("campaignUrl"));

    }
}
