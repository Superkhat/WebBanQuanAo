package com.dev.Sales.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.Sales.Entities.HangSXEntity;
import com.dev.Sales.Entities.SanPhamEntity;
import com.dev.Sales.Entities.SlideEntity;
import com.dev.Sales.Entities.TheLoaiEntity;
import com.dev.Sales.Model.HangSXModel;
//import com.dev.Sales.Model.TheLoaiModel;
import com.dev.Sales.Repositories.HangSXRepository;
import com.dev.Sales.Repositories.SanPhamRepository;
import com.dev.Sales.Repositories.SlideRepository;
import com.dev.Sales.Repositories.TheLoaiRepository;
import com.dev.Sales.Services.HomeService;

@Controller
public class HomeController {
	@Autowired private HomeService homeService;
	@Autowired
	private HangSXRepository hangsx;
	@Autowired
	private TheLoaiRepository theloai;
	@Autowired
	private SanPhamRepository sanpham;
	@Autowired
	private SlideRepository slideRepositiory;

	@RequestMapping(value = { "/", "/Home" }, method = RequestMethod.GET)
	public String home(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
//		HANGSX
		List<HangSXEntity> Lhangsx = new ArrayList<HangSXEntity>();
		for (HangSXEntity Hang : hangsx.findAll()) {
			Lhangsx.add(Hang);
			
		}
// 		THELOAI
		List<TheLoaiEntity> LtheLoai = new ArrayList<TheLoaiEntity>();
		for (TheLoaiEntity loai : theloai.findAll()) {
			LtheLoai.add(loai);
		}
//		ListSanPham
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
