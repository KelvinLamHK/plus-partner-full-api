package com.ftlife.plus.partner.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "TBrokerStaging")
@Getter
@Setter
public class TBrokerStagingEntity extends  TBrokerCommon {

    public TBrokerStagingEntity() {
    }

    public TBrokerStagingEntity(String brokerCode, String brokerShortForm, String brokerName){
        this.brokerCode = brokerCode;
        this.brokerShortForm = brokerShortForm;
        this.brokerName = brokerName;
    }

    public List<TBrokerStagingEntity> covertTBrokerToTBrokerStagingListEntity(List<TBrokerEntity> tBrokerEntityList){
        return tBrokerEntityList
                .stream()
                .map( b -> new TBrokerStagingEntity(b.getBrokerCode(), b.getBrokerShortForm(), b.getBrokerName()))
                .collect(Collectors.toList());
    }

}
