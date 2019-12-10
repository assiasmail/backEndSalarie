package com.tsconsult.salarietest.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Mets cette class ds un package à part.
// Ajout une class FunctionalException ou customException, qui hérite de RuntimeException par EX, car pas besoin de monter jusqu'a Exception.

public class SalarieExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({FunctionalException.class})
    protected ResponseEntity<?> exceptionHandler(Exception ex, WebRequest request){
        String bodyResponse = "Internal Server Error";
        System.out.println("Exception : " + ex.getMessage());
        return new ResponseEntity<>(bodyResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        
        
    }

}
