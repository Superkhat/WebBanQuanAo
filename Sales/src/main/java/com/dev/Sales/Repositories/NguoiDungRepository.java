package com.dev.Sales.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.Sales.Entities.NguoiDungEntity;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDungEntity, Integer>{

}
