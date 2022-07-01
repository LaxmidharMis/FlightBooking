package com.flightapp.validation;

public class EmailNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public EmailNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmailNotFound() {

		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}