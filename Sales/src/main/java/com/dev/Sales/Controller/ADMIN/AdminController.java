package com.dev.Sales.Controller.ADMIN;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dev.Sales.Entities.BinhLuanEntity;
import com.dev.Sales.Entities.GioHangEntity;
import com.dev.Sales.Entities.HangSXEntity;
import com.dev.Sales.Entities.MuaHangEntity;
import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.PhanQuyenEntity;
import com.dev.Sales.Entities.QuyenEntity;
import com.dev.Sales.Entities.SanPhamEntity;
import com.dev.Sales.Entities.SlideEntity;
import com.dev.Sales.Entities.ThanhToanEntity;
import com.dev.Sales.Entities.TheLoaiEntity;
import com.dev.Sales.Entities.TinTucEntity;
import com.dev.Sales.Entities.TraLoiEntity;
import com.dev.Sales.Repositories.BinhLuanReposotory;
import com.dev.Sales.Repositories.GioHangRepository;
import com.dev.Sales.Repositories.HangSXRepository;
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
import com.dev.Sales.Services.SanPhamService;
import com.dev.Sales.dto.DoiMKdto;

@Controller
public class AdminController {
	@Autowired private HangSXRepository hangRepository;
	@Autowired private GioHangRepository giohangRepository;
	@Autowired private NguoiDungRepository nguoidungRepositoty;
	@Autowired private SanPhamRepository sanphamRepository;
	@Autowired private QuyenRepository quyenRePository;
	@Autowired private SlideRepository slideRepository;
	@Autowired private ThanhToanRepository thanhtoanRepository;
	@Autowired private TheLoaiRepository theloaiRepository;
	@Autowired private  TinTucRepository tintucRepository;
	@Autowired private BinhLuanReposotory binhluanRepository;
	@Autowired private TraLoiRepository traloiRepository;
	@Autowired private HangSXService hangservice;
	@Autowired private NguoiDungService nguoidungservice;
	@Autowired private SanPhamService sanphamservice;
	
	@RequestMapping(value = {  "/Admin/BinhLuan" }, method = RequestMethod.GET)
	public String bl(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<BinhLuanEntity> Lbl = binhluanRepository.findAll();
		model.addAttribute("ListBinhLuan", Lbl);
			
		return "Admin/BinhLuan";
	}
	@RequestMapping(value = {  "/Admin/doiMK" }, method = RequestMethod.GET)
	public String dmk(@ModelAttribute("DoiMK") DoiMKdto doimk, final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		
		return "Admin/doiMK";
	}
	@RequestMapping(value = {  "/Admin/HangSX" }, method = RequestMethod.GET)
	public String hangsx(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<HangSXEntity> Lhang = new ArrayList<HangSXEntity>();
		for(HangSXEntity hang : hangRepository.findAll()) {
			Lhang.add(hang);
		}
		model.addAttribute("ListHang", Lhang);
		return "Admin/HangSX";
	}
	@RequestMapping(value = {  "/Admin/index" }, method = RequestMethod.GET)
	public String indexA(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		model.addAttribute("soTK",nguoidungservice.soTK());
		model.addAttribute("soSP",sanphamservice.soSP());
		model.addAttribute("soHang",hangservice.soHang());
		return "Admin/index";
	}
	@RequestMapping(value = {  "/Admin/MuaHang" }, method = RequestMethod.GET)
	public String muahang(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
	List<MuaHangEntity> Lmuahang = new ArrayList<MuaHangEntity>();	
	
		for(GioHangEntity giohang : giohangRepository.findAll()) {
			for(MuaHangEntity muahang : giohang.getLmuaHang()) {
				Lmuahang.add(muahang);
			
			}
		}
		
		model.addAttribute("ListMuaHang", Lmuahang);
		return "Admin/MuaHang";
	}
	@RequestMapping(value = {  "/Admin/NguoiDung" }, method = RequestMethod.GET)
	public String nguoidung(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<NguoiDungEntity> LNguoidung  = new ArrayList<NguoiDungEntity>();
		for(NguoiDungEntity nguoidung : nguoidungRepositoty.findAll()) {
			LNguoidung.add(nguoidung);
		}
		model.addAttribute("ListNguoiDung", LNguoidung);
		return "Admin/NguoiDung";
	}
	@RequestMapping(value = {  "/Admin/PhanQuyen" }, method = RequestMethod.GET)
	public String phanquyen(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<PhanQuyenEntity> Lphanquyen = new ArrayList<PhanQuyenEntity>();
		for(QuyenEntity quyen : quyenRePository.findAll()) {
			for(PhanQuyenEntity phanquyen : quyen.getLphanQuyen())
				Lphanquyen.add(phanquyen);
		}
		
		model.addAttribute("ListPhanQuyen", Lphanquyen);
		return "Admin/PhanQuyen";
	}
	@RequestMapping(value = {  "/Admin/TTCaNhan" }, method = RequestMethod.GET)
	public String ttcanhan(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		
		return "Admin/profile";
	}
	@RequestMapping(value = {  "/Admin/Quyen" }, method = RequestMethod.GET)
	public String quyen(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<QuyenEntity> Lquyen = new ArrayList<QuyenEntity>();
		for(QuyenEntity quyen : quyenRePository.findAll()) {
			Lquyen.add(quyen);
		}
		model.addAttribute("ListQuyen", Lquyen);
		return "Admin/Quyen";
	}
	@RequestMapping(value = {  "/Admin/SanPham" }, method = RequestMethod.GET)
	public String sanpham(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<SanPhamEntity> Lsanpham = new ArrayList<SanPhamEntity>();
		for(SanPhamEntity sanpham : sanphamRepository.findAll()) {
			Lsanpham.add(sanpham);
			
		}
		
		model.addAttribute("ListSanPham", Lsanpham);
		return "Admin/SanPham";
	}
	@RequestMapping(value = {  "/Admin/Slide" }, method = RequestMethod.GET)
	public String slide(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<SlideEntity> LSlide = new ArrayList<SlideEntity>();
		for(SlideEntity slide : slideRepository.findAll())
			LSlide.add(slide);
		model.addAttribute("ListSlide", LSlide);
		return "Admin/Slide";
	}
	@RequestMapping(value = {  "/Admin/ThanhToan" }, method = RequestMethod.GET)
	public String thanhtoan(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<ThanhToanEntity> Lthanhtoan = new ArrayList<ThanhToanEntity>();
		for(ThanhToanEntity thanhtoan : thanhtoanRepository.findAll())
			Lthanhtoan.add(thanhtoan);
		model.addAttribute("ListThanhToan", Lthanhtoan);
		return "Admin/ThanhToan";
	}
	@RequestMapping(value = {  "/Admin/TheLoai" }, method = RequestMethod.GET)
	public String theloai(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<TheLoaiEntity> LTheLoai = new ArrayList<TheLoaiEntity>();
		for(TheLoaiEntity theloai : theloaiRepository.findAll())
			LTheLoai.add(theloai);
		model.addAttribute("ListTheLoai", LTheLoai);
		return "Admin/TheLoai";
	}
	@RequestMapping(value = {  "/Admin/TinTuc" }, method = RequestMethod.GET)
	public String tintuc(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<TinTucEntity> Ltintuc = new ArrayList<>();
		for(TinTucEntity tintuc : tintucRepository.findAll())
			Ltintuc.add(tintuc);
		model.addAttribute("ListTinTuc", Ltintuc);
		return "Admin/TinTuc";
	}
	@RequestMapping(value = {  "/Admin/TraLoi" }, method = RequestMethod.GET)
	public String traloi(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<TraLoiEntity> Ltraloi = traloiRepository.findAll();
		model.addAttribute("ListTraLoi", Ltraloi);
			
		return "Admin/TraLoi";
	}
	@RequestMapping(value = {  "/Admin/LienHe" }, method = RequestMethod.GET)
	public String lienhe(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		
		return "Admin/LienHe";
	}
	@RequestMapping(value = {  "/Admin/ThongTinCaNhan" }, method = RequestMethod.GET)
	public String tt(@ModelAttribute("thongtin") NguoiDungEntity nguoidung, final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) {
		
		return "Admin/ThongTinCaNhan";
	}
	
}
