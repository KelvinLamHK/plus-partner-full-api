package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TBrokerStagingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TBrokerStagingRepository extends JpaRepository<TBrokerStagingEntity, Long>, JpaSpecificationExecutor<TBrokerStagingEntity> {
    @Modifying
    @Query(
            value = "truncate table TBrokerStaging",
            nativeQuery = true
    )
    void truncateTBrokerStaging();
}
