package com.ftlife.plus.partner.entity;

import com.ftlife.plus.partner.parameter.DocumentParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.parameter.UserParameter;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TDocumentEntityTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);

    public TDocumentEntityTest() throws ParseException {
    }

    @Test
    void testPojo() throws ParseException {


        TDocumentEntity TDocumentEntity = new TDocumentEntity();
        TDocumentEntity.setCreatedDate(date);
        TDocumentEntity.setExpiryDate(date);
        TDocumentEntity.setEffectiveDate(date);
        TDocumentEntity.setUpdatedDate(date);
        TDocumentEntity.setDocumentId(0);
        TDocumentEntity.setDocumentStatus("a");
        TDocumentEntity.setSourcePath("a");
        TDocumentEntity.setDocumentName("a");
        TDocumentEntity.setDocumentType("a");
        TDocumentEntity.setPolicyCode("a");
        TDocumentEntity.setCreatedBy("a");
        TDocumentEntity.setUpdatedBy("a");
        TDocumentEntity.setDocumentCategory("a");



        assertEquals(date,TDocumentEntity.getCreatedDate());
        assertEquals(date,TDocumentEntity.getExpiryDate());
        assertEquals(date,TDocumentEntity.getEffectiveDate());
        assertEquals(date,TDocumentEntity.getUpdatedDate());
        assertEquals(0,TDocumentEntity.getDocumentId());
        assertEquals("a",TDocumentEntity.getSourcePath());
        assertEquals("a",TDocumentEntity.getDocumentName());
        assertEquals("a",TDocumentEntity.getDocumentType());
        assertEquals("a",TDocumentEntity.getPolicyCode());
        assertEquals("a",TDocumentEntity.getCreatedBy());
        assertEquals("a",TDocumentEntity.getUpdatedBy());
        assertEquals("a",TDocumentEntity.getDocumentStatus());
        assertEquals("a",TDocumentEntity.getDocumentCategory());

        DocumentParameter documentNullParameter = new DocumentParameter();
        UserParameter userParameter = new UserParameter();
        userParameter.setLoginName("a");


        RequestParameter requestParameter = new RequestParameter();
        requestParameter.setDocumentParameter(documentNullParameter);
        requestParameter.setUserParameter(userParameter);

        TDocumentEntity TDocumentNullEntity = new TDocumentEntity(requestParameter, "a");
        TDocumentEntity.setCreatedDate(date);
        TDocumentEntity.setUpdatedDate(date);
        TDocumentEntity.setSourcePath("a");

        assertEquals(null,TDocumentNullEntity.getDocumentCategory());

        TDocumentEntity TDocumentNullEntity1 = new TDocumentEntity(requestParameter, null);
        assertEquals(null,TDocumentNullEntity1.getSourcePath());
    }

    @Test
    void TDocumentEntityTest() throws ParseException {

        DocumentParameter documentParameter = new DocumentParameter();
        documentParameter.setDocumentName("a");
        documentParameter.setEffectiveDate("2022-01-01");
        documentParameter.setExpiryDate("2022-01-01");
        documentParameter.setDocumentType("a");
        documentParameter.setDocumentCategory("a");
        documentParameter.setPolicyCode("a");



        UserParameter userParameter = new UserParameter();
        userParameter.setLoginName("a");


        RequestParameter requestParameter = new RequestParameter();
        requestParameter.setDocumentParameter(documentParameter);
        requestParameter.setUserParameter(userParameter);

        TDocumentEntity TDocumentEntity = new TDocumentEntity(requestParameter, "a");
        TDocumentEntity.setCreatedDate(date);
        TDocumentEntity.setUpdatedDate(date);
        TDocumentEntity.setSourcePath("a");


        assertEquals(date,TDocumentEntity.getCreatedDate());
        assertEquals(date,TDocumentEntity.getExpiryDate());
        assertEquals(date,TDocumentEntity.getEffectiveDate());
        assertEquals(date,TDocumentEntity.getUpdatedDate());
        assertEquals(0,TDocumentEntity.getDocumentId());
        assertEquals("a",TDocumentEntity.getSourcePath());
        assertEquals("a",TDocumentEntity.getDocumentName());
        assertEquals("a",TDocumentEntity.getDocumentType());
        assertEquals("a",TDocumentEntity.getPolicyCode());
        assertEquals("a",TDocumentEntity.getCreatedBy());
        assertEquals("a",TDocumentEntity.getUpdatedBy());


    }
}
