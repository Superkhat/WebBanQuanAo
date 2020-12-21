package com.dev.Sales.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.Sales.Entities.HangSXEntity;
import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.SanPhamEntity;
import com.dev.Sales.Entities.TheLoaiEntity;
import com.dev.Sales.Entities.TinTucEntity;
import com.dev.Sales.Repositories.HangSXRepository;
import com.dev.Sales.Repositories.NguoiDungRepository;
import com.dev.Sales.Repositories.TheLoaiRepository;
import com.dev.Sales.Repositories.TinTucRepository;
import com.dev.Sales.Services.BlogService;
import com.dev.Sales.Services.HomeService;

@Controller
public class BlogController {
	@Autowired private HomeService homeService;
	@Autowired
	private  NguoiDungRepository nguoidungRepository;
	@Autowired
	private HangSXRepository hangsx;
	@Autowired
	private BlogService blogservice;
	@Autowired
	private TinTucRepository tintucRepository;
	@Autowired private TheLoaiRepository theloai;
	@RequestMapping(value = { "/TinTuc" }, method = RequestMethod.GET)
	public String view(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		int max =2;
		for(TinTucEntity t : tintucRepository.findAll())
			max++;
		int pageNumber = 1;
		if(request.getParameter("page") != null) {
			pageNumber = Integer.valueOf(request.getParameter("page"));
			if(pageNumber < 1) pageNumber = 1;
			if(pageNumber > max/3) pageNumber = pageNumber-1;
		}
		 
		//		HANGSX
		List<HangSXEntity> Lhangsx = new ArrayList<HangSXEntity>();
		for (HangSXEntity Hang : hangsx.findAll()) {
			Lhangsx.add(Hang);
			
		}
		model.addAttribute("HangSX", Lhangsx);int sl;
		List<TinTucEntity> Ltt = new ArrayList<TinTucEntity>();
		for(TinTucEntity tt : blogservice.searchPost(pageNumber)) {
			Ltt.add(tt);
			
			sl = blogservice.soCM(tt.getId());
			model.addAttribute("Lcomment", blogservice.soCM(tt.getId()));
			for(NguoiDungEntity ng : nguoidungRepository.findAll()) 
				if(ng.getId().toString().equals(tt.getCreatedby())) {
					model.addAttribute("NguoiTao", ng.getTenND());
					break;
				}
					
			
		}
		
//		HANGSX
		List<HangSXEntity> hangs = new ArrayList<HangSXEntity>();
		for (HangSXEntity Hang : hangsx.findAll()) {
			Lhangsx.add(Hang);
			
		}
		model.addAttribute("HangSX", hangs);
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("ListTinTuc", Ltt);
// 		THELOAI
		List<TheLoaiEntity> LtheLoai = new ArrayList<TheLoaiEntity>();
		for (TheLoaiEntity loai : theloai.findAll()) {
			LtheLoai.add(loai);
		}
		model.addAttribute("TheLoai", LtheLoai);
		
		
	
		
		
		
		return "blog";
	}
	@RequestMapping(value = { "/Blog{id}" }, method = RequestMethod.GET)
	public String chtiet(@PathVariable("id") int id  ,final ModelMap model, final HttpServletRequest request) {
		
		
		TinTucEntity tintuc = tintucRepository.getOne(id);		
		model.addAttribute("ChitietTT", tintuc);
		
		List<HangSXEntity> Lhang = hangsx.findAll();
		model.addAttribute("ListHang", Lhang);
		
		List<SanPhamEntity> Lsanpham = homeService.sanPhamMoi();
		model.addAttribute("ListSanPham", Lsanpham);
		int sl=0;
		for(TinTucEntity tt : tintucRepository.findAll()) {
		
			
			sl = blogservice.soCM(tt.getId());
			model.addAttribute("Lcomment", blogservice.soCM(tt.getId()));
			for(NguoiDungEntity ng : nguoidungRepository.findAll()) 
				if(ng.getId().toString().equals(tt.getCreatedby())) {
					model.addAttribute("NguoiTao", ng.getTenND());
					break;
				}
					
			
		}
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
		model.addAttribute("TheLoai", LtheLoai);
		model.addAttribute("HangSX", Lhangsx);
		return "blog-detail";
	}
	
	@RequestMapping(value = { "/blog-detail" }, method = RequestMethod.GET)
public String tituc(final ModelMap model, final HttpServletRequest request) {
//		HANGSX
		List<HangSXEntity> Lhangsx = new ArrayList<HangSXEntity>();
		for (HangSXEntity Hang : hangsx.findAll()) {
			Lhangsx.add(Hang);
			
		}
		model.addAttribute("HangSX", Lhangsx);
// 		THELOAI
		List<TheLoaiEntity> LtheLoai = new ArrayList<TheLoaiEntity>();
		for (TheLoaiEntity loai : theloai.findAll()) {
			LtheLoai.add(loai);
		}
		model.addAttribute("TheLoai", LtheLoai);
		return "blog-detail";
	}
}
