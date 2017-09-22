package com.humworks.dcs.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	
	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		httpSessionEvent.getSession().setMaxInactiveInterval(30*60);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
