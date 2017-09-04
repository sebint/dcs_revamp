package com.humworks.dcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.LogLoginDao;
import com.humworks.dcs.entities.LogLogin;
import com.humworks.dcs.service.LogLoginService;
import com.humworks.dcs.service.SessionService;

@Service("logLoginService")
@Transactional
public class LogLoginServiceImpl implements LogLoginService {

	@Autowired
	private LogLoginDao logLoginDao;
	
	@Autowired
	private SessionService sessionService;
	
	@Override
	public void createLog(LogLogin log) {
		log.setUserId(sessionService.getActiveUid());
		logLoginDao.createNewLog(log);
	}

}
