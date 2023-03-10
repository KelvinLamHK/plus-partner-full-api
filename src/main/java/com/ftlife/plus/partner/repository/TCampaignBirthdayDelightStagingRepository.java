package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TCampaignBirthdayDelightStagingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface TCampaignBirthdayDelightStagingRepository extends JpaRepository<TCampaignBirthdayDelightStagingEntity, Long>, JpaSpecificationExecutor<TCampaignBirthdayDelightStagingEntity> {
    Optional<List<TCampaignBirthdayDelightStagingEntity>> findByBatchNumber(String uuid);
}
