package com.ftlife.plus.partner.entity;

import com.ftlife.plus.partner.parameter.DocumentCenterParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.parameter.UserParameter;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TDocumentCenterEntityTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);

    public TDocumentCenterEntityTest() throws ParseException {
    }

    @Test
    void testPojo() {
        TDocumentCenterEntity tDocumentCenterEntity = new TDocumentCenterEntity();
        tDocumentCenterEntity.setCreatedBy("a");
        tDocumentCenterEntity.setCreatedDate(date);
        tDocumentCenterEntity.setDescriptionEnglish("a");
        tDocumentCenterEntity.setDescriptionSimplifiedChinese("a");
        tDocumentCenterEntity.setDescriptionTraditionalChinese("a");
        tDocumentCenterEntity.setDocumentCenterId(0);
        tDocumentCenterEntity.setDocumentStatus("a");
        tDocumentCenterEntity.setEffectiveDateFrom(date);
        tDocumentCenterEntity.setEffectiveDateTo(date);
        tDocumentCenterEntity.setFile1Id(0);
        tDocumentCenterEntity.setFile2Id(0);
        tDocumentCenterEntity.setFile3Id(0);
        tDocumentCenterEntity.setLevel1CategoryId(0);
        tDocumentCenterEntity.setLevel2CategoryId(0);
        tDocumentCenterEntity.setTitleEnglish("a");
        tDocumentCenterEntity.setTitleSimplifiedChinese("a");
        tDocumentCenterEntity.setTitleTraditionalChinese("a");
        tDocumentCenterEntity.setUpdatedBy("a");
        tDocumentCenterEntity.setUpdatedDate(date);

        assertEquals(date, tDocumentCenterEntity.getCreatedDate());
        assertEquals(date, tDocumentCenterEntity.getEffectiveDateFrom());
        assertEquals(date, tDocumentCenterEntity.getEffectiveDateTo());
        assertEquals(date, tDocumentCenterEntity.getUpdatedDate());
        assertEquals(0, tDocumentCenterEntity.getDocumentCenterId());
        assertEquals(0, tDocumentCenterEntity.getFile1Id());
        assertEquals(0, tDocumentCenterEntity.getFile2Id());
        assertEquals(0, tDocumentCenterEntity.getFile3Id());
        assertEquals(0, tDocumentCenterEntity.getLevel1CategoryId());
        assertEquals(0, tDocumentCenterEntity.getLevel2CategoryId());
        assertEquals("a", tDocumentCenterEntity.getCreatedBy());
        assertEquals("a", tDocumentCenterEntity.getDescriptionEnglish());
        assertEquals("a", tDocumentCenterEntity.getDescriptionSimplifiedChinese());
        assertEquals("a", tDocumentCenterEntity.getDescriptionTraditionalChinese());
        assertEquals("a", tDocumentCenterEntity.getDocumentStatus());
        assertEquals("a", tDocumentCenterEntity.getTitleEnglish());
        assertEquals("a", tDocumentCenterEntity.getTitleSimplifiedChinese());
        assertEquals("a", tDocumentCenterEntity.getTitleTraditionalChinese());
        assertEquals("a", tDocumentCenterEntity.getUpdatedBy());
    }

    @Test
    void tPlusDocumentCenterEntityTest() throws ParseException {
        DocumentCenterParameter documentCenterParameter = new DocumentCenterParameter();
        documentCenterParameter.setDescriptionEnglish("a");
        documentCenterParameter.setDescriptionSimplifiedChinese("a");
        documentCenterParameter.setDescriptionTraditionalChinese("a");
        documentCenterParameter.setDocumentStatus("a");
        documentCenterParameter.setEffectiveDateFrom("2022-01-01");
        documentCenterParameter.setEffectiveDateTo("2022-01-01");
        documentCenterParameter.setFile1Id("0");
        documentCenterParameter.setFile2Id("0");
        documentCenterParameter.setFile3Id("0");
        documentCenterParameter.setLevel1CategoryId("0");
        documentCenterParameter.setLevel2CategoryId("0");
        documentCenterParameter.setTitleEnglish("a");
        documentCenterParameter.setTitleSimplifiedChinese("a");
        documentCenterParameter.setTitleTraditionalChinese("a");
        documentCenterParameter.setIsPin("a");
        documentCenterParameter.setIfaCaIndicator("a");
        documentCenterParameter.setIsPromo("a");


        UserParameter userParameter = new UserParameter();
        userParameter.setLoginName("a");

        RequestParameter requestParameter = new RequestParameter();
        requestParameter.setDocumentCenterParameter(documentCenterParameter);
        requestParameter.setUserParameter(userParameter);

        TDocumentCenterEntity lastDocumentCenterEntity = new TDocumentCenterEntity();
        TDocumentCenterEntity tDocumentCenterEntity = new TDocumentCenterEntity(requestParameter, lastDocumentCenterEntity);
        tDocumentCenterEntity.setCreatedDate(date);
        tDocumentCenterEntity.setUpdatedDate(date);
        tDocumentCenterEntity.setCreatedBy("a");
        TDocumentCenterEntity tDocumentCenterNullLastEntity = new TDocumentCenterEntity(requestParameter, null);

        assertEquals(date, tDocumentCenterEntity.getCreatedDate());
        assertEquals(date, tDocumentCenterEntity.getUpdatedDate());
        assertEquals(date, tDocumentCenterEntity.getEffectiveDateFrom());
        assertEquals(date, tDocumentCenterEntity.getEffectiveDateTo());
        assertEquals(0, tDocumentCenterEntity.getDocumentCenterId());
        assertEquals(0, tDocumentCenterEntity.getFile1Id());
        assertEquals(0, tDocumentCenterEntity.getFile2Id());
        assertEquals(0, tDocumentCenterEntity.getFile3Id());
        assertEquals(0, tDocumentCenterEntity.getLevel1CategoryId());
        assertEquals(0, tDocumentCenterEntity.getLevel2CategoryId());
        assertEquals("a", tDocumentCenterEntity.getCreatedBy());
        assertEquals("a", tDocumentCenterEntity.getDescriptionEnglish());
        assertEquals("a", tDocumentCenterEntity.getDescriptionSimplifiedChinese());
        assertEquals("a", tDocumentCenterEntity.getDescriptionTraditionalChinese());
        assertEquals("a", tDocumentCenterEntity.getDocumentStatus());
        assertEquals("a", tDocumentCenterEntity.getTitleEnglish());
        assertEquals("a", tDocumentCenterEntity.getTitleSimplifiedChinese());
        assertEquals("a", tDocumentCenterEntity.getTitleTraditionalChinese());
        assertEquals("a", tDocumentCenterEntity.getUpdatedBy());
        assertEquals("a", tDocumentCenterEntity.getIsPromo());
        assertEquals("a", tDocumentCenterEntity.getIsPin());
        assertEquals("a", tDocumentCenterEntity.getIfaCaIndicator());
        assertEquals("a", tDocumentCenterNullLastEntity.getCreatedBy());


    }

}
