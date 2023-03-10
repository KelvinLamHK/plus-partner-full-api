package com.ftlife.plus.partner.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogConfigTest {

    @Test
    public void testPojo(){
        LogConfig logConfig = new LogConfig();
        logConfig.setLogUrl("logUrl");
        logConfig.setApplicationName("applicationName");
        assertTrue(logConfig.getLogUrl().equals("logUrl")&&logConfig.getApplicationName().equals("applicationName"));
    }
}
