package com.ftlife.plus.partner.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class TBrokerCommon {

    @Id
    @Column(name = "brokerCode")
    String brokerCode;

    @Column(name = "brokerShortForm")
    String brokerShortForm;

    @Column(name = "brokerName")
    String brokerName;

}
