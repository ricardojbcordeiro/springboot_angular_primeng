package br.com.teste.api.utils;

import java.io.Serializable;

public class CustomErrorType implements Serializable {

	private static final long serialVersionUID = 1L;

	private int status;
	
	private String message;

	public CustomErrorType(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}