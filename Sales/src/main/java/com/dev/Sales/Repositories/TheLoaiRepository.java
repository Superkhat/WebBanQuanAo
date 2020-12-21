package com.dev.Sales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Sales.Entities.TheLoaiEntity;

@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoaiEntity, Integer>{

	

}
