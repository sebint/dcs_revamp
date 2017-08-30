package com.humworks.dcs.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.humworks.dcs.entities.SpringUser;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.service.UserService;

@Component
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setStatus(HttpServletResponse.SC_OK);
		User authUser = null;
		boolean isAdmin = false;
		boolean isPassChange = false;
		
		Object authUserDetails = auth.getPrincipal();
		if (authUserDetails instanceof SpringUser) {
			SpringUser user = (SpringUser) authUserDetails;    
			authUser = userService.findById(user.getUserId());
			if(authUser.getBoolPwdChange()==1){
				isPassChange = true;
			}
		}	
		
		for(GrantedAuthority gAuth: auth.getAuthorities()){
			if("ROLE_ADMIN".equals(gAuth.getAuthority())){
				isAdmin = true;
			}
		}
		if(isAdmin){
			if(isPassChange){
				response.sendRedirect("reset");
			}else{
				response.sendRedirect("dashboard");
			}					
		}else{
			if(isPassChange){
				response.sendRedirect("reset");
			}else{
				//Temporary
				response.sendRedirect("dashboard");
			}
		}

	}

}
