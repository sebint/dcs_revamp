package com.humworks.dcs.dao;

import com.humworks.dcs.entities.LoginAttempt;

public interface LoginAttemptDao {
	
	void saveUpdate(LoginAttempt loginAttempt);
	Integer getCount(String userId, String ip);
	LoginAttempt checkExists(String userId);
	boolean checkLifeSpan(String userId);

}
