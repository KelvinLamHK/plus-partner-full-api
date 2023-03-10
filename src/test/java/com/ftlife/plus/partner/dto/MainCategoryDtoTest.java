package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.parameter.DocumentCenterCategoryParameter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainCategoryDtoTest {
    @Test
    public void TestList(){
        DocumentCenterCategoryParameter documentCenterCategoryParameter = new DocumentCenterCategoryParameter();
        documentCenterCategoryParameter.setCategoryId("123");
        documentCenterCategoryParameter.setCategoryEnglish("CategoryEnglish");
        documentCenterCategoryParameter.setCategoryZHCN("CategoryZHCN");
        documentCenterCategoryParameter.setCategoryZHTW("CategoryZHTW");
        documentCenterCategoryParameter.setUpperCategoryId("99");
        List<DocumentCenterCategoryParameter> documentCenterCategoryParameterList = new ArrayList<>();
        documentCenterCategoryParameterList.add(documentCenterCategoryParameter);
        MainCategoryDto mainCategoryDto = new MainCategoryDto();
        mainCategoryDto.setSecondLevelCategoryList(documentCenterCategoryParameterList);

        assertEquals(documentCenterCategoryParameter.getCategoryId(), mainCategoryDto.getSecondLevelCategoryList().get(0).getCategoryId());
        assertEquals(documentCenterCategoryParameter.getCategoryEnglish(), mainCategoryDto.getSecondLevelCategoryList().get(0).getCategoryEnglish());
        assertEquals(documentCenterCategoryParameter.getCategoryZHCN(), mainCategoryDto.getSecondLevelCategoryList().get(0).getCategoryZHCN());
        assertEquals(documentCenterCategoryParameter.getCategoryZHTW(), mainCategoryDto.getSecondLevelCategoryList().get(0).getCategoryZHTW());
        assertEquals(documentCenterCategoryParameter.getUpperCategoryId(), mainCategoryDto.getSecondLevelCategoryList().get(0).getUpperCategoryId());

    }
}
