package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TBrokerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TBrokerRepository extends JpaRepository<TBrokerEntity, Long>, JpaSpecificationExecutor<TBrokerEntity> {
    @Modifying
    @Query(
            value = "truncate table TBroker",
            nativeQuery = true
    )
    void truncateTBroker();

    @Modifying
    @Query(
            value = "insert into TBroker select * from TBrokerStaging",
            nativeQuery = true
    )
    void copyTBrokerStagingToTBroker();
}
