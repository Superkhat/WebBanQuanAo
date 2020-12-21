package com.dev.Sales.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nguoidung")
public class NguoiDungEntity extends BaseEntity{
	 
	 @Column(name = "tenND", length = 45, nullable = false)
	 private String tenND;
	 
	 @Column(name = "diaChi", length = 45, nullable = true)
	 private String diaChi;
	 
	 @Column(name = "sdt", length = 11, nullable = true)
	 private Integer sdt;
	 
	 @Column(name = "email", length = 45, nullable = true)
	 private String email;
	 
	 @Column(name = "anh", length = 45, nullable = true)
	 private String anh;
	 
	 @Column(name = "userName", length = 45, nullable = false)
	 private String userName;
	 
	 @Column(name = "passWord", length = 45, nullable = false)
	 private String passWord;
/////////////////////////
	 //GioHang
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung", fetch = FetchType.LAZY)
	 private List<GioHangEntity> giohangs = new ArrayList<GioHangEntity>();
	
	 public void  add(GioHangEntity giohang) {
		 giohangs.add(giohang);
	 }
	 public void  delete(GioHangEntity giohang) {
		 giohangs.remove(giohang);
	 }
	 //BinhLuan
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung_BL", fetch = FetchType.LAZY)
	 private List<BinhLuanEntity> Lbinhluan = new ArrayList<BinhLuanEntity>();
	 
	 public void  NDAddBinhLuan(BinhLuanEntity binhluan) {
		 Lbinhluan.add(binhluan);
	 }
	 public void  NDdeleteBinhLuan(BinhLuanEntity binhluan) {
		 Lbinhluan.remove(binhluan);
	 }
	 
	 //quuen
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoidung_phanQuyen", fetch = FetchType.EAGER)
	 private List<PhanQuyenEntity> LphanQuyen = new ArrayList<>();
	 
	 
public List<PhanQuyenEntity> getLphanQuyen() {
		return LphanQuyen;
	}
	public void setLphanQuyen(List<PhanQuyenEntity> lphanQuyen) {
		LphanQuyen = lphanQuyen;
	}
public List<GioHangEntity> getGiohangs() {
		return giohangs;
	}
	public void setGiohangs(List<GioHangEntity> giohangs) {
		this.giohangs = giohangs;
	}
	/////////////////////////////////
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
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public List<BinhLuanEntity> getLbinhluan() {
		return Lbinhluan;
	}
	public void setLbinhluan(List<BinhLuanEntity> lbinhluan) {
		Lbinhluan = lbinhluan;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	
	
}
