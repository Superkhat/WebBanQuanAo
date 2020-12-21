package com.dev.Sales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Sales.Entities.QuyenEntity;

@Repository
public interface QuyenRepository extends JpaRepository<QuyenEntity, Integer>{

}
