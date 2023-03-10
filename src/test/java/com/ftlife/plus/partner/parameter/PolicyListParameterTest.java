package com.ftlife.plus.partner.parameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolicyListParameterTest {
    @Test
    void testPojo() {
        PolicyListParameter policyListParameter = new PolicyListParameter();
        policyListParameter.setPolicyNumber("a");
        policyListParameter.setServiceAgentName("a");
        policyListParameter.setPolicyHolderNameEn("a");
        policyListParameter.setPolicyHolderNameCN("a");

        assertEquals("a", policyListParameter.getPolicyNumber());
        assertEquals("a", policyListParameter.getServiceAgentName());
        assertEquals("a", policyListParameter.getPolicyHolderNameEn());
        assertEquals("a", policyListParameter.getPolicyHolderNameCN());

    }
}
