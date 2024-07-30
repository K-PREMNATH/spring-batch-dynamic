package com.spring.batch.repo;

import com.spring.batch.entity.WageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WageRepo extends JpaRepository<WageEntity, Integer> {
    List<WageEntity> findByCustomerId(int customerId);

    // You can add custom query methods if needed

}