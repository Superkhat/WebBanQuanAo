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
@Table(name = "tintuc")
public class TinTucEntity extends BaseEntity{
	 @Column(name = "tenTT", length =45, nullable = true)
	 private String tenTT;
	 
	 @Column(name = "anh", length =45, nullable = true)
	 private String anh;
	 
	 @Column(name = "moTa", length =45, nullable = true)
	 private String moTa;
	 
	 @Lob
	 @Column(name = "noiDung", columnDefinition = "text", nullable = true)
	 private String noiDung;
	 
	 @Column(name = "luotXem", length =11, nullable = true)
	 private Integer luotXem;
	 
	 @Column(name = "luotLike", length =11, nullable = true)
	 private Integer luotLike;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "tintuc", fetch = FetchType.LAZY)
		private List<BinhLuanEntity> LbinhLuan = new ArrayList<BinhLuanEntity>();

	public String getTenTT() {
		return tenTT;
	}

	public void setTenTT(String tenTT) {
		this.tenTT = tenTT;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
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

	public List<BinhLuanEntity> getLbinhLuan() {
		return LbinhLuan;
	}

	public void setLbinhLuan(List<BinhLuanEntity> lbinhLuan) {
		LbinhLuan = lbinhLuan;
	}
	 
	 
}
