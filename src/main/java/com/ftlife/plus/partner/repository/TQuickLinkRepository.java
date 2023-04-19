package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.TQuickLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TQuickLinkRepository extends JpaRepository<TQuickLinkEntity, Long>, JpaSpecificationExecutor<TQuickLinkEntity> {

    List<TQuickLinkEntity> findAll();
}
