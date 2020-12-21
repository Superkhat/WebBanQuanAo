package com.dev.Sales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Sales.Entities.SlideEntity;

@Repository
public interface SlideRepository extends JpaRepository<SlideEntity	, Integer>{

}
