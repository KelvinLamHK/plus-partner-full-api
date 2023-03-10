package com.ftlife.plus.partner.entity;

import com.ftlife.plus.partner.parameter.RequestParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "TDocumentCenterCategory")
@NoArgsConstructor
public class TDocumentCenterCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private long categoryId;

    @Column(name = "upperCategoryId" ,nullable = false)
    private long upperCategoryId;

    @Column(name = "categoryEnglish",nullable = false)
    @Size(min = 1, max = 500)
    private String categoryEnglish;

    @Column(name = "categoryZHTW",nullable = false)
    @Size(min = 1, max = 500)
    private String categoryZHTW;

    @Column(name = "categoryZHCN")
    @Size(max = 500)
    private String categoryZHCN;


    public TDocumentCenterCategoryEntity(RequestParameter requestParameter){
        var now = new Date();
        var userParameter= requestParameter.getUserParameter();
        var documentCenterCategoryParameter= requestParameter.getDocumentCenterCategoryParameter();

        if (documentCenterCategoryParameter.getCategoryId() != null) this.categoryId = Long.parseLong(documentCenterCategoryParameter.getCategoryId());
        if (documentCenterCategoryParameter.getUpperCategoryId() != null) this.upperCategoryId = Long.parseLong(documentCenterCategoryParameter.getUpperCategoryId());
        if (documentCenterCategoryParameter.getCategoryEnglish() != null) this.categoryEnglish = documentCenterCategoryParameter.getCategoryEnglish();
        if (documentCenterCategoryParameter.getCategoryZHTW() != null) this.categoryZHTW = documentCenterCategoryParameter.getCategoryZHTW();
        if (documentCenterCategoryParameter.getCategoryZHCN() != null) this.categoryZHCN = documentCenterCategoryParameter.getCategoryZHCN();
    }

}
