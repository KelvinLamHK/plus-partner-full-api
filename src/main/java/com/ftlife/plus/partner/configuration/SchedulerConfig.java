package com.ftlife.plus.partner.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "scheduler")
@Getter
@Setter
@Component
public class SchedulerConfig {

    private String brokerListApiUrl;

    private String policyAssignmentListApiUrl;

    private String campaignBirthdayDelightListApiUrl;

}
