package com.dev.Sales.dto;

public class GioHangDto {
 private int idSP;
 private int gia;
 private String tenSP;
 private String anh;
 private int soLuong;
 private String size;
public int getId() {
	return idSP;
}
public void setId(int id) {
	this.idSP = id;
}
public String getTenSP() {
	return tenSP;
}
public void setTenSP(String tenSP) {
	this.tenSP = tenSP;
}
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
public String getAnh() {
	return anh;
}
public void setAnh(String anh) {
	this.anh = anh;
}
public int getGia() {
	return gia;
}
public void setGia(int gia) {
	this.gia = gia;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
 
}
