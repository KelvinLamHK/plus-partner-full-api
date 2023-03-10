package com.ftlife.plus.partner.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class DocumentCenterCommon extends DefaultCommon{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documentCenterId")
    long documentCenterId;

    @Column(name = "titleEnglish",nullable = false)
    @Size(min = 1, max = 500)
    String titleEnglish;

    @Column(name = "titleTraditionalChinese",nullable = false)
    @Size(min = 1, max = 500)
    String titleTraditionalChinese;

    @Column(name = "titleSimplifiedChinese")
    @Size(max = 500)
    String titleSimplifiedChinese;

    @Column(name = "documentStatus",nullable = false)
    @Size(min = 1, max = 10)
    String documentStatus;

    @Column(name = "level1CategoryId",nullable = false)
    int level1CategoryId;

    @Column(name = "level2CategoryId")
    int level2CategoryId;

    @Column(name = "descriptionEnglish",nullable = false)
    @Size(min = 1, max = 500)
    String descriptionEnglish;

    @Column(name = "descriptionTraditionalChinese",nullable = false)
    @Size(min = 1, max = 500)
    String descriptionTraditionalChinese;

    @Column(name = "descriptionSimplifiedChinese")
    @Size(max = 500)
    String descriptionSimplifiedChinese;

    @Column(name = "file1Id",nullable = false)
    long file1Id;

    @Column(name = "file2Id")
    long file2Id;

    @Column(name = "file3Id")
    long file3Id;

    @Column(name = "effectiveDateFrom")
    Date effectiveDateFrom;

    @Column(name = "effectiveDateTo")
    Date effectiveDateTo;

    @Column(name = "isPin")
    @Size(max = 10)
    String isPin;

    @Column(name = "isPromo")
    @Size(max = 10)
    String isPromo;

    @Column(name = "ifaCaIndicator",nullable = false)
    @Size(min = 1, max = 200)
    String ifaCaIndicator;


}
