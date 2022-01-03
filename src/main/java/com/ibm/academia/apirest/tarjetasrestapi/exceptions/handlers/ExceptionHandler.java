package com.ibm.academia.apirest.tarjetasrestapi.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.bind.annotation.*;

import com.ibm.academia.apirest.tarjetasrestapi.exceptions.NotFoundException;

@ControllerAdvice
public class ExceptionHandler {
	
	

	@org.springframework.web.bind.annotation.ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Object> notFound(NotFoundException ex) {
		Map<String, Object> response = new HashMap<>();
		response.put("message", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<Object> missingRequestParameters(MissingServletRequestParameterException ex) {
		Map<String, Object> response = new HashMap<>();
		
		response.put("message", "Olvidaste agregar algun parametro a la petición");
		response.put("param", ex.getParameterName());
		response.put("paramType", ex.getParameterType());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> paramTypeMismatch(MethodArgumentTypeMismatchException ex) {
		Map<String, Object> response = new HashMap<>();
		
		response.put("message", "El tipo de dato que enviaste no coincide con el esperado");
		response.put("param", ex.getName());
		response.put("paramTypeExpected", ex.getParameter().getParameterType());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

}
