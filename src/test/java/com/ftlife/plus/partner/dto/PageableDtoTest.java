package com.ftlife.plus.partner.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageableDtoTest {
    @Test
    void testPojo(){
        PageableDto pageableDto = new PageableDto();
        pageableDto.setPageNumber(1);
        pageableDto.setPageSize(2);
        pageableDto.setHasNext(false);
        pageableDto.setTotalPages(3);
        pageableDto.setTotalNumberOfRecords(4);

        assertEquals(1,pageableDto.getPageNumber());
        assertEquals(2,pageableDto.getPageSize());
        assertEquals(false, pageableDto.hasNext);
        assertEquals(3,pageableDto.getTotalPages());
        assertEquals(4,pageableDto.getTotalNumberOfRecords());
    }
}
