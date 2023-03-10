package com.ftlife.plus.partner.parameter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentParameter {
    private String documentName;
    private String base64FileString;
    private String documentType;
    private String documentCategory;
    private String policyCode;
    private String expiryDate;
    private String effectiveDate;
    private String documentId;
}
