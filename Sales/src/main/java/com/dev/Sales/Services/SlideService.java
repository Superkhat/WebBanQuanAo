package com.dev.Sales.Services;

import java.io.File;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.RollbackException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.Sales.Entities.HangSXEntity;
import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.SlideEntity;
import com.dev.Sales.Repositories.SlideRepository;

@Service
public class SlideService {

	@Autowired private SlideRepository slideRepository;
	@PersistenceContext protected EntityManager entityManager;
	@Value("${attachment.path}") private String attachmentPath; 
	
	@Transactional(rollbackOn = RollbackException.class)
	public void addSlide(SlideEntity slide, MultipartFile slideImage, HttpServletRequest request) throws Exception {
		File file = null;
		try {
				HttpSession sesstion = request.getSession();
				NguoiDungEntity nguoidung = (NguoiDungEntity) sesstion.getAttribute("ThongTinCaNhan");
			// kiểm tra xem người dùng có upload ảnh lên không ?
			if(slideImage != null && slideImage.getSize() > 0) {
				// thực hiện lưu attacment vào folder trên server.
				file = new File(attachmentPath + slideImage.getOriginalFilename());
				slideImage.transferTo(file);
				
				
				// thực hiện lưu thông tin file trong database.
				SlideEntity sli = new SlideEntity();
				sli.setAnh(slideImage.getOriginalFilename());
				sli.setCreatedby(nguoidung.getId().toString());
				sli.setCreatedDate(new Date());
				sli.setMoTa(slide.getMoTa());
				sli.setStatus(slide.getStatus());
				sli.setTenSlide(slide.getTenSlide());
				slideRepository.save(sli);
			}
		} catch (Exception x) {
			if(file != null) {
				file.deleteOnExit();
			}
			throw x;
		}
	}
	@Transactional(rollbackOn = RollbackException.class)
	public void updateSlide(SlideEntity slide, MultipartFile slideImage, HttpServletRequest request,int id) throws Exception {
		File file = null;
		try {
			HttpSession sesstion = request.getSession();
			NguoiDungEntity nguoidung = (NguoiDungEntity) sesstion.getAttribute("ThongTinCaNhan");
		// kiểm tra xem người dùng có upload ảnh lên không ?
		if(slideImage != null && slideImage.getSize() > 0) {
			// thực hiện lưu attacment vào folder trên server.
			file = new File(attachmentPath + slideImage.getOriginalFilename());
			slideImage.transferTo(file);
			
			
			// thực hiện lưu thông tin file trong database.
			SlideEntity sli = slideRepository.getOne(id);
			sli.setAnh(slideImage.getOriginalFilename());
			sli.setModifiedBy(nguoidung.getId().toString());
			sli.setModifiedDate(new Date());
			
			sli.setMoTa(slide.getMoTa());
			sli.setStatus(slide.getStatus());
			sli.setTenSlide(slide.getTenSlide());
			slideRepository.save(sli);
			}
		} catch (Exception x) {
			if(file != null) {
				file.deleteOnExit();
			}
			throw x;
		}
}

	
//	public NguoiDungEntity searchUserByUserName(String username)  {
//		String jpql = "select * from sales.nguoidung where userName = " + "'"+username+"'";
//		Query query = entityManager.createNativeQuery(jpql, NguoiDungEntity.class);
//		NguoiDungEntity nguoidung = (NguoiDungEntity) query.getSingleResult();
//		return nguoidung;
//	}
}
