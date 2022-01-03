package com.ibm.academia.apirest.tarjetasrestapi.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;

import com.ibm.academia.apirest.tarjetasrestapi.dto.ServiceError;

public class BadRequestException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ServiceError> errors;
	
	public BadRequestException(String message, List<FieldError> errors) {
		super(message);
		this.errors = errors.stream().map(e -> new ServiceError(e)).collect(Collectors.toList());
	}
	

}
