package com.dev.Sales.Controller.ADMIN;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.dev.Sales.Entities.HangSXEntity;
import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.PhanQuyenEntity;
import com.dev.Sales.Entities.QuyenEntity;
import com.dev.Sales.Entities.SanPhamEntity;
import com.dev.Sales.Entities.SlideEntity;
import com.dev.Sales.Entities.ThanhToanEntity;
import com.dev.Sales.Entities.TheLoaiEntity;
import com.dev.Sales.Entities.TinTucEntity;
import com.dev.Sales.Repositories.HangSXRepository;
import com.dev.Sales.Repositories.NguoiDungRepository;
import com.dev.Sales.Repositories.QuyenRepository;
import com.dev.Sales.Repositories.ThanhToanRepository;
import com.dev.Sales.Repositories.TheLoaiRepository;
import com.dev.Sales.Services.HangSXService;
import com.dev.Sales.Services.NguoiDungService;
import com.dev.Sales.Services.PhanQuyenService;
import com.dev.Sales.Services.SanPhamService;
import com.dev.Sales.Services.SlideService;
import com.dev.Sales.Services.TinTucService;
import com.dev.Sales.dto.ApiResponse;
import com.dev.Sales.dto.DoiMKdto;





@Controller
public class Add {
	@Autowired private SlideService slideService;
	@Autowired private HangSXService hangservice;
	@Autowired private QuyenRepository quyenRepository;
	@Autowired private PhanQuyenService phanquyenService;
	@Autowired private HangSXRepository hangRepository;
	@Autowired private TheLoaiRepository theloaiRepository;
	@Autowired private SanPhamService sanphamService;
	@Autowired private ThanhToanRepository thanhtoanRepository;
	@Autowired private TinTucService tintucService;
	@Autowired private NguoiDungService nguoidungService;
	@Autowired private NguoiDungRepository nguoidungRepository;
	//////////////HangSX
	@GetMapping(value = { "/Admin/addHangSX" })
	public String adhangsx(@ModelAttribute ("addHangSX") HangSXEntity hangsx ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		return "Admin/add/addHangSX";
	}
	@PostMapping(value = { "/Admin/addHangSX" })
	public String addhang(@ModelAttribute ("addHangSX") HangSXEntity hangsx ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response,
			@RequestParam("anhHangSX") MultipartFile hangImage) throws Exception {
		hangservice.addHangSX(hangsx, hangImage,request);
		return "Admin/add/addHangSX";
	}
	
	
	
	
	////////////////////////SLide
	@GetMapping(value = { "/Admin/addSlide" })
	public String slide(@ModelAttribute ("addSlide") SlideEntity slide ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		return "Admin/add/addSlide";
	}
	@PostMapping(value = { "/Admin/addSlide" })
	public String addslide(@ModelAttribute ("addSlide") SlideEntity slide ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response,
			@RequestParam("anhSlide") MultipartFile slideImage) throws Exception {
		slideService.addSlide(slide, slideImage, request);
		return "Admin/add/addSlide";
	}
	
	
	
	
	/////////////////////Phanquyen
	@GetMapping(value = { "/Admin/addPhanQuyen" })
	public String phanquyen(@ModelAttribute ("phanquyen") PhanQuyenEntity phanquyen ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		List<QuyenEntity> Lquyen = new ArrayList<QuyenEntity>();
		for(QuyenEntity quyen : quyenRepository.findAll())
			Lquyen.add(quyen);
		model.addAttribute("quyens", Lquyen);
		
		
		return "Admin/add/addPhanQuyen";
	}
	@PostMapping(value = { "/Admin/addPhanQuyen" })
	public String addphanquyen(@ModelAttribute ("phanquyen") PhanQuyenEntity phanquyen ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) throws Exception
			 {
		List<QuyenEntity> Lquyen = new ArrayList<QuyenEntity>();
		for(QuyenEntity quyen : quyenRepository.findAll())
			Lquyen.add(quyen);
		phanquyenService.addPhanQuyen(phanquyen, request);
		model.addAttribute("quyens", Lquyen);
		return "Admin/add/addPhanQuyen";
	}
	
	
	
	//////////////////////////// ADD SAN PHAM
	@GetMapping(value = { "/Admin/addSanPham" })
	public String sanpham(@ModelAttribute ("addSanPham") SanPhamEntity sanpham ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		List<HangSXEntity> Lhang = new ArrayList<HangSXEntity>();
		List<TheLoaiEntity> Ltheloai = new ArrayList<TheLoaiEntity>();
		for(HangSXEntity hang : hangRepository.findAll())
			Lhang.add(hang);
		for(TheLoaiEntity theloai : theloaiRepository.findAll())
			Ltheloai.add(theloai);
		
		model.addAttribute("ListHang", Lhang);
		model.addAttribute("ListTheLoai", Ltheloai);
		return "Admin/add/addSP";
	}
	@PostMapping(value = { "/Admin/addSanPham" })
	public String addsp(@ModelAttribute ("addSanPham") SanPhamEntity sanpham  ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response,
			@RequestParam("image1") MultipartFile anh1,
			@RequestParam("image2") MultipartFile anh2,
			@RequestParam("image3") MultipartFile anh3,
			@RequestParam("image4") MultipartFile anh4) throws Exception
			 {
		System.out.println(anh1.getOriginalFilename());
		sanphamService.addSP(sanpham, anh1, anh2, anh3, anh4, request);
		List<HangSXEntity> Lhang = new ArrayList<HangSXEntity>();
		List<TheLoaiEntity> Ltheloai = new ArrayList<TheLoaiEntity>();
		for(HangSXEntity hang : hangRepository.findAll())
			Lhang.add(hang);
		for(TheLoaiEntity theloai : theloaiRepository.findAll())
			Ltheloai.add(theloai);
		
		model.addAttribute("ListHang", Lhang);
		model.addAttribute("ListTheLoai", Ltheloai);
		return "Admin/add/addSP";
	}
	
	//////////////////THANH TOAN
	@GetMapping(value = { "/Admin/addThanhToan" })
	public String thanhtoan(@ModelAttribute ("addTT") ThanhToanEntity thanhtoan ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		return "Admin/add/addThanhToan";
	}
	@PostMapping(value = { "/Admin/addThanhToan" })
	public String addthanhtoan(@ModelAttribute ("addTT") ThanhToanEntity thanhtoan ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) throws Exception
			 {
		HttpSession session = request.getSession();
		NguoiDungEntity nguoidung = (NguoiDungEntity)session.getAttribute("ThongTinCaNhan");
		ThanhToanEntity tt = new ThanhToanEntity();
		tt.setCreatedby(nguoidung.getId().toString());
		tt.setCreatedDate(new Date());
		tt.setMoTa(thanhtoan.getMoTa());
		tt.setStatus(thanhtoan.getStatus());
		tt.setTenTT(thanhtoan.getTenTT());
		thanhtoanRepository.save(tt);
		return "Admin/add/addThanhToan";
	}
	
	//////////////////////////THE LOAI
	@GetMapping(value = { "/Admin/addTheLoai" })
	public String theloai(@ModelAttribute ("addTheLoai") TheLoaiEntity theloai ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		return "Admin/add/addTheLoai";
	}
	@PostMapping(value = { "/Admin/addTheLoai" })
	public String addTheLoai(@ModelAttribute ("addTheLoai") TheLoaiEntity theloai  ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) throws Exception
			 {
		HttpSession session = request.getSession();
		NguoiDungEntity nguoidung = (NguoiDungEntity)session.getAttribute("ThongTinCaNhan");
		TheLoaiEntity tl = new TheLoaiEntity();
		tl.setCreatedby(nguoidung.getId().toString());
		tl.setCreatedDate(new Date());
		tl.setMota(theloai.getMota());
		tl.setStatus(theloai.getStatus());
		tl.setTenTheLoai(theloai.getTenTheLoai());
		theloaiRepository.save(tl);
		return "Admin/add/addTheLoai";
	}
	
	/////////////////////////TIN TUC
	@GetMapping(value = { "/Admin/addTinTuc" })
	public String tintuc(@ModelAttribute ("addTT") TinTucEntity tintuc ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		return "Admin/add/addTinTuc";
	}
	@PostMapping(value = { "/Admin/addTinTuc" })
	public String addtintuc(@ModelAttribute ("addTT") TinTucEntity tintuc,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response,
			@RequestParam("imageTT") MultipartFile imageTT) throws Exception {
		tintucService.addTT(tintuc, imageTT, request);
		return "Admin/add/addTinTuc";
	}
	////////////////////////NGUOI DUNG
	@GetMapping(value = { "/Admin/addNguoiDung" })
	public String nd(@ModelAttribute ("addND") NguoiDungEntity nguoidung ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		return "Admin/add/addNguoiDung";
	}
	@PostMapping(value = { "/Admin/addNguoiDung" })
	public String addnd(@ModelAttribute ("addND") NguoiDungEntity nguoidung,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response,
			@RequestParam("anhND") MultipartFile imageND) throws Exception {
		nguoidungService.addND(nguoidung, imageND, request);
		return "Admin/add/addNguoiDung";
	}	
	
	
}
