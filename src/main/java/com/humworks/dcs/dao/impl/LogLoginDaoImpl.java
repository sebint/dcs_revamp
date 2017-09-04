package com.humworks.dcs.dao.impl;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.LogLoginDao;
import com.humworks.dcs.entities.LogLogin;

@Repository("logLoginDao")
public class LogLoginDaoImpl extends AbstractDao<Integer, LogLogin> implements LogLoginDao {

	@Override
	public void createNewLog(LogLogin log) {
		try {
			save(log);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
