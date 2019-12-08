package com.tsconsult.salarietest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class SalarieExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({Exception.class})
    protected ResponseEntity<?> exceptionHandler(Exception ex, WebRequest request){
        String bodyResponse = "Internal Server Error";
        System.out.println("Exception : " + ex.getMessage());
        return new ResponseEntity<>(bodyResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        
        
    }

}
