package com.smarttech.ConnectionBRQ.Controller.Exception;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.smarttech.ConnectionBRQ.Exception.NotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler( NotFoundException.class )
	public ResponseEntity<ApiError> handleNotFoundException(NotFoundException ex) {
		
		ApiError error = new ApiError( HttpStatus.NOT_FOUND.value(), 
					       ex.getMessage(), new Date() );
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler( MaxUploadSizeExceededException.class )
	public ResponseEntity<ApiError> 
		   handleMaxUploadSizeExceededException( MaxUploadSizeExceededException ex ) {
		
		String[] parts = ex.getMessage().split(":");
		String   msg   = parts[parts.length - 1].trim().toUpperCase();
		
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), msg, new Date());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@Override
	protected ResponseEntity<Object> 
			  handleMethodArgumentNotValid( MethodArgumentNotValidException ex,
						        HttpHeaders headers, HttpStatus status, 
						        WebRequest request ) {
		
		List<String> errors = new ArrayList<String>();
		
		ex.getBindingResult().getAllErrors().forEach(error -> {
			errors.add(error.getDefaultMessage());
		});
		
		String defaultMessage = "Invalid field(s)";
		
		ApiErrorList error = new ApiErrorList( HttpStatus.BAD_REQUEST.value(), 
						       defaultMessage, new Date(), errors );
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */
