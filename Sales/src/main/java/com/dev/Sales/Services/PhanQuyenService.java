package com.dev.Sales.Services;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.RollbackException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.PhanQuyenEntity;
import com.dev.Sales.Entities.SlideEntity;
import com.dev.Sales.Repositories.NguoiDungRepository;


@Service
public class PhanQuyenService {
	@Autowired private NguoiDungRepository nguoidungReposiory;
	@PersistenceContext protected EntityManager entityManager;
	@Transactional(rollbackOn = RollbackException.class)
	public void addPhanQuyen(PhanQuyenEntity phanquyen,  HttpServletRequest request) throws Exception {
	
		try {
			int count =0;
				HttpSession sesstion = request.getSession();
				NguoiDungEntity nguoidung = (NguoiDungEntity) sesstion.getAttribute("ThongTinCaNhan");
		for(NguoiDungEntity nd : nguoidungReposiory.findAll()) {
			System.out.println(nd.getId()+"---------"+phanquyen.getNguoidung_phanQuyen().getId());
			if(nd.getId().equals(phanquyen.getNguoidung_phanQuyen().getId()))
			for(PhanQuyenEntity pq : nd.getLphanQuyen()) {
				
				if(pq.getQuyen_phanQuyen().getId().equals(phanquyen.getQuyen_phanQuyen().getId())&&pq.getNguoidung_phanQuyen().getId().equals(phanquyen.getNguoidung_phanQuyen().getId())) {
					count++;
					break;
				}
			}
		if(count!=0)	break;
		}System.out.println("asdasfasfasfasf"+count);
		if(count==0) {
			
			PhanQuyen(phanquyen, nguoidung);
		}
		} catch (Exception x) {
		
			throw x;
		}
	}
	public void PhanQuyen(PhanQuyenEntity phanquyen,NguoiDungEntity nguoidung) {
		String jpql = "INSERT INTO `sales`.`phanquyen` (`maQuyen`, `maNguoiDung`, `createdBy`, `status`) VALUES ('"+phanquyen.getQuyen_phanQuyen().getId()+"'"
				+ ", '"+phanquyen.getNguoidung_phanQuyen().getId()+"', '"+nguoidung.getId()+"', '"+phanquyen.getStatus()+"')";
		Query query = entityManager.createNativeQuery(jpql, PhanQuyenEntity.class);
		 query.executeUpdate();
	
	}
}
