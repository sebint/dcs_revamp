package com.humworks.dcs.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthFailureHandler implements AuthenticationFailureHandler {
	
/*    private static final String BAD_CREDENTIALS_MESSAGE = "bad_credentials_message";
    private static final String CREDENTIALS_EXPIRED_MESSAGE = "credentials_expired_message";
    private static final String DISABLED_MESSAGE = "disabled_message";
    private static final String LOCKED_MESSAGE = "locked_message";*/

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);
		
		if (authException instanceof BadCredentialsException) {
			//response.sendRedirect("login");
			
        } else if (authException.getCause() instanceof CredentialsExpiredException) {
        	//response.sendRedirect("login");
        } else if (authException.getCause() instanceof DisabledException) {
        	//response.sendRedirect("reset");
        } else if (authException.getCause() instanceof LockedException) {
        	//response.sendRedirect("login");
        } else if (authException.getCause() instanceof UsernameNotFoundException) {
        	//response.sendRedirect("login");
        }
		
		response.sendRedirect("login");
	}
}
