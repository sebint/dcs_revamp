package com.humworks.dcs.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setStatus(HttpServletResponse.SC_OK);
		
		boolean isAdmin = false;
		
		for(GrantedAuthority gAuth: auth.getAuthorities()){
			if("ROLE_ADMIN".equals(gAuth.getAuthority())){
				isAdmin = true;
			}
		}
		
		if(isAdmin){
			response.sendRedirect("dashboard");
		}else{
			//Temporary
			response.sendRedirect("dashboard");
		}

	}

}
