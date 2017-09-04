package com.humworks.dcs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.humworks.dcs.service.LoginAttemptService;

@Component
public class AuthenticationFailureListener{

	@Autowired
	private LoginAttemptService loginAttemptService;
	
	@EventListener
	public void onAuthenticationFailureEvent(AuthenticationFailureBadCredentialsEvent e) {
		Authentication auth = e.getAuthentication();
		WebAuthenticationDetails details = (WebAuthenticationDetails) auth.getDetails();
		loginAttemptService.saveOrUpdate(auth.getName(), details.getRemoteAddress());
	}

}
