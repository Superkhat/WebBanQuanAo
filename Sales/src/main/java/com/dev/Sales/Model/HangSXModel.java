package com.dev.Sales.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class HangSXModel {
	private int id;
	private String tenHang;
	private int sdt;
	private String email;
	private String diaChi;
	private String moTa;
	private LocalDateTime createdDate;
	private int createdBy;
	private Date modifiedDate;
	private int modifiedBy;
	private boolean status;
	private String anh;
	public HangSXModel(int id, String tenHang, int sdt, String email, String diaChi, String moTa,
			LocalDateTime createdDate, int createdBy, Date modifiedDate, int modifiedBy, boolean status, String anh) {
		super();
		this.id = id;
		this.tenHang = tenHang;
		this.sdt = sdt;
		this.email = email;
		this.diaChi = diaChi;
		this.moTa = moTa;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.status = status;
		this.anh = anh;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenHang() {
		return tenHang;
	}
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
	
}
