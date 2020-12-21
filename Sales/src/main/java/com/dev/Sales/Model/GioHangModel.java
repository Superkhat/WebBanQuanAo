package com.dev.Sales.Model;

import java.time.LocalDateTime;
import java.util.Date;

public class GioHangModel {
	private int id;
	private int manNguoiDung;
	private String nguoiNhan;
	private String diaChiNhan;
	private int sdtNhan;
	private int maPhuongThucTT;
	private boolean status;
	private int createdby;
	private LocalDateTime createdDate;
	private int modifiedBy;
	private LocalDateTime modifiedDate;
	public GioHangModel(int id, int manNguoiDung, String nguoiNhan, String diaChiNhan, int sdtNhan, int maPhuongThucTT,
			boolean status, int createdby, LocalDateTime createdDate, int modifiedBy, LocalDateTime modifiedDate) {
		super();
		this.id = id;
		this.manNguoiDung = manNguoiDung;
		this.nguoiNhan = nguoiNhan;
		this.diaChiNhan = diaChiNhan;
		this.sdtNhan = sdtNhan;
		this.maPhuongThucTT = maPhuongThucTT;
		this.status = status;
		this.createdby = createdby;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getManNguoiDung() {
		return manNguoiDung;
	}
	public void setManNguoiDung(int manNguoiDung) {
		this.manNguoiDung = manNguoiDung;
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
	public int getSdtNhan() {
		return sdtNhan;
	}
	public void setSdtNhan(int sdtNhan) {
		this.sdtNhan = sdtNhan;
	}
	public int getMaPhuongThucTT() {
		return maPhuongThucTT;
	}
	public void setMaPhuongThucTT(int maPhuongThucTT) {
		this.maPhuongThucTT = maPhuongThucTT;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCreatedby() {
		return createdby;
	}
	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	
	
	
}
