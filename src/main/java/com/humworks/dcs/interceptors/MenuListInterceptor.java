package com.humworks.dcs.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.humworks.dcs.service.ObjectService;

public class MenuListInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private ObjectService objectService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(false){
			request.setAttribute("menuList", objectService.selectAll());
		}
		return super.preHandle(request, response, handler);
	}

}
