package com.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrederNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String resourceName;

	public OrederNotFoundException(String resourceName) {
		super();
		this.resourceName = resourceName;
	}
	
	

}
