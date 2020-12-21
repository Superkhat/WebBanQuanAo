
package com.dev.Sales.Controller.ADMIN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dev.Sales.Entities.HangSXEntity;
import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.SlideEntity;
import com.dev.Sales.Repositories.BinhLuanReposotory;
import com.dev.Sales.Repositories.GioHangRepository;
import com.dev.Sales.Repositories.HangSXRepository;
import com.dev.Sales.Repositories.MuaHangRepository;
import com.dev.Sales.Repositories.NguoiDungRepository;
import com.dev.Sales.Repositories.QuyenRepository;
import com.dev.Sales.Repositories.SanPhamRepository;
import com.dev.Sales.Repositories.SlideRepository;
import com.dev.Sales.Repositories.ThanhToanRepository;
import com.dev.Sales.Repositories.TheLoaiRepository;
import com.dev.Sales.Repositories.TinTucRepository;
import com.dev.Sales.Repositories.TraLoiRepository;
import com.dev.Sales.Services.HangSXService;
import com.dev.Sales.Services.NguoiDungService;
import com.dev.Sales.Services.PhanQuyenService;
import com.dev.Sales.Services.SanPhamService;
import com.dev.Sales.Services.SlideService;
import com.dev.Sales.Services.TinTucService;

@Controller
public class update {
	@Autowired private BinhLuanReposotory binhluanRepository;
	@Autowired private HangSXRepository hangRepository;
	@Autowired private GioHangRepository giohangRepository;
	@Autowired private NguoiDungRepository nguoidungRepositoty;
	@Autowired private SanPhamRepository sanphamRepository;
	@Autowired private QuyenRepository quyenRePository;
	@Autowired private SlideRepository slideRepository;
	@Autowired private ThanhToanRepository thanhtoanRepository;
	@Autowired private TheLoaiRepository theloaiRepository;
	@Autowired private  TinTucRepository tintucRepository;
	@Autowired private MuaHangRepository muahangRepository;
	@Autowired private TraLoiRepository traloiRepository;
	@Autowired private SlideService slideService;
	@Autowired private HangSXService hangservice;
	@Autowired private QuyenRepository quyenRepository;
	@Autowired private PhanQuyenService phanquyenService;
	

	@Autowired private SanPhamService sanphamService;
	
	@Autowired private TinTucService tintucService;
	@Autowired private NguoiDungService nguoidungService;
	@Autowired private NguoiDungRepository nguoidungRepository;
	
	

	@GetMapping(value = { "/Admin/UpdateHang{id}" })
	public String adhangsx(@PathVariable("id") int id,@ModelAttribute ("updateHang") HangSXEntity hangsx ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		for(HangSXEntity hang : hangRepository.findAll() )
			if(hang.getId()==id) {
				model.addAttribute("HangSX", hang);
				break;
			}
		return "Admin/update/updateHangSX";
	}
	@PostMapping(value = { "/Admin/UpdateHang{id}" })
	public String addhang(@PathVariable("id") int id, @ModelAttribute ("updateHang") HangSXEntity hangsx ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response,
			@RequestParam("anhHangSX") MultipartFile hangImage) throws Exception {
		for(HangSXEntity hang : hangRepository.findAll() )
			if(hang.getId()==id) {
					hangservice.updateHang(hangsx, hangImage, request, id);
					break;
			}
	
		return "Admin/update/updateHangSX";
	}
	
	///////////////////////////
	
	
	@GetMapping(value = { "/Admin/updateSlide{id}" })
	public String updateslide(@PathVariable("id") int id,@ModelAttribute ("updateSlide") SlideEntity slidee ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		for( SlideEntity slide : slideRepository.findAll() )
			if(slide.getId()==id) {
				model.addAttribute("Slide", slide);
				break;
			}
		return "Admin/update/updateSlide";
	}
	@PostMapping(value = { "/Admin/updateSlide{id}" })
	public String udslide(@PathVariable("id") int id, @ModelAttribute ("updateSlide") SlideEntity slidee ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response,
			@RequestParam("anhSlide") MultipartFile slideimage) throws Exception {
		for(SlideEntity slide : slideRepository.findAll() )
			if(slide.getId()==id) {
					slideService.updateSlide(slidee, slideimage, request, id);
					break;
			}
	
		return "Admin/update/updateSlide";
	}
	///////////////////////////////////////////
	
	
	@PostMapping(value = { "/Admin/ThongTinCaNhan" })
	public String updateTT(@ModelAttribute("thongtin") NguoiDungEntity nguoidung, final ModelMap model, final HttpServletRequest request,
			@RequestParam("anhND") MultipartFile anh) throws Exception {
		HttpSession session = request.getSession();
		NguoiDungEntity nd = (NguoiDungEntity) session.getAttribute("ThongTinCaNhan");
		
		nguoidungService.udND(nguoidung, anh, request, nd.getId());
		return "Admin/ThongTinCaNhan";
	}
	
}
