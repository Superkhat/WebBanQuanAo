package com.dev.Sales.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dev.Sales.Entities.HangSXEntity;
import com.dev.Sales.Entities.TheLoaiEntity;
import com.dev.Sales.Repositories.HangSXRepository;
import com.dev.Sales.Repositories.TheLoaiRepository;

@Controller
public class ContactController {
	@Autowired private HangSXRepository hangsx;
	@Autowired private TheLoaiRepository theloaiRe;
	@RequestMapping(value = { "/LienHe" }, method = RequestMethod.GET)
	public String view(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
		
//		HANGSX
		List<HangSXEntity> Lhangsx = new ArrayList<HangSXEntity>();
		for (HangSXEntity Hang : hangsx.findAll()) {
			Lhangsx.add(Hang);
			
		}
// 		THELOAI
		List<TheLoaiEntity> LtheLoai = new ArrayList<TheLoaiEntity>();
		for (TheLoaiEntity loai : theloaiRe.findAll()) {
			LtheLoai.add(loai);
		}
		model.addAttribute("TheLoai", LtheLoai);
		model.addAttribute("HangSX", Lhangsx);
		return "contact";
	}
}
