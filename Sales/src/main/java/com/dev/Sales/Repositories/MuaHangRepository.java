package com.dev.Sales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Sales.Entities.MuaHangEntity;

@Repository
public interface MuaHangRepository extends JpaRepository<MuaHangEntity, Integer>{

}
