package com.ftlife.plus.partner.dto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentCenterCategoryListDtoTest {
    @Test
    public void TestList() {
        DocumentCenterCategoryListDto documentCenterCategoryListDto = new DocumentCenterCategoryListDto();
        MainCategoryDto mainCategoryDto = new MainCategoryDto();
        mainCategoryDto.setCategoryId("123");
        List<MainCategoryDto> mainCategoryDtoList = new ArrayList<>();
        mainCategoryDtoList.add(mainCategoryDto);
        documentCenterCategoryListDto.setFirstLevelCategoryList(mainCategoryDtoList);

        assertEquals(mainCategoryDto.getCategoryId(),documentCenterCategoryListDto.getFirstLevelCategoryList().get(0).getCategoryId());
    }

}
