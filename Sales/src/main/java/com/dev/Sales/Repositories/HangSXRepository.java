package com.dev.Sales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Sales.Entities.HangSXEntity;

@Repository
public interface HangSXRepository extends JpaRepository<HangSXEntity, Integer>{

}
