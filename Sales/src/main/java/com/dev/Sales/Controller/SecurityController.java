package com.dev.Sales.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Repositories.NguoiDungRepository;
import com.dev.Sales.Services.HangSXService;
import com.dev.Sales.dto.ApiResponse;



	@Controller
	public class SecurityController {
		
		public static NguoiDungEntity nguoidung = null;
		@Autowired private NguoiDungRepository NguoiDungRepository;
		@Autowired private HangSXService hangsxService;
		
		
		@RequestMapping(value = "/Login")
		public String index() {
			return "login"; // view là trang login của mình thiết kế.
		}
		@PostMapping(value = "/api/Login")
		public ResponseEntity<ApiResponse> subscribe(@RequestBody final Map<String,Object> userName,
				final ModelMap model, final HttpServletRequest request, final HttpServletResponse response) {
			 String us =(String)userName.get("username");	
		 nguoidung = hangsxService.searchUserByUserName(us);	
		 HttpSession httpSession = request.getSession();
		 httpSession.setAttribute("ThongTinCaNhan", nguoidung);
	
			return ResponseEntity.ok(new ApiResponse(200, "Example"));
		}
	}


