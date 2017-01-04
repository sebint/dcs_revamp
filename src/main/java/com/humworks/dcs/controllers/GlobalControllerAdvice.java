package com.humworks.dcs.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.humworks.dcs.exception.InternalServerException;
import com.humworks.dcs.exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ModelAndView resourceNotFoundException(HttpServletRequest request, Exception ex){
		
//		logger.error("Request URL"+ request.getRequestURL());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/404");
		return mav;
	}	
	
	@ExceptionHandler(InternalServerException.class)
	public ModelAndView internalServerException(HttpServletRequest request, Exception ex){
		
//		logger.error("Request URL"+ request.getRequestURL());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/404");
		return mav;
	}

}
