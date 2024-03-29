package com.ftlife.plus.partner.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "smb")
@Getter
@Setter
@Component
public class SMBConfig {
    private String host;
    private String share;
    private String path;
    private String domain;
    private String username;
    private String password;
}
