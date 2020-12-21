package com.dev.Sales.Services;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.RollbackException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dev.Sales.Entities.GioHangEntity;
import com.dev.Sales.Entities.HangSXEntity;
import com.dev.Sales.Entities.MuaHangEntity;
import com.dev.Sales.Entities.NguoiDungEntity;
import com.dev.Sales.Entities.SanPhamEntity;
import com.dev.Sales.Entities.ThanhToanEntity;
import com.dev.Sales.Repositories.GioHangRepository;
import com.dev.Sales.Repositories.HangSXRepository;
import com.dev.Sales.Repositories.MuaHangRepository;
import com.dev.Sales.Repositories.NguoiDungRepository;
import com.dev.Sales.Repositories.SanPhamRepository;
import com.dev.Sales.Repositories.ThanhToanRepository;
import com.dev.Sales.dto.GioHangDto;
import com.dev.Sales.dto.ThongTinGioHang;

@Service
public class MuaHangService {
	@Autowired private SanPhamRepository sanphamRepository;
	@PersistenceContext protected EntityManager entityManager;
	@Autowired private MuaHangRepository muahangRepository;
	@Autowired private NguoiDungRepository nguoidungRepository;
	@Autowired private NguoiDungService nguoidungSerVice;
	@Autowired private ThanhToanRepository thanhtoanRepository;
	@Autowired private GioHangRepository GioHangRepository;
	
	@Transactional(rollbackOn = RollbackException.class)
	public void addMuaHang(ThongTinGioHang thongtin,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		ThanhToanEntity thanhtoan = thanhtoanRepository.getOne(thongtin.getThanhToan());
		List<MuaHangEntity> LmuaHang = new ArrayList<MuaHangEntity>();
		List<GioHangDto> LgioHang = (List<GioHangDto>) session.getAttribute("LGioHang");
		NguoiDungEntity nguoidung = (NguoiDungEntity) session.getAttribute("ThongTinCaNhan");
		GioHangEntity gioHang = new GioHangEntity();
		gioHang.setCreatedby(nguoidung.getId().toString());
		gioHang.setCreatedDate(new Date());
		gioHang.setDiaChiNhan(thongtin.getDiaChiNhan());
		gioHang.setNguoidung(nguoidung);
		gioHang.setThanhtoan(thanhtoan);
		gioHang.setStatus((byte) 1);
		gioHang.setSdtNhan(Integer.parseInt(thongtin.getSdtNhan()));
		gioHang.setNguoiNhan(thongtin.getTenNguoiNhan());
		GioHangRepository.save(gioHang);
	for(GioHangDto gh : LgioHang) {
		
		SanPhamEntity sp = sanphamRepository.getOne(gh.getId());
		MuaHangEntity muahang = new MuaHangEntity();
		muahang.setCreatedby(nguoidung.getId().toString());
		muahang.setCreatedDate(new Date());
		muahang.setSize(gh.getSize());
		muahang.setStatus((byte) 1);
		muahang.setSoLuong(gh.getSoLuong());
		muahang.setMuaHang_sanpham(sp);
		muahang.setMuaHang_giohang(gioHang);
		muahang.setTongTien(gh.getSoLuong()*sp.getGia());
		muahangRepository.save(muahang);
		
		
	}
	
}
}
