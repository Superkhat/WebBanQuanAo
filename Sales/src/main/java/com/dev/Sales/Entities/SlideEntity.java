package com.dev.Sales.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slide")
public class SlideEntity extends BaseEntity{
	 static final long serialVersionUID = 880163957096965869L;
	 
	
	 
	 @Column(name = "tenSlide", length = 45, nullable = true)
	 private String tenSlide;
	 
	 @Column(name = "moTa", length = 45, nullable = true)
	 private String moTa;
	 
	 @Column(name = "anh", length = 45, nullable = true)
	 private String anh;

	public String getTenSlide() {
		return tenSlide;
	}

	public void setTenSlide(String tenSlide) {
		this.tenSlide = tenSlide;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	
}
