package com.ftlife.plus.partner.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VDocumentCenter")
@Getter
@Setter
@Immutable
@NoArgsConstructor
public class VDocumentCenterEntity extends DocumentCenterCommon {

    @Column(name = "file1Name",nullable = false)
    String file1Name;

    @Column(name = "file2Name",nullable = false)
    String file2Name;

    @Column(name = "file3Name",nullable = false)
    String file3Name;

}
