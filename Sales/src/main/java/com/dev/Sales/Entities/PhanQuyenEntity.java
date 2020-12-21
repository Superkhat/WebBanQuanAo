package com.dev.Sales.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phanquyen")
public class PhanQuyenEntity  implements Serializable{


	///Quyen
	@Id
	 @ManyToOne(fetch = FetchType.EAGER,optional=false)
	 @JoinColumn(name = "maQuyen")
	 private QuyenEntity quyen_phanQuyen;
	 ///NguoiDUng
	@Id
	 @ManyToOne(fetch = FetchType.EAGER,optional=false)
	 @JoinColumn(name = "maNguoiDung")
	 private NguoiDungEntity nguoidung_phanQuyen;
	
	
	 @Column(name = "status", length = 4, nullable = false)
	 private Byte status;
	 
	 @Column(name = "createdby", length = 45, nullable = false)
	 private String createdby;
	 
	 @Column(name = "createdDate",  nullable = true)
	 private LocalDateTime createdDate;
	 
	 @Column(name = "modifiedBy", length = 45, nullable = true)
	 private String modifiedBy;
	 
	 @Column(name = "modifiedDate",  nullable = true)
	 private LocalDateTime modifiedDate;
	 
	 
	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public QuyenEntity getQuyen_phanQuyen() {
		return quyen_phanQuyen;
	}

	public void setQuyen_phanQuyen(QuyenEntity quyen_phanQuyen) {
		this.quyen_phanQuyen = quyen_phanQuyen;
	}

	public NguoiDungEntity getNguoidung_phanQuyen() {
		return nguoidung_phanQuyen;
	}

	public void setNguoidung_phanQuyen(NguoiDungEntity nguoidung_phanQuyen) {
		this.nguoidung_phanQuyen = nguoidung_phanQuyen;
	}

	
	


}
