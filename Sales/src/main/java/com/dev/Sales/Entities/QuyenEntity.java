 package com.dev.Sales.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "quyen")
public class QuyenEntity extends BaseEntity{
	
	 @Column(name = "tenQuyen", length = 60, nullable = false)
	 private String tenQuyen;
	 
	 @Column(name = "moTa", length = 45, nullable = true)
	 private String moTa;
	 
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "quyen_phanQuyen", fetch = FetchType.EAGER)
	 private List<PhanQuyenEntity> LphanQuyen = new ArrayList<PhanQuyenEntity>();
	 
//	 @ManyToMany
//	    @JoinTable(name = "phanquyen",
//	        joinColumns = @JoinColumn(name = "maQuyen"),
//	        inverseJoinColumns = @JoinColumn(name = "maNguoiDung"))
//	    private List<NguoiDungEntity> LnguoiDung = new ArrayList<NguoiDungEntity>();

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public List<PhanQuyenEntity> getLphanQuyen() {
		return LphanQuyen;
	}

	public void setLphanQuyen(List<PhanQuyenEntity> lphanQuyen) {
		LphanQuyen = lphanQuyen;
	}

//	public List<NguoiDungEntity> getLnguoiDung() {
//		return LnguoiDung;
//	}
//
//	public void setLnguoiDung(List<NguoiDungEntity> lnguoiDung) {
//		LnguoiDung = lnguoiDung;
//	}
	 
	 
}
