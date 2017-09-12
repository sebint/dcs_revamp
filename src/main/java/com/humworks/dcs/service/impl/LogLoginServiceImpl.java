package com.humworks.dcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.LogLoginDao;
import com.humworks.dcs.entities.LogLogin;
import com.humworks.dcs.service.LogLoginService;
import com.humworks.dcs.service.SessionService;

@Service("logLoginService")
public class LogLoginServiceImpl implements LogLoginService {

	@Autowired
	private LogLoginDao logLoginDao;
	
	@Autowired
	private SessionService sessionService;
		
	public void setLogLoginDao(LogLoginDao logLoginDao) {
		this.logLoginDao = logLoginDao;
	}

	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}

	@Override
	@Transactional
	public void createLog(LogLogin log) {
		log.setUserId(sessionService.getActiveUid());
		logLoginDao.createNewLog(log);
	}

}
