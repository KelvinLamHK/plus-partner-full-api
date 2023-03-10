package com.ftlife.plus.partner.dto;

import com.ftlife.plus.partner.entity.TBrokerEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class BrokerListDto {
    PageableDto pagination;
    List<TBrokerEntity> brokerList;

    public BrokerListDto(Page<TBrokerEntity> tBrokerEntityPage){
        Optional<List<TBrokerEntity>> ContentOptional = Optional.ofNullable(tBrokerEntityPage.getContent());
        this.brokerList =ContentOptional.orElse(tBrokerEntityPage.getContent());
        PageableDto pageableDto = new PageableDto();
        pageableDto.setPageSize(tBrokerEntityPage.getPageable().getPageSize());
        pageableDto.setPageNumber(tBrokerEntityPage.getPageable().getPageNumber());
        pageableDto.setTotalPages(tBrokerEntityPage.getTotalPages());
        pageableDto.setTotalNumberOfRecords(tBrokerEntityPage.getTotalElements());
        if (tBrokerEntityPage.hasNext()){
            pageableDto.setHasNext(true);
        }
        this.pagination = pageableDto;
    }
}
