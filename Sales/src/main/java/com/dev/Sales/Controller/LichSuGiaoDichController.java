package com.dev.Sales.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.Sales.Entities.HangSXEntity;
import com.dev.Sales.Entities.MuaHangEntity;
import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.TheLoaiEntity;
import com.dev.Sales.Repositories.HangSXRepository;
import com.dev.Sales.Repositories.MuaHangRepository;
import com.dev.Sales.Repositories.TheLoaiRepository;
import com.dev.Sales.dto.GioHangDto;

@Controller
public class LichSuGiaoDichController {
	@Autowired private MuaHangRepository muahangRepoisitory;
	@Autowired private TheLoaiRepository theloai;
	@Autowired
	private HangSXRepository hangsx;
	@RequestMapping(value = { "/LichSuGiaoDich" }, method = RequestMethod.GET)
	public String lichsu(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		HttpSession session = request.getSession();
		NguoiDungEntity nguoidung = (NguoiDungEntity) session.getAttribute("ThongTinCaNhan");
		
		if(session.getAttribute("ThongTinCaNhan") != null) {
			List<MuaHangEntity> Lmuahang = new ArrayList<MuaHangEntity>();
			for(MuaHangEntity mua : muahangRepoisitory.findAll()) {
				if(mua.getMuaHang_giohang().getCreatedby().equals(nguoidung.getId().toString())) {
					Lmuahang.add(mua);
				
				}
			}
			model.addAttribute("LichSuGiaoDich", Lmuahang);	
//			HANGSX
			List<HangSXEntity> Lhangsx = new ArrayList<HangSXEntity>();
			for (HangSXEntity Hang : hangsx.findAll()) {
				Lhangsx.add(Hang);
				
			}
			model.addAttribute("HangSX", Lhangsx);
//	 		THELOAI
			List<TheLoaiEntity> LtheLoai = new ArrayList<TheLoaiEntity>();
			for (TheLoaiEntity loai : theloai.findAll()) {
				LtheLoai.add(loai);
			}
			model.addAttribute("TheLoai", LtheLoai);
			
		}		
		return "LichSuGiaoDich";
}
	@RequestMapping(value = { "/XoaLichSu{id}" }, method = RequestMethod.GET)
	public String xoasp(@PathVariable("id") int id  ,final ModelMap model, final HttpServletRequest request) {
		HttpSession session = request.getSession();
		NguoiDungEntity nguoidung = (NguoiDungEntity) session.getAttribute("ThongTinCaNhan");
			for(MuaHangEntity muahang : muahangRepoisitory.findAll()) {
				if(muahang.getId()==id)
					muahangRepoisitory.delete(muahang);
			}
			List<GioHangDto> Lgiohang = (List<GioHangDto>) session.getAttribute("LGioHang");
			session.setAttribute("LGioHang", Lgiohang);
			
//	 		THELOAI
			List<TheLoaiEntity> LtheLoai = new ArrayList<TheLoaiEntity>();
			for (TheLoaiEntity loai : theloai.findAll()) {
				LtheLoai.add(loai);
			}
			List<MuaHangEntity> Lmuahang = new ArrayList<MuaHangEntity>();
			for(MuaHangEntity mua : muahangRepoisitory.findAll()) {
				if(mua.getMuaHang_giohang().getCreatedby().equals(nguoidung.getId().toString())) {
					Lmuahang.add(mua);
				
				}
			}
//			HANGSX
			List<HangSXEntity> Lhangsx = new ArrayList<HangSXEntity>();
			for (HangSXEntity Hang : hangsx.findAll()) {
				Lhangsx.add(Hang);
				
			}
			model.addAttribute("HangSX", Lhangsx);
			model.addAttribute("LichSuGiaoDich", Lmuahang);	
			model.addAttribute("TheLoai", LtheLoai);
			return "LichSuGiaoDich";
	}
}
