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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.SlideEntity;
import com.dev.Sales.Repositories.NguoiDungRepository;
import com.dev.Sales.Repositories.SlideRepository;

@Service
public class NguoiDungService {
	@Autowired private NguoiDungRepository NguoiDungRepository;
	@PersistenceContext protected EntityManager entityManager;
	@Value("${attachment.path}") private String attachmentPath; 
	
	@Transactional(rollbackOn = RollbackException.class)
	public void addND(NguoiDungEntity nguoidung, MultipartFile imageND, HttpServletRequest request) throws Exception {
		File file = null;
		try {
				HttpSession sesstion = request.getSession();
				NguoiDungEntity ndung = (NguoiDungEntity) sesstion.getAttribute("ThongTinCaNhan");
			// kiểm tra xem người dùng có upload ảnh lên không ?
			if(imageND != null && imageND.getSize() > 0) {
				// thực hiện lưu attacment vào folder trên server.
				file = new File(attachmentPath + imageND.getOriginalFilename());
				imageND.transferTo(file);
				
				
				// thực hiện lưu thông tin file trong database.
				NguoiDungEntity ndSave = new NguoiDungEntity();
				ndSave.setAnh(imageND.getOriginalFilename());
				ndSave.setCreatedby(ndung.getId().toString());
				ndSave.setCreatedDate(new Date());
				ndSave.setDiaChi(nguoidung.getDiaChi());
				ndSave.setEmail(nguoidung.getEmail());
				ndSave.setPassWord(nguoidung.getPassWord());
				ndSave.setSdt(nguoidung.getSdt());
				ndSave.setStatus(nguoidung.getStatus());
				ndSave.setTenND(nguoidung.getTenND());
				ndSave.setUserName(nguoidung.getUserName());
				NguoiDungRepository.save(ndSave);
			}
		} catch (Exception x) {
			if(file != null) {
				file.deleteOnExit();
			}
			throw x;
		}
	}
	@Transactional(rollbackOn = RollbackException.class)
	public void udND(NguoiDungEntity nguoidung, MultipartFile imageND, HttpServletRequest request,int id) throws Exception {
		File file = null;
		try {
				HttpSession sesstion = request.getSession();
				NguoiDungEntity ndung = (NguoiDungEntity) sesstion.getAttribute("ThongTinCaNhan");
			// kiểm tra xem người dùng có upload ảnh lên không ?
			if(imageND != null && imageND.getSize() > 0) {
				// thực hiện lưu attacment vào folder trên server.
				file = new File(attachmentPath + imageND.getOriginalFilename());
				imageND.transferTo(file);
			}
				
				// thực hiện lưu thông tin file trong database.
				NguoiDungEntity ndSave = NguoiDungRepository.getOne(id);
				if(imageND.getSize() > 0) {
					ndSave.setAnh(imageND.getOriginalFilename());
					System.out.println("ssssssssssssss - "+imageND.getOriginalFilename());
				}
				ndSave.setModifiedBy(ndung.getId().toString());
				ndSave.setModifiedDate(new Date());
				ndSave.setDiaChi(nguoidung.getDiaChi());
				ndSave.setEmail(nguoidung.getEmail());
				
				ndSave.setSdt(nguoidung.getSdt());
				ndSave.setStatus((byte) 1);
				ndSave.setTenND(nguoidung.getTenND());
				
				NguoiDungRepository.save(ndSave);
				sesstion.setAttribute("ThongTinCaNhan", ndSave);
			
		} catch (Exception x) {
			if(file != null) {
				file.deleteOnExit();
			}
			throw x;
		}
	}
	
	public NguoiDungEntity searchUserByUserName(String username)  {
		String jpql = "select * from sales.nguoidung where userName = " + "'"+username+"'";
		Query query = entityManager.createNativeQuery(jpql, NguoiDungEntity.class);
		NguoiDungEntity nguoidung = (NguoiDungEntity) query.getSingleResult();
		return nguoidung;
	}
	public int  soTK()  {
		int count = 0;
		String jpql = "select * from sales.nguoidung ";
		Query query = entityManager.createNativeQuery(jpql, NguoiDungEntity.class);
		List<NguoiDungEntity> Lnguoidung = (List<NguoiDungEntity>) query.getResultList();
		for(NguoiDungEntity nd : Lnguoidung)
			count++;
		return count;
	}
	
}
