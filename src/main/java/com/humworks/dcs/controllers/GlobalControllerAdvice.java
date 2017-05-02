package com.humworks.dcs.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.humworks.dcs.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	public String resourceNotFoundException(Model model){		
		model.addAttribute("errorCode", "404");
		model.addAttribute("errorMessage", "Requested page not found!");
//		logger.error("Request URL"+ request.getRequestURL());
		return "error/404";
	}	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String noHandlerFoundException(Model model){
		model.addAttribute("errorCode", "404");
		model.addAttribute("errorMessage", "Oops, an error has occurred. Page not found!");
		return "error/404";
	}

}
