package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(annotations = Controller.class)
public class GlobalControllerAdvice {
	
//	private Authentication authentication;
//	private SpringUser currentUser;
	
	public GlobalControllerAdvice(){
//		this.authentication = SecurityContextHolder.getContext().getAuthentication();
//		this.currentUser = (SpringUser) authentication.getPrincipal();
	}
}
