package com.dev.Sales.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "theloai")
public class TheLoaiEntity extends BaseEntity{
	
	
	 @Column(name = "tenTheLoai", length =45, nullable = false)
	 private String tenTheLoai;
	 
	 @Column(name = "mota", length =45, nullable = true)
	 private String mota;
	 
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "theloai", fetch = FetchType.LAZY)
		private List<SanPhamEntity> LsanPham = new ArrayList<>();

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public List<SanPhamEntity> getLsanPham() {
		return LsanPham;
	}

	public void setLsanPham(List<SanPhamEntity> lsanPham) {
		LsanPham = lsanPham;
	}
	 
	 
}
