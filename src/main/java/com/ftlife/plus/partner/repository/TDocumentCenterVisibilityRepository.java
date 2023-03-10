package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TDocumentCenterVisibilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TDocumentCenterVisibilityRepository extends JpaRepository<TDocumentCenterVisibilityEntity, Long>, JpaSpecificationExecutor<TDocumentCenterVisibilityEntity> {
    @Transactional
    @Modifying(clearAutomatically = true)
    void deleteByDocumentCenterId(long documentCenterId);
    List<TDocumentCenterVisibilityEntity> findByDocumentCenterId(long documentCenterId);

}
