package com.ftlife.plus.partner.configuration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SFTPConfigTest {
    @Test
    void testPojo(){
        var sftpConfig = new SFTPConfig();
        sftpConfig.setDestination("uatvfs01");
        sftpConfig.setPort("22");
        sftpConfig.setUsername("svc.plusuat_api");
        sftpConfig.setPassword("mKa730rpu@0pxF");

        assertEquals("uatvfs01",sftpConfig.getDestination());
        assertEquals("22",sftpConfig.getPort());
        assertEquals("svc.plusuat_api",sftpConfig.getUsername());
        assertEquals("mKa730rpu@0pxF",sftpConfig.getPassword());
    }
}
