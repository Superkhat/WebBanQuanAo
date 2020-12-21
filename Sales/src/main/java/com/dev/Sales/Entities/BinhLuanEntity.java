package com.dev.Sales.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "binhluan")
public class BinhLuanEntity extends BaseEntity{
	
	 @ManyToOne(fetch = FetchType.EAGER,optional=false)
	 @JoinColumn(name = "maTinTuc")
	 private TinTucEntity tintuc;
	 
	 @ManyToOne(fetch = FetchType.EAGER,optional=false)
	 @JoinColumn(name = "maNguoiDung")
	 private NguoiDungEntity nguoidung_BL;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "binhluan", fetch = FetchType.LAZY)
	 private List<TraLoiEntity> Ltraloi = new ArrayList<>();
	 
	
	 @Column(name = "noiDung",  nullable = true ,length = 45)
	 private String noiDung;

	public TinTucEntity getTintuc() {
		return tintuc;
	}

	public void setTintuc(TinTucEntity tintuc) {
		this.tintuc = tintuc;
	}

	public NguoiDungEntity getNguoidung_BL() {
		return nguoidung_BL;
	}

	public void setNguoidung_BL(NguoiDungEntity nguoidung_BL) {
		this.nguoidung_BL = nguoidung_BL;
	}

	public List<TraLoiEntity> getLtraloi() {
		return Ltraloi;
	}

	public void setLtraloi(List<TraLoiEntity> ltraloi) {
		Ltraloi = ltraloi;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}


}