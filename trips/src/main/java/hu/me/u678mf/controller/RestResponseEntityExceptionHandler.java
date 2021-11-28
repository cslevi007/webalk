package hu.me.u678mf.controller;

import org.springframework.cache.Cache.ValueRetrievalException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import hu.me.u678mf.service.exceptions.CannotUpdateNonExistingElementException;
import hu.me.u678mf.service.exceptions.NoSuchTripException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

//	@ExceptionHandler(value = {NoSuchTripException.class, CannotUpdateNonExistingElementException.class})
//	protected ResponseEntity<Object> handleNoSuchId(RuntimeException e, WebRequest request){
//		return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
//		
//	}
	
	@ExceptionHandler(value = { NoSuchTripException.class, CannotUpdateNonExistingElementException.class })
	protected ResponseEntity<Object> handleNoSuchId(RuntimeException e, WebRequest request){
		return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
