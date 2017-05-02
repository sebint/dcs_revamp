package com.humworks.dcs.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.humworks.dcs.service.ObjectService;

@Component
public class MenuListInterceptor extends HandlerInterceptorAdapter {


	@Autowired
	private ObjectService objectService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		try{
			if(authentication !=null){
				request.setAttribute("menuList", objectService.findParentMenu());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return super.preHandle(request, response, handler);
	}

}
