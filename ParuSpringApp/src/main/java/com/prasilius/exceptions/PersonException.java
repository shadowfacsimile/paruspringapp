package com.prasilius.exceptions;

public class PersonException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public PersonException() {
		super();
	}

	public PersonException(final String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
