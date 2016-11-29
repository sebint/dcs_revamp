package com.humworks.dcs.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.humworks.dcs.entities.SpringUser;

@ControllerAdvice(annotations = Controller.class)
public class GlobalControllerAdvice {
	
//	private Authentication authentication;
//	private SpringUser currentUser;
	
	public GlobalControllerAdvice(){
//		this.authentication = SecurityContextHolder.getContext().getAuthentication();
//		this.currentUser = (SpringUser) authentication.getPrincipal();
	}
}
