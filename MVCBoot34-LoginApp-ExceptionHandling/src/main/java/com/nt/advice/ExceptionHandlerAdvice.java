package com.nt.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	
	@ExceptionHandler(Exception.class)
	public  ModelAndView  globalExceptionHandler(Exception ex) {
		System.out.println("ExceptionHandlerAdvice.globalExceptionHandler()");
		return new ModelAndView("global_error","problem",ex.getMessage());
		
	}

}
