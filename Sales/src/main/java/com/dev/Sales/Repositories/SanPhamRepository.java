package com.dev.Sales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Sales.Entities.SanPhamEntity;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Integer>{

}
