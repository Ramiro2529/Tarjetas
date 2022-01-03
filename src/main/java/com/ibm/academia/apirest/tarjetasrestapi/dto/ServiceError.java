package com.ibm.academia.apirest.tarjetasrestapi.dto;

import org.springframework.validation.FieldError;

public class ServiceError {
	private String message;
	private String field;
	private String invalidValue;
	
	
	public ServiceError(FieldError error) {
		this.message = error.getDefaultMessage();
		this.field = error.getField();
		this.invalidValue = error.getRejectedValue().toString();
	}


	
}
