package com.humworks.dcs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.LoginDao;
import com.humworks.dcs.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Boolean userAuthenticate(String userName, String password) {
		if(loginDao.checkUser(userName, password)>0){
			return true;
		}
		return false;
	}
	
}
