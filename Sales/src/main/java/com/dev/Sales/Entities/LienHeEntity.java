package com.dev.Sales.Entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lienhe")
public class LienHeEntity extends BaseEntity {
	
	@Column(name = "diaChi",length = 45, nullable = true)
	private String diaChi;
	
	@Column(name = "sdt",length = 11, nullable = true)
	private Integer sdt;
	
	@Column(name = "email",length = 45, nullable = true)
	private String email;
	
	
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

	
	 
	 
	
}
