package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.TBrokerEntity;
import com.ftlife.plus.partner.entity.VCampaignDetailAgentEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class CampaignDetailListDto {
    List<VCampaignDetailAgentEntity> campaignDetailList;
    PageableDto pagination;

    public CampaignDetailListDto(Page<VCampaignDetailAgentEntity> vCampaignDetailAgentEntityPage){
        Optional<List<VCampaignDetailAgentEntity>> ContentOptional = Optional.ofNullable(vCampaignDetailAgentEntityPage.getContent());
        this.campaignDetailList =ContentOptional.orElse(vCampaignDetailAgentEntityPage.getContent());
        PageableDto pageableDto = new PageableDto();
        pageableDto.setPageSize(vCampaignDetailAgentEntityPage.getPageable().getPageSize());
        pageableDto.setPageNumber(vCampaignDetailAgentEntityPage.getPageable().getPageNumber());
        pageableDto.setTotalPages(vCampaignDetailAgentEntityPage.getTotalPages());
        pageableDto.setTotalNumberOfRecords(vCampaignDetailAgentEntityPage.getTotalElements());
        if (vCampaignDetailAgentEntityPage.hasNext()){
            pageableDto.setHasNext(true);
        }
        this.pagination = pageableDto;

    }
}
