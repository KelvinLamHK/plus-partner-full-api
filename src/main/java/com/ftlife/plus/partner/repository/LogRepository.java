package com.ftlife.plus.partner.repository;

import com.ftlife.plus.partner.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LogRepository extends JpaRepository<LogEntity, Long>, JpaSpecificationExecutor<LogEntity> {
    LogEntity findByToken(String token);
}


