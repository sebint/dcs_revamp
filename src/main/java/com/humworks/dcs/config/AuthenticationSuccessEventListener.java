package com.humworks.dcs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.humworks.dcs.service.LoginAttemptService;

@Component
public class AuthenticationSuccessEventListener
									implements ApplicationListener<AuthenticationSuccessEvent> {
	@Autowired
    private LoginAttemptService loginAttemptService;

	public void setLoginAttemptService(LoginAttemptService loginAttemptService) {
		this.loginAttemptService = loginAttemptService;
	}

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent e) {
		 WebAuthenticationDetails auth = (WebAuthenticationDetails) 
		          e.getAuthentication().getDetails();
		         
		        loginAttemptService.loginSucceed(auth.getRemoteAddress());
		
	}

}

