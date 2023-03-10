package com.ftlife.plus.partner.entity;

import com.ftlife.plus.partner.parameter.DocumentParameter;
import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.util.StringUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.util.Date;

@Entity
@Table(name = "TDocument")
@Getter
@Setter
public class TDocumentEntity extends DefaultCommon{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documentId")
    private long documentId;

    @Column(name = "documentName",nullable = false)
    @Size(min = 1, max = 500)
    private String documentName;

    @Column(name = "sourcePath",nullable = false)
    @Size(min = 1, max = 2000)
    private String sourcePath;

    @Column(name = "documentStatus",nullable = false)
    @Size(max = 1)
    private String documentStatus;

    @Column(name = "documentCategory",nullable = false)
    @Size(min = 1, max = 200)
    private String documentCategory;

    @Column(name = "documentType",nullable = false)
    @Size(min = 1, max = 200)
    private String documentType;

    @Column(name = "policyCode")
    @Size(max = 200)
    private String policyCode;

    @Column(name = "expiryDate")
    private Date expiryDate;

    @Column(name = "effectiveDate")
    private Date effectiveDate;


    public TDocumentEntity (){};

    public TDocumentEntity (RequestParameter requestParameter, String filePathString) throws ParseException {

        DocumentParameter documentParameter = requestParameter.getDocumentParameter();

        if (documentParameter.getDocumentName() != null) {
            this.documentName = documentParameter.getDocumentName();
        }

        if (filePathString != null){
            this.sourcePath = filePathString;
        }

        this.documentStatus = "A";


        if (documentParameter.getDocumentType() != null){
            this.documentType = documentParameter.getDocumentType();
        }

        if (documentParameter.getDocumentCategory() != null){
            this.documentCategory = documentParameter.getDocumentCategory();
        }

        if (documentParameter.getPolicyCode() != null) {
            this.policyCode = documentParameter.getPolicyCode();
        }

        if (documentParameter.getEffectiveDate() != null) {
            this.effectiveDate = StringUtil.stringToDate(documentParameter.getEffectiveDate(), "yyyy-MM-dd");
        }

        if (documentParameter.getExpiryDate() != null){
            this.expiryDate = StringUtil.stringToDate(documentParameter.getExpiryDate(), "yyyy-MM-dd");
        }

        this.createdBy = requestParameter.getUserParameter().getLoginName();
        this.updatedBy = requestParameter.getUserParameter().getLoginName();
        Date now = new Date();
        this.createdDate = now;
        this.updatedDate = now;

    }

}
