package com.dev.Sales.Services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.dev.Sales.Entities.BinhLuanEntity;
import com.dev.Sales.Entities.SanPhamEntity;
import com.dev.Sales.Entities.TinTucEntity;



@Service
public class BlogService {
@PersistenceContext protected EntityManager entityManager;
	
	public int soCM(int maTT)  {
		int count =0;
		String jpql = "SELECT *  FROM sales.binhluan where maTinTuc = '"+maTT+"' ";
		Query query = entityManager.createNativeQuery(jpql, BinhLuanEntity.class);
		List<BinhLuanEntity> Lbinhluan = (List<BinhLuanEntity>) query.getResultList();
		for(BinhLuanEntity bl : Lbinhluan)
			count++;
		System.out.println(count);
		return count;
	}
private static int LIMIT = 3;
	
	public List<TinTucEntity> searchPost(int pageNumber) {
		String jpql = "SELECT * From sales.tintuc ";
		Query query = entityManager.createNativeQuery(jpql, TinTucEntity.class);
		
		query.setFirstResult((pageNumber-1) * LIMIT); // bản ghi đầu tiên của trang thứ n
		query.setMaxResults(LIMIT); // số lượng items trên 1 trang.
		
		List<TinTucEntity> posts = query.getResultList();
		return posts;
	}
	
}
