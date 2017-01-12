package com.humworks.dcs.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.entities.SpringUser;
import com.humworks.dcs.service.SessionService;

@Service("sessionService")
@Transactional
public class SessionServiceImpl implements SessionService {

	@Override
	public Integer getActiveUid() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		SpringUser currentUser = (SpringUser) authentication.getPrincipal();
		return currentUser.getUserId();
	}
	
	@Override
	public String getActiveUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		SpringUser currentUser = (SpringUser) authentication.getPrincipal();
		return currentUser.getUsername();
	}
	
}
