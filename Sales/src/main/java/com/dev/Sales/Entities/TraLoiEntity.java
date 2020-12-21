package com.dev.Sales.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "traloi")
public class TraLoiEntity  extends BaseEntity{
	
	 @Column(name = "noiDung", length = 45, nullable = true)
	 private String noiDung;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "maBinhLuan")
		private BinhLuanEntity binhluan;

	
	 
	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public BinhLuanEntity getBinhluan_TL() {
		return binhluan;
	}

	public void setBinhluan_TL(BinhLuanEntity binhluan_TL) {
		this.binhluan = binhluan_TL;
	}
	 
	 
}
