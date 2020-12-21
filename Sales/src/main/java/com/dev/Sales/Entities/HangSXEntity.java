package com.dev.Sales.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hangsx")
public class HangSXEntity extends BaseEntity{
	 
	 
	 @Column(name = "tenHang", length = 45, nullable = false)
	 private String tenHang;
	 
	 @Column(name = "sdt", length = 11, nullable = true)
	 private Integer sdt;
	 
	 @Column(name = "email", length = 45, nullable = true)
	 private String email;
	 
	 @Column(name = "diaChi", length = 45, nullable = true)
	 private String diaChi;
	 
	 @Lob
	 @Column(name = "moTa",  nullable = true ,columnDefinition = "text")
	 private String moTa;

	 @Column(name = "anh", length = 45, nullable = false)
	 private String anh;
	 
	 //////////////////////
	 // SanPham
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "hangsx", fetch = FetchType.LAZY)
		private List<SanPhamEntity> LsanPham = new ArrayList<SanPhamEntity>();

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	public Integer getSdt() {
		return sdt;
	}

	public void setSdt(Integer sdt) {
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

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public List<SanPhamEntity> getLsanPham() {
		return LsanPham;
	}

	public void setLsanPham(List<SanPhamEntity> lsanPham) {
		LsanPham = lsanPham;
	}
	 
	 
	 
}