package com.ftlife.plus.partner.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordDtoTest {
    @Test
    void testPojo(){
        RecordDto recordDto = new RecordDto();
        recordDto.setReferenceId("ReferenceId");
        recordDto.setNumberOfRecord("NumberOfRecord");
        assertEquals("ReferenceId",recordDto.getReferenceId());
        assertEquals("NumberOfRecord",recordDto.getNumberOfRecord());

    }
}
