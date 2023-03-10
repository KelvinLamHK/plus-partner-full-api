package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TPolicyAssignmentStagingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TPolicyAssignmentStagingRepository extends JpaRepository<TPolicyAssignmentStagingEntity, Long>, JpaSpecificationExecutor<TPolicyAssignmentStagingEntity> {
    @Modifying
    @Query(
            value = "truncate table TPolicyAssignmentStaging",
            nativeQuery = true
    )
    void truncateTPolicyAssignmentStaging();
}
