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
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.Sales.Controller.SecurityController;
import com.dev.Sales.Controller.ADMIN.Add;
import com.dev.Sales.Entities.HangSXEntity;
import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Repositories.HangSXRepository;


@Service
public class HangSXService {
	@Autowired private HangSXRepository hangsxRepository;
	@PersistenceContext protected EntityManager entityManager;
	@Value("${attachment.path}") private String attachmentPath; 
	
	@Transactional(rollbackOn = RollbackException.class)
	public void addHangSX(HangSXEntity hangsx, MultipartFile HangSXimage,HttpServletRequest request) throws Exception {
		File file = null;
		try {
			 HttpSession httpSession = request.getSession();
			
			// kiểm tra xem người dùng có upload ảnh lên không ?
			if(HangSXimage != null && HangSXimage.getSize() > 0) {
				// thực hiện lưu attacment vào folder trên server.
				file = new File(attachmentPath + HangSXimage.getOriginalFilename());
				HangSXimage.transferTo(file);
				
				NguoiDungEntity nguoidungSession = (NguoiDungEntity) httpSession.getAttribute("ThongTinCaNhan");
				// thực hiện lưu thông tin file trong database.
				HangSXEntity hang = new HangSXEntity();
				hang.setAnh(HangSXimage.getOriginalFilename());
				hang.setCreatedby(nguoidungSession.getId().toString());
				hang.setCreatedDate(new Date());
				hang.setDiaChi(hangsx.getDiaChi());
				hang.setEmail(hangsx.getEmail());
				hang.setMoTa(hangsx.getMoTa());
				hang.setSdt(hangsx.getSdt());
				hang.setStatus(hangsx.getStatus());
				hang.setTenHang(hangsx.getTenHang());
				hangsxRepository.save(hang);
			}
		} catch (Exception x) {
			if(file != null) {
				file.deleteOnExit();
			}
			throw x;
		}
	}
		
		@Transactional(rollbackOn = RollbackException.class)
		public void updateHang(HangSXEntity hangsx, MultipartFile HangSXimage,HttpServletRequest request,int id) throws Exception {
			File file = null;
			try {
				 HttpSession httpSession = request.getSession();
				
				// kiểm tra xem người dùng có upload ảnh lên không ?
				if(HangSXimage != null && HangSXimage.getSize() > 0) {
					// thực hiện lưu attacment vào folder trên server.
					file = new File(attachmentPath + HangSXimage.getOriginalFilename());
					HangSXimage.transferTo(file);
					
					NguoiDungEntity nguoidungSession = (NguoiDungEntity) httpSession.getAttribute("ThongTinCaNhan");
					// thực hiện lưu thông tin file trong database.
					HangSXEntity hang = hangsxRepository.getOne(id);
					
					hang.setAnh(HangSXimage.getOriginalFilename());
					hang.setModifiedBy(nguoidungSession.getId().toString());
					hang.setModifiedDate(new Date());
					
					hang.setDiaChi(hangsx.getDiaChi());
					hang.setEmail(hangsx.getEmail());
					hang.setMoTa(hangsx.getMoTa());
					hang.setSdt(hangsx.getSdt());
					hang.setStatus(hangsx.getStatus());
					hang.setTenHang(hangsx.getTenHang());
					hangsxRepository.save(hang);
				}
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
	public int  soHang()  {
		int count = 0;
		String jpql = "select * from sales.hangsx ";
		Query query = entityManager.createNativeQuery(jpql, HangSXEntity.class);
		List<HangSXEntity> Lhang = (List<HangSXEntity>) query.getResultList();
		for(HangSXEntity hang : Lhang)
			count++;
		return count;
	}
}
