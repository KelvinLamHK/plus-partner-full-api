package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.TPolicyAssignmentEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PolicyAssignmentListDto {
    List<TPolicyAssignmentEntity> policyAssignmentList;
    PageableDto pagination;
}
