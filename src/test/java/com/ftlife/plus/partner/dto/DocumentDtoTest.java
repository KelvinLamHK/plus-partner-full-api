package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.TDocumentEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentDtoTest {
    @Test
    void testPojo(){

        DocumentDto documentDto = new DocumentDto();
        documentDto.setDocumentName("name");
        documentDto.setDocumentBase64String("64String");

        assertEquals("name",documentDto.getDocumentName());
        assertEquals("64String",documentDto.getDocumentBase64String());

    }

    @Test
    void testDocumentDto(){
        TDocumentEntity tPlusDocumentEntity = new TDocumentEntity();
        tPlusDocumentEntity.setDocumentName("name");
        DocumentDto documentDto = new DocumentDto(tPlusDocumentEntity,"64String");

        assertEquals("name",documentDto.getDocumentName());
        assertEquals("64String",documentDto.getDocumentBase64String());

    }
}
