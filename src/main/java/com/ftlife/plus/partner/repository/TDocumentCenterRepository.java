package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TDocumentCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TDocumentCenterRepository extends JpaRepository<TDocumentCenterEntity, Long>, JpaSpecificationExecutor<TDocumentCenterEntity> {
}
