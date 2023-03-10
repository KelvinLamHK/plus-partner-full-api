package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.VDocumentCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VDocumentCenterRepository extends JpaRepository<VDocumentCenterEntity, Long>, JpaSpecificationExecutor<VDocumentCenterEntity> {
}
