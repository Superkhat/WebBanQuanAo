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
import com.dev.Sales.Entities.ThanhToanEntity;
import com.dev.Sales.Entities.TheLoaiEntity;
import com.dev.Sales.Repositories.HangSXRepository;
import com.dev.Sales.Repositories.ThanhToanRepository;
import com.dev.Sales.Repositories.TheLoaiRepository;
import com.dev.Sales.dto.GioHangDto;
@Controller
public class GioHangController {
	@Autowired private ThanhToanRepository thanhtoanRepository;
	@Autowired private HangSXRepository hangsx;
	@Autowired private TheLoaiRepository theloai;
	@RequestMapping(value = { "/GioHang" }, method = RequestMethod.GET)
	public String view(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		List<ThanhToanEntity> Lthanhtoan = new ArrayList<ThanhToanEntity>();
		for(ThanhToanEntity thanhtoan : thanhtoanRepository.findAll())
			Lthanhtoan.add(thanhtoan);
		model.addAttribute("ListThanhToan", Lthanhtoan);
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
			return "shoping-cart";
	}
	
	@RequestMapping(value = { "/XoaSanPham{id}" }, method = RequestMethod.GET)
	public String xoasp(@PathVariable("id") int id  ,final ModelMap model, final HttpServletRequest request) {
			HttpSession session = request.getSession();
			List<GioHangDto> Lgiohang = (List<GioHangDto>) session.getAttribute("LGioHang");
			for(GioHangDto gh : Lgiohang) {
				if(gh.getId()==id) {
					Lgiohang.remove(gh);
					break;
				}
				
			}
			int total=0;
			for(GioHangDto gh : Lgiohang) {
				total+=gh.getGia();
			}
			session.setAttribute("TongTien", total);
			session.setAttribute("LGioHang", Lgiohang);
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
			return "shoping-cart";
	}
}
