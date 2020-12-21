package com.dev.Sales.Controller.ADMIN;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.dev.Sales.Entities.BinhLuanEntity;
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
import com.dev.Sales.Repositories.MuaHangRepository;
import com.dev.Sales.Repositories.NguoiDungRepository;
import com.dev.Sales.Repositories.QuyenRepository;
import com.dev.Sales.Repositories.SanPhamRepository;
import com.dev.Sales.Repositories.SlideRepository;
import com.dev.Sales.Repositories.ThanhToanRepository;
import com.dev.Sales.Repositories.TheLoaiRepository;
import com.dev.Sales.Repositories.TinTucRepository;
import com.dev.Sales.Repositories.TraLoiRepository;

@Controller
public class Xoa {
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
	
	@GetMapping(value = { "/Admin/XoaBL{id}" })
	public String adhangsx(@PathVariable("id") int id ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		for(BinhLuanEntity bl : binhluanRepository.findAll())
			if(bl.getId()==id)
				binhluanRepository.delete(bl);
		
		List<BinhLuanEntity> Lbl = binhluanRepository.findAll();
		model.addAttribute("ListBinhLuan", Lbl);
		return "Admin/BinhLuan";
	}
	
	///////////////////////////////
	@GetMapping(value = { "/Admin/XoaHang{id}" })
	public String xoahang(@PathVariable("id") int id ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		int check=0;
		for(SanPhamEntity sp : sanphamRepository.findAll())
			if(sp.getHangsx().getId()==id) {
				check=1;
				break;
			}
		if(check==0)
		for(HangSXEntity hangsx : hangRepository.findAll())
			if(hangsx.getId()==id) {
				hangRepository.delete(hangsx);
				break;
			}
				
		
		List<HangSXEntity> Lhang = hangRepository.findAll();
		model.addAttribute("ListHang", Lhang);
		return "Admin/HangSX";
	}
	
	///////////////////////
	
	
	@GetMapping(value = { "/Admin/XoaMuaHang{id}" })
	public String xoamuahang(@PathVariable("id") int id ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		for(MuaHangEntity muahang : muahangRepository.findAll())
			if(muahang.getId()==id) {
				muahangRepository.delete(muahang);
				break;
			}
				
		
		List<MuaHangEntity> Lmuahang = muahangRepository.findAll();
		model.addAttribute("ListMuaHang", Lmuahang);
		return "Admin/MuaHang";
	}
	//////////////////////////
	@GetMapping(value = { "/Admin/XoaNguoiDung{id}" })
	public String xoand(@PathVariable("id") int id ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		for(NguoiDungEntity nguoidung : nguoidungRepositoty.findAll())
			if(nguoidung.getId()==id) {
				nguoidungRepositoty.delete(nguoidung);
				break;
			}
				
		
		List<NguoiDungEntity> Lnguoidung = nguoidungRepositoty.findAll();
		model.addAttribute("ListNguoiDung", Lnguoidung);
		return "Admin/NguoiDung";
	}
	
	///////////////////////////
	
	
	@GetMapping(value = { "/Admin/XoaQuyen{id}" })
	public String xoaquyen(@PathVariable("id") int id ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		int check = 0;
		for(QuyenEntity quyen : quyenRePository.findAll()) {
			
			List<PhanQuyenEntity> Lphanquyen = quyen.getLphanQuyen();
			for(PhanQuyenEntity pq : Lphanquyen)
				if(pq.getQuyen_phanQuyen().getId()==id) {
					check =1;
					break;
				}
			if(check ==1) break;		
		}
		if(check==0)	
		for(QuyenEntity quyens : quyenRePository.findAll())
			if(quyens.getId()==id) {
				quyenRePository.delete(quyens);
				break;
			}
				
		
		List<QuyenEntity> Lquyen = quyenRePository.findAll();
		model.addAttribute("ListQuyen", Lquyen);
		return "Admin/Quyen";
	}
	
	///////////////////////////////
	
	@GetMapping(value = { "/Admin/XoaSanPham{id}" })
	public String xoasp(@PathVariable("id") int id ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		for(SanPhamEntity sanpham : sanphamRepository.findAll())
			if(sanpham.getId()==id) {
				sanphamRepository.delete(sanpham);
				break;
			}
				
		
		List<SanPhamEntity> Lsp = sanphamRepository.findAll();
		model.addAttribute("ListSanPham", Lsp);
		return "Admin/SanPham";
	}
	///////////////////////////////////////////
	@GetMapping(value = { "/Admin/XoaSlide{id}" })
	public String xoaslide(@PathVariable("id") int id ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		for(SlideEntity slide : slideRepository.findAll())
			if(slide.getId()==id) {
				slideRepository.delete(slide);
				break;
			}
				
		
		List<SlideEntity> Lslide = slideRepository.findAll();
		model.addAttribute("ListSlide", Lslide);
		return "Admin/Slide";
	}
	
	//////////////////////////////////////////
	@GetMapping(value = { "/Admin/XoaThanhToan{id}" })
	public String xoathanhtoan(@PathVariable("id") int id ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		for(ThanhToanEntity thanhtoan : thanhtoanRepository.findAll())
			if(thanhtoan.getId()==id) {
				thanhtoanRepository.delete(thanhtoan);
				break;
			}
				
		
		List<ThanhToanEntity> Lthanhtoan = thanhtoanRepository.findAll();
		model.addAttribute("ListThanhToan", Lthanhtoan);
		return "Admin/ThanhToan";
	}
	
	/////////////////////////////////////
	@GetMapping(value = { "/Admin/XoaTheLoai{id}" })
	public String xoatheloai(@PathVariable("id") int id ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		for(TheLoaiEntity theloai : theloaiRepository.findAll())
			if(theloai.getId()==id) {
				theloaiRepository.delete(theloai);
				break;
			}
				
		
		List<TheLoaiEntity> Ltheloai = theloaiRepository.findAll();
		model.addAttribute("ListTheLoai", Ltheloai);
		return "Admin/TheLoai";
	}
	//////////////////////////////
	@GetMapping(value = { "/Admin/XoaTinTuc{id}" })
	public String xoatintuc(@PathVariable("id") int id ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		for(TinTucEntity tintuc : tintucRepository.findAll())
			if(tintuc.getId()==id) {
				tintucRepository.delete(tintuc);
				break;
			}
				
		
		List<TinTucEntity> Ltintuc = tintucRepository.findAll();
		model.addAttribute("ListTinTuc", Ltintuc);
		return "Admin/TinTuc";
	}
	////////////////////////////////
	@GetMapping(value = { "/Admin/XoaTraLoi{id}" })
	public String xoatraloi(@PathVariable("id") int id ,final ModelMap model,
			final HttpServletRequest request, final HttpServletResponse response) {
		
		for(TraLoiEntity traloi : traloiRepository.findAll())
			if(traloi.getId()==id) {
				traloiRepository.delete(traloi);
				break;
			}
				
		
		List<TraLoiEntity> Ltraloi = traloiRepository.findAll();
		model.addAttribute("ListTraLoi", Ltraloi);
		return "Admin/TraLoi";
	}
}
