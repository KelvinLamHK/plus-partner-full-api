package com.ftlife.plus.partner.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "log")
@Getter
@Setter
@Component
public class LogConfig {
    private String logUrl;
    private String applicationName;
//    Internal:
//    https://flexuat.interconnect.systems/plus-partner-int/
//    client_id: a2517c3b7e06485fa89375eec2530e53
//    client_secret: 93f72319688D4EFdB43Ea15Bfe56B62A
//
//    External:
//    https://flexuat.interconnect.systems/plus-partner-ext/
//    client_id: 56ac48f8228b4602a56097d390b91786
//    client_secret: 5fFe2DE79D4247288f8BE2462ebd7Bb4
}
