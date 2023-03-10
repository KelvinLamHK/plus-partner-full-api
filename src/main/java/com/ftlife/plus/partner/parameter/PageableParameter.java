package com.ftlife.plus.partner.parameter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableParameter {

    int pageNumber;
    int pageSize;
    String orderBy;
    String orderSequence;

}
