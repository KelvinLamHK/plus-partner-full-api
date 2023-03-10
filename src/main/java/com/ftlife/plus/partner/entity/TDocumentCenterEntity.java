package com.ftlife.plus.partner.entity;

import com.ftlife.plus.partner.parameter.RequestParameter;
import com.ftlife.plus.partner.util.StringUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "TDocumentCenter")
@Getter
@Setter
public class TDocumentCenterEntity extends DocumentCenterCommon {


    public TDocumentCenterEntity(){}

    public TDocumentCenterEntity(RequestParameter requestParameter, TDocumentCenterEntity lastTDocumentCenterEntity) throws ParseException {

        if (lastTDocumentCenterEntity != null){
            this.documentCenterId = lastTDocumentCenterEntity.documentCenterId;
            this.titleEnglish = lastTDocumentCenterEntity.titleEnglish;
            this.titleTraditionalChinese = lastTDocumentCenterEntity.titleTraditionalChinese;
            this.titleSimplifiedChinese = lastTDocumentCenterEntity.titleSimplifiedChinese;
            this.documentStatus = lastTDocumentCenterEntity.documentStatus;
            this.level1CategoryId = lastTDocumentCenterEntity.level1CategoryId;
            this.level2CategoryId = lastTDocumentCenterEntity.level2CategoryId;
            this.descriptionEnglish = lastTDocumentCenterEntity.descriptionEnglish;
            this.descriptionTraditionalChinese = lastTDocumentCenterEntity.descriptionTraditionalChinese;
            this.descriptionSimplifiedChinese = lastTDocumentCenterEntity.descriptionSimplifiedChinese;
            this.file1Id = lastTDocumentCenterEntity.file1Id;
            this.file2Id = lastTDocumentCenterEntity.file2Id;
            this.file3Id = lastTDocumentCenterEntity.file3Id;
            this.effectiveDateFrom = lastTDocumentCenterEntity.effectiveDateFrom;
            this.effectiveDateTo = lastTDocumentCenterEntity.effectiveDateTo;
            this.createdDate = lastTDocumentCenterEntity.createdDate;
            this.updatedDate = lastTDocumentCenterEntity.updatedDate;
            this.createdBy = lastTDocumentCenterEntity.createdBy;
            this.updatedBy = lastTDocumentCenterEntity.updatedBy;
            this.isPin = lastTDocumentCenterEntity.isPin;
            this.isPromo = lastTDocumentCenterEntity.isPromo;
            this.ifaCaIndicator = lastTDocumentCenterEntity.ifaCaIndicator;
        }

        var userParameter = requestParameter.getUserParameter();
        var documentCenterParameter = requestParameter.getDocumentCenterParameter();

        Optional<String> TitleEnglishOptional = Optional.ofNullable(documentCenterParameter.getTitleEnglish());
        this.titleEnglish=TitleEnglishOptional.orElse(documentCenterParameter.getTitleEnglish());

        Optional<String> TraditionalChineseOptional = Optional.ofNullable(documentCenterParameter.getTitleTraditionalChinese());
        this.titleTraditionalChinese=TraditionalChineseOptional.orElse(documentCenterParameter.getTitleTraditionalChinese());

        Optional<String> TitleSimplifiedChineseOptional = Optional.ofNullable(documentCenterParameter.getTitleSimplifiedChinese());
        this.titleSimplifiedChinese=TitleSimplifiedChineseOptional.orElse(documentCenterParameter.getTitleSimplifiedChinese());

        Optional<String> DocumentStatusOptional = Optional.ofNullable(documentCenterParameter.getDocumentStatus());
        this.documentStatus=DocumentStatusOptional.orElse(documentCenterParameter.getDocumentStatus());

        Optional<String> DescriptionEnglishOptional = Optional.ofNullable(documentCenterParameter.getDescriptionEnglish());
        this.descriptionEnglish=DescriptionEnglishOptional.orElse(documentCenterParameter.getDescriptionEnglish());

        if (documentCenterParameter.getLevel1CategoryId() != null){
            this.level1CategoryId = Integer.parseInt(documentCenterParameter.getLevel1CategoryId());
        }

        if (documentCenterParameter.getLevel2CategoryId() != null){
            this.level2CategoryId = Integer.parseInt(documentCenterParameter.getLevel2CategoryId());
        }

        if (documentCenterParameter.getDescriptionTraditionalChinese() != null){
            this.descriptionTraditionalChinese = documentCenterParameter.getDescriptionTraditionalChinese();
        }

        if (documentCenterParameter.getDescriptionSimplifiedChinese() != null){
            this.descriptionSimplifiedChinese = documentCenterParameter.getDescriptionSimplifiedChinese();
        }

        if (documentCenterParameter.getFile1Id() != null){
            this.file1Id = Long.parseLong(documentCenterParameter.getFile1Id());
        }

        if (documentCenterParameter.getFile2Id() != null){
            this.file2Id = Long.parseLong(documentCenterParameter.getFile2Id());
        }

        if (documentCenterParameter.getFile3Id() != null){
            this.file3Id = Long.parseLong(documentCenterParameter.getFile3Id());
        }

        if (documentCenterParameter.getEffectiveDateFrom() != null) {
            this.effectiveDateFrom = StringUtil.stringToDate(documentCenterParameter.getEffectiveDateFrom(),"yyyy-MM-dd");
        }

        if (documentCenterParameter.getEffectiveDateTo() != null){
            this.effectiveDateTo = StringUtil.stringToDate(documentCenterParameter.getEffectiveDateTo(),"yyyy-MM-dd");
        }

        if (documentCenterParameter.getIsPin() != null){
            this.isPin = documentCenterParameter.getIsPin();
        }

        if (documentCenterParameter.getIsPromo() != null){
            this.isPromo = documentCenterParameter.getIsPromo();
        }

        if (documentCenterParameter.getIfaCaIndicator() != null){
            this.ifaCaIndicator = documentCenterParameter.getIfaCaIndicator();
        }

        Date now = new Date();

        if (lastTDocumentCenterEntity == null){
            this.createdBy = userParameter.getLoginName();
            this.createdDate = now;
        }

        this.updatedBy = userParameter.getLoginName();
        this.updatedDate = now;

    }



}
