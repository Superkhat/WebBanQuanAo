
  package com.dev.Sales.Repositories;
 import org.springframework.data.jpa.repository.JpaRepository; 
 import org.springframework.stereotype.Repository;  
  import com.dev.Sales.Entities.GioHangEntity;
  
  @Repository public interface GioHangRepository extends JpaRepository<GioHangEntity, Integer>{
  
  }
