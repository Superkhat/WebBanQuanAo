package com.dev.Sales.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.Sales.Entities.HangSXEntity;
import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.PhanQuyenEntity;
import com.dev.Sales.Entities.QuyenEntity;
import com.dev.Sales.Entities.SanPhamEntity;
import com.dev.Sales.Entities.SlideEntity;
import com.dev.Sales.Entities.TheLoaiEntity;
import com.dev.Sales.Repositories.HangSXRepository;
import com.dev.Sales.Repositories.NguoiDungRepository;
import com.dev.Sales.Repositories.QuyenRepository;
import com.dev.Sales.Repositories.SanPhamRepository;
import com.dev.Sales.Repositories.SlideRepository;
import com.dev.Sales.Repositories.TheLoaiRepository;
import com.dev.Sales.Services.HangSXService;
import com.dev.Sales.Services.HomeService;
import com.dev.Sales.dto.Login;


@Controller
public class LoginController {
	@Autowired
	private HangSXRepository hangsx;
	@Autowired
	private TheLoaiRepository theloai;
	@Autowired private HangSXService hangsxService;
	@Autowired
	private SanPhamRepository sanpham;
	@Autowired private HomeService homeService;
	@Autowired
	private SlideRepository slideRepositiory;
	@Autowired private NguoiDungRepository nguoidungRepository;
	@Autowired private QuyenRepository quyenRepository;
	@RequestMapping(value = { "/Login" }, method = RequestMethod.GET)
	public String login(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		return "login";
	}
	
	@RequestMapping(value = { "/Home" }, method = RequestMethod.POST)
	public String check(@ModelAttribute("Login") Login login, ModelMap model, final HttpServletRequest request) {
		int count =0;
		for(NguoiDungEntity nguoidung : nguoidungRepository.findAll()) {
			if(nguoidung.getUserName().equals(login.getUsername())) {
				for(QuyenEntity quyen :quyenRepository.findAll()) {
					List<PhanQuyenEntity> Lphanquyen = quyen.getLphanQuyen();
					for(PhanQuyenEntity phanquyen : Lphanquyen)
						
							if(phanquyen.getQuyen_phanQuyen().getId()==1 ||phanquyen.getQuyen_phanQuyen().getId()==2) {
								
								 nguoidung = hangsxService.searchUserByUserName(login.getUsername());	
								 HttpSession httpSession = request.getSession();
								 httpSession.setAttribute("ThongTinCaNhan", nguoidung);
								
//									HANGSX
									List<HangSXEntity> Lhangsx = new ArrayList<HangSXEntity>();
									for (HangSXEntity Hang : hangsx.findAll()) {
										Lhangsx.add(Hang);
										
									}
//							 		THELOAI
									List<TheLoaiEntity> LtheLoai = new ArrayList<TheLoaiEntity>();
									for (TheLoaiEntity loai : theloai.findAll()) {
										LtheLoai.add(loai);
									}
//									ListSanPham
									List<SanPhamEntity> LsanPham = new ArrayList<SanPhamEntity>();
									for (SanPhamEntity sp : sanpham.findAll()) 
										LsanPham.add(sp);
								// SP moi
										List<SanPhamEntity> LsanPhammoi = new ArrayList<SanPhamEntity>();
										for(SanPhamEntity spmoi :homeService.sanPhamMoi())
											LsanPhammoi.add(spmoi);
							 // SP hot 
										List<SanPhamEntity> LsanPhamhot = new ArrayList<SanPhamEntity>();
										for(SanPhamEntity sphot :homeService.sanPhamHot())
											LsanPhamhot.add(sphot);
									
									//Slide
									List<SlideEntity> LSlide = new ArrayList<SlideEntity>();
									for(SlideEntity slide : slideRepositiory.findAll())
										LSlide.add(slide);
									
									model.addAttribute("LSanPham", LsanPham);
									model.addAttribute("LSanPhamMoi", LsanPhammoi);
									model.addAttribute("LSanPhamHot", LsanPhamhot);
									model.addAttribute("HangSX", Lhangsx);
									model.addAttribute("TheLoai", LtheLoai);
									model.addAttribute("ListSlide", LSlide);
								return "index";
						}
							
				}
			
		}
		
	}
	
		return "/";
		
}
}
