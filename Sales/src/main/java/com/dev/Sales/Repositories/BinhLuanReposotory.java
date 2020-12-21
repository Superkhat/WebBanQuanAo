package com.dev.Sales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;  

import com.dev.Sales.Entities.BinhLuanEntity;

@Repository
public interface BinhLuanReposotory extends JpaRepository<BinhLuanEntity, Integer>{

	

}
