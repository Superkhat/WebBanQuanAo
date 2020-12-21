package com.dev.Sales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Sales.Entities.TinTucEntity;

@Repository
public interface TinTucRepository extends JpaRepository<TinTucEntity, Integer>{

}
