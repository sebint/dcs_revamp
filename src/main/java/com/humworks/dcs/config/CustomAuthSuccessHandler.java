package com.humworks.dcs.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import com.humworks.dcs.entities.LogLogin;
import com.humworks.dcs.service.LogLoginService;

@Component
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private LogLoginService logLoginService;
	
	public void setLogLoginService(LogLoginService logLoginService) {
		this.logLoginService = logLoginService;
	}

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
			
		handle(request, response, auth);
		registerUserLog(request,auth);
        clearAuthenticationAttributes(request);
	}
	
	protected void registerUserLog(HttpServletRequest request,Authentication authentication){
		try{
			WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
			LogLogin log = new LogLogin();
			log.setIpLogin(details.getRemoteAddress());
			log.setIsMobile(0);
			log.setSessionId(details.getSessionId());
			log.setUserAgent(request.getHeader("User-Agent"));
			logLoginService.createLog(log);
		}catch(Exception ex){
			logger.error("Unable to register user log");
		}
	}
	
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException{
		
		String targetUrl = determineTargetUrl(auth);
		if (response.isCommitted()) {
            logger.debug(
              "Response has already been committed. Unable to redirect to "
              + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);		
	}
	
	protected String determineTargetUrl(Authentication authentication) {
		boolean isAdmin = false;
		boolean isPassChange = false;
        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            if (grantedAuthority.getAuthority().equals("ROLE_CHANGE_PASSWORD")) {
            	isPassChange = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
        }
 
        if (isPassChange) {
            return "/reset";
        } else if (isAdmin) {
            return "/dashboard";
        } else {
            //throw new IllegalStateException();
        	return "/dashboard";
        }
	}
	
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
	

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	

}
