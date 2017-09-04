package com.humworks.dcs.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.humworks.dcs.entities.LogLogin;
import com.humworks.dcs.service.LogLoginService;

@Component
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private LogLoginService logLoginService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);
		boolean isAdmin = false;
		boolean isPassChange = false;
		try {
			WebAuthenticationDetails details = (WebAuthenticationDetails) auth.getDetails();
			//logs the login details
			LogLogin log = new LogLogin();
			log.setIpLogin(details.getRemoteAddress());
			log.setIsMobile(0);
			log.setSessionId(details.getSessionId());
			log.setUserAgent(request.getHeader("User-Agent"));
			logLoginService.createLog(log);
		}catch(Exception ex) {
			//log exception here
		}
		
		for(GrantedAuthority gAuth: auth.getAuthorities()){
			if("ROLE_ADMIN".equals(gAuth.getAuthority())){
				isAdmin = true;
			}else if("ROLE_CHANGE_PASSWORD".equals(gAuth.getAuthority())){
				isPassChange = true;
			}
		}
		if(isAdmin){			
			response.sendRedirect("dashboard");				
		}else if(isPassChange){
			response.sendRedirect("reset");
		}else{
			response.sendRedirect("dashboard");	
		}
	}

}
