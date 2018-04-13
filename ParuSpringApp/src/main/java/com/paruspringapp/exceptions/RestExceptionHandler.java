package com.paruspringapp.exceptions;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	private static final Logger LOGGER = Logger.getLogger(RestExceptionHandler.class.getName());

	@Autowired
	private ErrorResponse errorResponse;

	@ExceptionHandler(PersonException.class)
	public ResponseEntity<ErrorResponse> exceptionPersonHandler(Exception ex) {
		errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		if (ex.getMessage().contains("Unable to find")) {
			errorResponse.setMessage("Record does not exist.");
		} else {
			errorResponse.setMessage("The request could not be understood by the server due to malformed syntax.");
		}

		LOGGER.info("Exception occured: " + ex.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}