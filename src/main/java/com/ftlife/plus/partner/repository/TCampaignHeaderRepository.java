package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TCampaignHeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TCampaignHeaderRepository extends JpaRepository<TCampaignHeaderEntity, Long>, JpaSpecificationExecutor<TCampaignHeaderEntity> {
}
