package com.dev.Sales.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class SanPhamModel {
	private int id;
	private String tenSP;
	private int gia;
	private int maLoai;
	private int maHang;
	private String moTa;
	private int luotXem;
	private int luotLike;
	private String anh1;
	private String anh2;
	private String anh3;
	private String anh4;
	private int createdBy;
	private LocalDateTime createdDate;
	private int modifiedBy;
	private Date modifiedDate;
	private boolean status;
	private String chatlieu;
	public SanPhamModel(int id, String tenSP, int gia, int maLoai, int maHang, String moTa, int luotXem, int luotLike,
			String anh1, String anh2, String anh3, String anh4, int createdBy, LocalDateTime createdDate,
			int modifiedBy, Date modifiedDate, boolean status, String chatlieu) {
		super();
		this.id = id;
		this.tenSP = tenSP;
		this.gia = gia;
		this.maLoai = maLoai;
		this.maHang = maHang;
		this.moTa = moTa;
		this.luotXem = luotXem;
		this.luotLike = luotLike;
		this.anh1 = anh1;
		this.anh2 = anh2;
		this.anh3 = anh3;
		this.anh4 = anh4;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.status = status;
		this.chatlieu = chatlieu;
	}
	public int getMaSP() {
		return id;
	}
	public void setMaSP(int maSP) {
		this.id = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}
	public int getMaHang() {
		return maHang;
	}
	public void setMaHang(int maHang) {
		this.maHang = maHang;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getLuotXem() {
		return luotXem;
	}
	public void setLuotXem(int luotXem) {
		this.luotXem = luotXem;
	}
	public int getLuotLike() {
		return luotLike;
	}
	public void setLuotLike(int luotLike) {
		this.luotLike = luotLike;
	}
	public String getAnh1() {
		return anh1;
	}
	public void setAnh1(String anh1) {
		this.anh1 = anh1;
	}
	public String getAnh2() {
		return anh2;
	}
	public void setAnh2(String anh2) {
		this.anh2 = anh2;
	}
	public String getAnh3() {
		return anh3;
	}
	public void setAnh3(String anh3) {
		this.anh3 = anh3;
	}
	public String getAnh4() {
		return anh4;
	}
	public void setAnh4(String anh4) {
		this.anh4 = anh4;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getChatlieu() {
		return chatlieu;
	}
	public void setChatlieu(String chatlieu) {
		this.chatlieu = chatlieu;
	}

	
}
