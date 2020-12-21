package com.dev.Sales.Services;

import java.io.File;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
import com.dev.Sales.Entities.TinTucEntity;
import com.dev.Sales.Repositories.SlideRepository;
import com.dev.Sales.Repositories.TinTucRepository;

@Service
public class TinTucService {

	@Autowired private TinTucRepository tintuRepository;
	@PersistenceContext protected EntityManager entityManager;
	@Value("${attachment.path}") private String attachmentPath; 
	
	@Transactional(rollbackOn = RollbackException.class)
	public void addTT(TinTucEntity tintuc, MultipartFile imageTT, HttpServletRequest request) throws Exception {
		File file = null;
		try {
				HttpSession sesstion = request.getSession();
				NguoiDungEntity nguoidung = (NguoiDungEntity) sesstion.getAttribute("ThongTinCaNhan");
			// kiểm tra xem người dùng có upload ảnh lên không ?
			if(imageTT != null && imageTT.getSize() > 0) {
				// thực hiện lưu attacment vào folder trên server.
				file = new File(attachmentPath + imageTT.getOriginalFilename());
				imageTT.transferTo(file);
				
				
				// thực hiện lưu thông tin file trong database.
				TinTucEntity tt = new TinTucEntity();
				tt.setAnh(imageTT.getOriginalFilename());
				tt.setCreatedby(nguoidung.getId().toString());
				tt.setCreatedDate(new Date());
				tt.setLuotLike(0);
				tt.setLuotXem(0);
				tt.setMoTa(tintuc.getMoTa());
				tt.setNoiDung(tintuc.getNoiDung());
				tt.setStatus(tintuc.getStatus());
				tt.setTenTT(tintuc.getTenTT());
				tintuRepository.save(tt);
			}
		} catch (Exception x) {
			if(file != null) {
				file.deleteOnExit();
			}
			throw x;
		}
	}

}
