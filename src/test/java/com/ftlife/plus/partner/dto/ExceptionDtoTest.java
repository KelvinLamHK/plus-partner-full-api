package com.ftlife.plus.partner.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionDtoTest {
    @Test
    void exceptionDtoTest(){
        var exceptionDto = new ExceptionDto();
        exceptionDto.setErrorMessage("ErrorMessage");
        assertEquals("ErrorMessage",exceptionDto.getErrorMessage());
    }
}
