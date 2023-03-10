package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TCampaignDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface TCampaignDetailRepository extends JpaRepository<TCampaignDetailEntity, Long>, JpaSpecificationExecutor<TCampaignDetailEntity> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM dbo.TCampaignDetail WHERE campaignHeaderId = :campaignHeaderId"
            , nativeQuery = true)
    void deleteByCampaignHeaderId(@Param("campaignHeaderId") Long campaignHeaderId);
}
