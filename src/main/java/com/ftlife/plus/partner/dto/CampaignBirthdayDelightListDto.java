package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.TCampaignBirthdayDelightStagingEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class CampaignBirthdayDelightListDto {

    PageableDto pagination;
    List<TCampaignBirthdayDelightStagingEntity> campaignOriginalDetailList;

    public CampaignBirthdayDelightListDto(Page<TCampaignBirthdayDelightStagingEntity> tCampaignBirthdayDelightStagingEntityPage){
        Optional<List<TCampaignBirthdayDelightStagingEntity>> ContentOptional = Optional.ofNullable(tCampaignBirthdayDelightStagingEntityPage.getContent());
        this.campaignOriginalDetailList =ContentOptional.orElse(tCampaignBirthdayDelightStagingEntityPage.getContent());
        PageableDto pageableDto = new PageableDto();
        pageableDto.setPageSize(tCampaignBirthdayDelightStagingEntityPage.getPageable().getPageSize());
        pageableDto.setPageNumber(tCampaignBirthdayDelightStagingEntityPage.getPageable().getPageNumber());
        pageableDto.setTotalPages(tCampaignBirthdayDelightStagingEntityPage.getTotalPages());
        pageableDto.setTotalNumberOfRecords(tCampaignBirthdayDelightStagingEntityPage.getTotalElements());
        if (tCampaignBirthdayDelightStagingEntityPage.hasNext()){
            pageableDto.setHasNext(true);
        }
        this.pagination = pageableDto;
    }

}
