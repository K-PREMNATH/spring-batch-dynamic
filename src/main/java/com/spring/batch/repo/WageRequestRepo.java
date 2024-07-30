package com.spring.batch.repo;

import com.spring.batch.entity.WageReqEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WageRequestRepo extends JpaRepository<WageReqEntity, Integer> {
    List<WageReqEntity> findByRequestId(String requestId);

    // You can add custom query methods if needed

}