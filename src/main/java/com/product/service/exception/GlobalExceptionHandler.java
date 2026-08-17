package com.product.service.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleProductNotFound(ProductNotFoundException ex) {

		Map<String, String> response = new HashMap<>();
		response.put("message", ex.getMessage());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {

		Map<String, String> response = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> response.put(error.getField(), error.getDefaultMessage()));

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

	}

}
