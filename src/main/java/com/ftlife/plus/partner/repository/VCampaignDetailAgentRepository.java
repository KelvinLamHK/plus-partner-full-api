package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.VCampaignDetailAgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VCampaignDetailAgentRepository extends JpaRepository<VCampaignDetailAgentEntity, Long>, JpaSpecificationExecutor<VCampaignDetailAgentEntity> {
}
