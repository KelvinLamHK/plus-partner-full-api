package com.ftlife.plus.partner.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VDocumentCenterEntityTest {

    @Test
    public void testPojo(){
        VDocumentCenterEntity vDocumentCenterEntity = new VDocumentCenterEntity();
        vDocumentCenterEntity.setFile1Name("file1Name");
        vDocumentCenterEntity.setFile2Name("file2Name");
        vDocumentCenterEntity.setFile3Name("file3Name");
        assertEquals("file1Name", vDocumentCenterEntity.getFile1Name());
        assertEquals("file2Name", vDocumentCenterEntity.getFile2Name());
        assertEquals("file3Name", vDocumentCenterEntity.getFile3Name());

    }
}
