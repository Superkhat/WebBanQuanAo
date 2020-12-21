package com.dev.Sales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Sales.Entities.TraLoiEntity;

@Repository
public interface TraLoiRepository extends JpaRepository<TraLoiEntity, Integer>{

}
