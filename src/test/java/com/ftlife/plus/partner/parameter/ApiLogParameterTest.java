package com.ftlife.plus.partner.parameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiLogParameterTest {
    @Test
    public void testPojo(){
        ApiLogParameter apiLogParameter = new ApiLogParameter();
        apiLogParameter.setIpAddress("ipAddress");
        apiLogParameter.setApplication("application");
        apiLogParameter.setResponse("response");
        apiLogParameter.setError("error");
        apiLogParameter.setCreatedBy("createdBy");
        apiLogParameter.setRequestBody("requestBody");
        apiLogParameter.setRequestUrl("url");

        assertTrue(apiLogParameter.getResponse().equals("response")&&
                apiLogParameter.getError().equals("error")&&
                apiLogParameter.getApplication().equals("application")&&
                apiLogParameter.getRequestBody().equals("requestBody")&&
                        apiLogParameter.getCreatedBy().equals("createdBy")&&
                        apiLogParameter.getIpAddress().equals("ipAddress")&&
                apiLogParameter.getRequestUrl().equals("url"));
    }
}
