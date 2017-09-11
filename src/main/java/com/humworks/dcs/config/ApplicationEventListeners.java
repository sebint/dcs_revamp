package com.humworks.dcs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.humworks.dcs.entities.User;
import com.humworks.dcs.service.LoginAttemptService;
import com.humworks.dcs.service.UserService;

@Component
public class ApplicationEventListeners{

	@Autowired
	private LoginAttemptService loginAttemptService;
	
	@Autowired
	private UserService userService;
	
	@EventListener
	public void onAuthenticationFailureEvent(AuthenticationFailureBadCredentialsEvent e) {
		String error;		
		Authentication auth = e.getAuthentication();
		WebAuthenticationDetails details = (WebAuthenticationDetails) auth.getDetails();
		loginAttemptService.saveOrUpdate(auth.getName(), details.getRemoteAddress());
		User user = userService.findByUsername(auth.getName());
		if(user != null) {
			if(user.getBoolLockPwd().equals(1)) {
				Integer attempts = user.getIntPwdAttempt()-loginAttemptService.countAttempts(auth.getName());
				if(attempts <= 0) {
					if(loginAttemptService.updateStatus("isAccountNonLocked", 0, user.getIntUserId())>0){
						throw new LockedException("Account locked due to too many recent failed login attempts.");
					}else{
						throw new LockedException("Account locked due to too many recent failed login attempts.");
					}
				}else {
					error = "Invalid Credentials."+attempts+" attempts remaining!.";
				}
			}else {
				error = "Invalid Credentials.";
			}
		}else {			
			error = "Invalid Credentials.";
		}				
		throw new BadCredentialsException(error);
	}
	
	//@EventListener
	public void onContextRefreshedEvent(ContextRefreshedEvent e) {
		//logic at start up;
		//after all bean has been initialized.
	}

}
