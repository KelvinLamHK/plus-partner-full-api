package com.ftlife.plus.partner.entity;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TDocumentCenterCategoryEntityTest {

    @Test
    public void testPojo(){
        TDocumentCenterCategoryEntity tDocumentCenterCategoryEntity = new TDocumentCenterCategoryEntity();

        tDocumentCenterCategoryEntity.setCategoryId(1);
        tDocumentCenterCategoryEntity.setCategoryZHCN("a");
        tDocumentCenterCategoryEntity.setCategoryEnglish("a");
        tDocumentCenterCategoryEntity.setCategoryZHTW("a");
        tDocumentCenterCategoryEntity.setUpperCategoryId(1);

        assertEquals(1, tDocumentCenterCategoryEntity.getCategoryId());
        assertEquals(1, tDocumentCenterCategoryEntity.getUpperCategoryId());
        assertEquals("a", tDocumentCenterCategoryEntity.getCategoryZHCN());
        assertEquals("a", tDocumentCenterCategoryEntity.getCategoryZHTW());
        assertEquals("a", tDocumentCenterCategoryEntity.getCategoryEnglish());

    }
}
