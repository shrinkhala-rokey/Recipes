package com.recipes.exceptions;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(Exception.class)
	public String GlobalExceptionMethod(Exception ex) {
		return ex.getMessage();
	}
	
/*	public ResponseEntity<ResponseInfo> globalhandler(Exception ex,HttpServletRequest req){
		ResponseInfo ri = new ResponseInfo();
		ri.setUri(req.getRequestURI());
		ri.setStatusName(HttpStatus.NOT_FOUND);
		ri.setStatusCode(HttpStatus.NOT_FOUND.value());
		ri.setMessage(ex.getMessage());
		return new ResponseEntity<>(ri,HttpStatus.NOT_FOUND);
		
	}
	*/
}
