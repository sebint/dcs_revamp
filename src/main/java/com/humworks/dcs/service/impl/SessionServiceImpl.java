package com.humworks.dcs.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.google.common.base.Strings;
import com.humworks.dcs.entities.SpringUser;
import com.humworks.dcs.service.SessionService;

@Service("sessionService")
public class SessionServiceImpl implements SessionService {
	
	private SpringUser currentUser;
	
/*	public SessionServiceImpl() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			this.currentUser = (SpringUser) authentication.getPrincipal();
		}
		System.out.println("IN");
	}*/

	@Override
	public Long getActiveUid() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		this.currentUser = (SpringUser) authentication.getPrincipal();
		return this.currentUser.getUserId();
	}
	
	@Override
	public String getActiveUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		this.currentUser = (SpringUser) authentication.getPrincipal();
		return this.currentUser.getUsername();
	}

	@Override
	public String getActiveFullName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		this.currentUser = (SpringUser) authentication.getPrincipal();
		return this.currentUser.getFirstName()+Strings.isNullOrEmpty(this.currentUser.getLastName()) != null ? "" : " "+this.currentUser.getLastName();
	}
	
}
