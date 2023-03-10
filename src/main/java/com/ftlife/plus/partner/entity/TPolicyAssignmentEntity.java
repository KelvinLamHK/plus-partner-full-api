package com.ftlife.plus.partner.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TPolicyAssignment")
@Getter
@Setter
public class TPolicyAssignmentEntity extends TPolicyAssignmentCommon{
}
