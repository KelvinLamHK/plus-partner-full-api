package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.VDocumentCenterEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class DocumentCenterListDto {
    PageableDto pagination;
    List<VDocumentCenterEntity> documentCenterList;

    public DocumentCenterListDto(Page<VDocumentCenterEntity> vDocumentCenterEntityPage){
        if (vDocumentCenterEntityPage.hasContent())  this.documentCenterList = vDocumentCenterEntityPage.getContent();
        PageableDto pageableDto = new PageableDto();
        pageableDto.setPageSize(vDocumentCenterEntityPage.getPageable().getPageSize());
        pageableDto.setPageNumber(vDocumentCenterEntityPage.getPageable().getPageNumber());
        pageableDto.setTotalPages(vDocumentCenterEntityPage.getTotalPages());
        pageableDto.setTotalNumberOfRecords(vDocumentCenterEntityPage.getTotalElements());
        if (vDocumentCenterEntityPage.hasNext()){
            pageableDto.setHasNext(true);
        }
        this.pagination = pageableDto;
    }

}
