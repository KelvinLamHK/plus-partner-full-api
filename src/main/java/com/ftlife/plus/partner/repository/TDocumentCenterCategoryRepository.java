package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TDocumentCenterCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TDocumentCenterCategoryRepository extends JpaRepository<TDocumentCenterCategoryEntity, Long>, JpaSpecificationExecutor<TDocumentCenterCategoryEntity> {
}
