package com.ftlife.plus.partner.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DocumentCenterCategoryListDto {
    List<MainCategoryDto> firstLevelCategoryList;
}
