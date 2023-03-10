package com.ftlife.plus.partner.entity;

import com.ftlife.plus.partner.parameter.DocumentCenterParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.parameter.UserParameter;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TDocumentCenterVisibilityEntityTest {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2022-01-01";
    Date date = formatter.parse(dateInString);

    public TDocumentCenterVisibilityEntityTest() throws ParseException {
    }

    @Test
    public void testTDocumentCenterVisibilityEntity() {
        TDocumentCenterVisibilityEntity tDocumentCenterVisibilityEntity = new TDocumentCenterVisibilityEntity();
        tDocumentCenterVisibilityEntity.setDocumentCenterId(1);
        tDocumentCenterVisibilityEntity.setCreatedDate(date);
        tDocumentCenterVisibilityEntity.setUpdatedDate(date);
        tDocumentCenterVisibilityEntity.setDocumentCenterVisibilityId(1);
        tDocumentCenterVisibilityEntity.setAgentCode("a");
        tDocumentCenterVisibilityEntity.setUpdatedBy("a");
        tDocumentCenterVisibilityEntity.setCreatedBy("a");

        assertEquals(1,tDocumentCenterVisibilityEntity.getDocumentCenterId());
        assertEquals(1,tDocumentCenterVisibilityEntity.getDocumentCenterVisibilityId());
        assertEquals("a",tDocumentCenterVisibilityEntity.getAgentCode());
        assertEquals("a",tDocumentCenterVisibilityEntity.getCreatedBy());
        assertEquals("a",tDocumentCenterVisibilityEntity.getUpdatedBy());
        assertEquals(date,tDocumentCenterVisibilityEntity.getCreatedDate());
        assertEquals(date,tDocumentCenterVisibilityEntity.getUpdatedDate());
    }

    @Test
    public void prepareTDocumentCenterVisibilityEntityList(){
        TDocumentCenterVisibilityEntity tDocumentCenterVisibilityEntity = new TDocumentCenterVisibilityEntity();
        RequestParameter requestParameter = new RequestParameter();
        DocumentCenterParameter documentCenterParameter = new DocumentCenterParameter();
        documentCenterParameter.setDocumentCenterId("1");
        UserParameter userParameter = new UserParameter();
        userParameter.setLoginName("a");
        requestParameter.setUserParameter(userParameter);
        requestParameter.setDocumentCenterParameter(documentCenterParameter);
        String test[]={"a"};
        documentCenterParameter.setVisibilityList(test);
        List<TDocumentCenterVisibilityEntity> tDocumentCenterVisibilityEntityList = new ArrayList<>();
        tDocumentCenterVisibilityEntity.setAgentCode("a");
        tDocumentCenterVisibilityEntityList.add(tDocumentCenterVisibilityEntity);
        assertEquals(tDocumentCenterVisibilityEntityList.get(0).getAgentCode(), tDocumentCenterVisibilityEntity.prepareTDocumentCenterVisibilityEntityList(requestParameter).get(0).getAgentCode() );
        documentCenterParameter.setVisibilityList(null);
        requestParameter.setDocumentCenterParameter(documentCenterParameter);
        List<TDocumentCenterVisibilityEntity> emptyList = new ArrayList<TDocumentCenterVisibilityEntity>();
        assertEquals(emptyList, tDocumentCenterVisibilityEntity.prepareTDocumentCenterVisibilityEntityList(requestParameter) );

    }
    
}
