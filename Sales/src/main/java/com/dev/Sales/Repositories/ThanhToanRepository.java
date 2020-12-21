package com.dev.Sales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Sales.Entities.ThanhToanEntity;

@Repository
public interface ThanhToanRepository extends JpaRepository<ThanhToanEntity, Integer>{

}
