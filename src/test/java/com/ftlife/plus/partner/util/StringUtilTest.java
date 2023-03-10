package com.ftlife.plus.partner.util;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilTest {
    @Test
    void stringToDateTest () throws ParseException {
        String dateString = "2022-01-01";
        String format = "yyyy-MM-dd";

        var formatter = new SimpleDateFormat(format);

        Date date = StringUtil.stringToDate(dateString,format);

        assertEquals(date, formatter.parse(dateString));

    }

    @Test
    public void stringtoStringListTest(){
        String test = "It is Test";
        String delimiter = " ";
        List<String> ans = new ArrayList<>();
        ans.add("It");
        ans.add("is");
        ans.add("Test");
        assertEquals(ans,StringUtil.stringToStringListByDelimiter(test,delimiter));
    }
}
