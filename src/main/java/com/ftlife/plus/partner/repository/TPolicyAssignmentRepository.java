package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TPolicyAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TPolicyAssignmentRepository extends JpaRepository<TPolicyAssignmentEntity, Long>, JpaSpecificationExecutor<TPolicyAssignmentEntity> {

    @Modifying
    @Query(
            value = "truncate table TPolicyAssignment",
            nativeQuery = true
    )
    void truncateTPolicyAssignment();

    @Modifying
    @Query(
            value = "insert into TPolicyAssignment select * from TPolicyAssignmentStaging",
            nativeQuery = true
    )
    void copyTPolicyAssignmentStagingToTPolicyAssignment();

}
