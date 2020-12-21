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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "giohang")
public class GioHangEntity extends BaseEntity{
	
	 
	 @Column(name = "nguoiNhan" ,length = 45, nullable = false)
	 private String nguoiNhan;
	 
	 @Column(name = "diaChiNhan", length = 45, nullable = false)
	 private String diaChiNhan;
	 
	 @Column(name =  "sdtNhan", length = 11 , nullable = false )
	 private Integer sdtNhan;
	 
	
	 
	 //NguoiDung
	 @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manNguoiDung")
	private NguoiDungEntity nguoidung;
	 
	
	 //ThanhToan
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "maPhuongThucTT")
	 private ThanhToanEntity thanhtoan;
	 
	 //MuaHang
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "muaHang_giohang", fetch = FetchType.LAZY)
	 private List<MuaHangEntity> LmuaHang = new ArrayList<>();
	 
	  
	  

	public List<MuaHangEntity> getLmuaHang() {
		return LmuaHang;
	}

		

	public void setLmuaHang(List<MuaHangEntity> lmuaHang) {
		LmuaHang = lmuaHang;
	}



	public String getNguoiNhan() {
		return nguoiNhan;
	}

	public void setNguoiNhan(String nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
	}

	public String getDiaChiNhan() {
		return diaChiNhan;
	}

	public void setDiaChiNhan(String diaChiNhan) {
		this.diaChiNhan = diaChiNhan;
	}

	public Integer getSdtNhan() {
		return sdtNhan;
	}

	public void setSdtNhan(Integer sdtNhan) {
		this.sdtNhan = sdtNhan;
	}

	

	public NguoiDungEntity getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(NguoiDungEntity nguoidung) {
		this.nguoidung = nguoidung;
	}

	public ThanhToanEntity getThanhtoan() {
		return thanhtoan;
	}

	public void setThanhtoan(ThanhToanEntity thanhtoan) {
		this.thanhtoan = thanhtoan;
	}

	


	
	
	 
	 
	
}
