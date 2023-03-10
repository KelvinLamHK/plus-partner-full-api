package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.TDocumentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentDto {
    String documentName;
    String documentBase64String;

    public DocumentDto(){}

    public DocumentDto(TDocumentEntity tPlusDocumentEntity, String documentBase64String){
        this.documentName = tPlusDocumentEntity.getDocumentName();
        this.documentBase64String = documentBase64String;
    }
}
