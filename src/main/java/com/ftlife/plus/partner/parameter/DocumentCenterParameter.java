package com.ftlife.plus.partner.parameter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentCenterParameter {
    private String documentCenterId;
    private String titleEnglish;
    private String titleTraditionalChinese;
    private String titleSimplifiedChinese;
    private String documentStatus;
    private String level1CategoryId;
    private String level2CategoryId;
    private String descriptionEnglish;
    private String descriptionTraditionalChinese;
    private String descriptionSimplifiedChinese;
    private String file1Id;
    private String file2Id;
    private String file3Id;
    private String isPin;
    private String isPromo;
    private String ifaCaIndicator;
    private String effectiveDateFrom;
    private String effectiveDateTo;
    private String createdDateFrom;
    private String createdDateTo;
    private String updatedDateFrom;
    private String updatedDateTo;
    private String[] visibilityList;
}
