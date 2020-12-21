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
@Table(name = "thanhtoan")
public class ThanhToanEntity extends BaseEntity{
	 @Column(name = "tenTT", length = 45, nullable = false)
	 private String tenTT;
	 
	 @Column(name = "moTa", length = 45, nullable = true)
	 private String moTa;
	 
	 //giohang
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "thanhtoan", fetch = FetchType.LAZY)
		private List<GioHangEntity> posts = new ArrayList<GioHangEntity>();

	public String getTenTT() {
		return tenTT;
	}

	public void setTenTT(String tenTT) {
		this.tenTT = tenTT;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public List<GioHangEntity> getPosts() {
		return posts;
	}

	public void setPosts(List<GioHangEntity> posts) {
		this.posts = posts;
	}
	 
	 
}

