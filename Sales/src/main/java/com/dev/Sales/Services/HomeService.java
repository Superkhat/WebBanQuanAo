package com.dev.Sales.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.SanPhamEntity;

@Service
public class HomeService {
	@PersistenceContext protected EntityManager entityManager;
	
	public List<SanPhamEntity> sanPhamMoi()  {
		String jpql = "SELECT *  FROM sales.sanpham order by createdDate ASC LIMIT 8";
		Query query = entityManager.createNativeQuery(jpql, SanPhamEntity.class);
		List<SanPhamEntity> LsanPham = (List<SanPhamEntity>) query.getResultList();
		return LsanPham;
	}
	
	public List<SanPhamEntity> sanPhamHot()  {
		String jpql = "SELECT  * FROM sales.sanpham order by  luotXem DESC LIMIT 8";
		Query query = entityManager.createNativeQuery(jpql, SanPhamEntity.class);
		List<SanPhamEntity> LsanPham = (List<SanPhamEntity>) query.getResultList();
		return LsanPham;
	}
}
