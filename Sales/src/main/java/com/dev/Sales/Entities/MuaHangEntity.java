package com.dev.Sales.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "muahang")
public class MuaHangEntity  extends BaseEntity{
	
	
	@Column(name = "soLuong", length = 11, nullable = true)
	private Integer soLuong;
	
	@Column(name = "size", length = 45, nullable = false)
	private String size;

	@Column(name = "tongTien", length = 11, nullable = true)
	private int tongTien;
	
	 
	 
	 //GioHang
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "maGioHang")
	 private GioHangEntity muaHang_giohang;
	 
	 //SanPham
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "maSP")
	 private SanPhamEntity muaHang_sanpham;
	 
	 
	 
	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public SanPhamEntity getMuaHang_sanpham() {
		return muaHang_sanpham;
	}

	public void setMuaHang_sanpham(SanPhamEntity muaHang_sanpham) {
		this.muaHang_sanpham = muaHang_sanpham;
	}


	public GioHangEntity getMuaHang_giohang() {
		return muaHang_giohang;
	}

	public void setMuaHang_giohang(GioHangEntity muaHang_giohang) {
		this.muaHang_giohang = muaHang_giohang;
	}

		public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	
	
	
}
