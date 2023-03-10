package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.VCampaignHeaderBrokerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VCampaignHeaderBrokerRepository extends JpaRepository<VCampaignHeaderBrokerEntity, Long>, JpaSpecificationExecutor<VCampaignHeaderBrokerEntity> {
}
