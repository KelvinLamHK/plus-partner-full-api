package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.parameter.DocumentCenterCategoryParameter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MainCategoryDto extends DocumentCenterCategoryParameter {

    List<DocumentCenterCategoryParameter> secondLevelCategoryList;

}
