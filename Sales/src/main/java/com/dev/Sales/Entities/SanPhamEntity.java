package com.dev.Sales.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sanpham")
public class SanPhamEntity extends BaseEntity{
	
	
	 
	 @Column(name = "tenSP", length = 45, nullable = false)
	 private String tenSP;
	 
	 @Column(name = "gia", nullable = false)
	 private Integer gia;
	 
	 @Lob
	 @Column(name = "moTa", columnDefinition = "text", nullable = true)
	 private String moTa;
	 
	 @Column(name = "luotXem", length = 11, nullable = true)
	 private Integer luotXem;
	 
	 @Column(name = "luotLike", length = 11, nullable = true)
	 private Integer luotLike;
	 
	 @Column(name = "anh1", length = 45, nullable = true)
	 private String anh1;
	 
	 @Column(name = "anh2", length = 45, nullable = true)
	 private String anh2;
	 
	 @Column(name = "anh3", length = 45, nullable = false)
	 private String anh3;
	 
	 @Column(name = "anh4", length = 45, nullable = false)
	 private String anh4;
	 
	 @Column(name = "chatlieu", length = 45, nullable = true)
	 private String chatlieu;

/////////////////////////////
	 //NhaCC
	 @ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "maHang")
		private HangSXEntity hangsx;
	 
	 // TheLoai
	 
	 @ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "maLoai")
		private TheLoaiEntity theloai;
	 
	 //muahang
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "muaHang_sanpham", fetch = FetchType.LAZY)
	 private List<MuaHangEntity> LmuaHang = new ArrayList<>();
	 
	 

	public List<MuaHangEntity> getLmuaHang() {
		return LmuaHang;
	}

	public void setLmuaHang(List<MuaHangEntity> lmuaHang) {
		LmuaHang = lmuaHang;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public Integer getGia() {
		return gia;
	}

	public void setGia(Integer gia) {
		this.gia = gia;
	}


	

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Integer getLuotXem() {
		return luotXem;
	}

	public void setLuotXem(Integer luotXem) {
		this.luotXem = luotXem;
	}

	public Integer getLuotLike() {
		return luotLike;
	}

	public void setLuotLike(Integer luotLike) {
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

	public String getChatlieu() {
		return chatlieu;
	}

	public void setChatlieu(String chatlieu) {
		this.chatlieu = chatlieu;
	}

	public HangSXEntity getHangsx() {
		return hangsx;
	}

	public void setHangsx(HangSXEntity hangsx) {
		this.hangsx = hangsx;
	}

	public TheLoaiEntity getTheloai() {
		return theloai;
	}

	public void setTheloai(TheLoaiEntity theloai) {
		this.theloai = theloai;
	}

	
	 
	 
	 
}
