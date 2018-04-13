package com.paruspringapp.services.models;

public class Response {

	private int statusCode;
	private String message;

	public Response() {

	}

	public Response(final int statusCode, final String message) {
		setStatusCode(statusCode);
		setMessage(message);
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(final int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

}
