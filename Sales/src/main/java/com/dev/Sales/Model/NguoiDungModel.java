package com.dev.Sales.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class NguoiDungModel {
	private int id;
	private String tenND;
	private String diaChi;
	private int sdt;
	private String email;
	private String anh;
	private int createdBy;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	private int modifiedBy;
	private boolean status;
	public NguoiDungModel(int id, String tenND, String diaChi, int sdt, String email, String anh, int createdBy,
			LocalDateTime createdDate, LocalDateTime modifiedDate, int modifiedBy, boolean status) {
		super();
		this.id = id;
		this.tenND = tenND;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.email = email;
		this.anh = anh;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenND() {
		return tenND;
	}
	public void setTenND(String tenND) {
		this.tenND = tenND;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
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
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
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
	
	
	
}
