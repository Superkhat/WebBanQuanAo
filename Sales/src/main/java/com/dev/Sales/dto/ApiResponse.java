package com.dev.Sales.dto;


import java.io.Serializable;

public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 6127029261239696320L;

	// https://en.wikipedia.org/wiki/List_of_HTTP_status_codes#4xx_Client_errors
	private int statusCode; // 200: successful, 500: error.

	// Dữ liệu trả về từ phía back-end.
	private Object data;

	public ApiResponse(int statusCode, Object data) {
		super();
		this.statusCode = statusCode;
		this.data = data;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
