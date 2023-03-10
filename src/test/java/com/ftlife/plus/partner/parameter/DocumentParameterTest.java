package com.ftlife.plus.partner.parameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentParameterTest {
    @Test
    void testPojo()  {
        DocumentParameter documentParameter = new DocumentParameter();
        documentParameter.setDocumentName("a");
        documentParameter.setBase64FileString("a");
        documentParameter.setDocumentType("a");
        documentParameter.setDocumentCategory("a");
        documentParameter.setPolicyCode("a");
        documentParameter.setExpiryDate("a");
        documentParameter.setEffectiveDate("a");
        documentParameter.setDocumentId("a");

        assertEquals("a",documentParameter.getDocumentName());
        assertEquals("a",documentParameter.getBase64FileString());
        assertEquals("a",documentParameter.getDocumentType());
        assertEquals("a",documentParameter.getDocumentCategory());
        assertEquals("a",documentParameter.getPolicyCode());
        assertEquals("a",documentParameter.getExpiryDate());
        assertEquals("a",documentParameter.getEffectiveDate());
        assertEquals("a",documentParameter.getDocumentId());


    }
}
