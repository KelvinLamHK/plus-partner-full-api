package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TDocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TDocumentRepository extends JpaRepository<TDocumentEntity, Long>, JpaSpecificationExecutor<TDocumentEntity> {
}
