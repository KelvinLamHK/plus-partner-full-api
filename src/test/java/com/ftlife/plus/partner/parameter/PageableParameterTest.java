package com.ftlife.plus.partner.parameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageableParameterTest {
    @Test
    void testPojo() {
        PageableParameter pageableParameter = new PageableParameter();
        pageableParameter.setPageNumber(0);
        pageableParameter.setPageSize(0);
        pageableParameter.setOrderBy("a");
        pageableParameter.setOrderSequence("a");


        assertEquals(0, pageableParameter.getPageNumber());
        assertEquals(0, pageableParameter.getPageSize());
        assertEquals("a", pageableParameter.getOrderBy());
        assertEquals("a", pageableParameter.getOrderSequence());
    }

}
