package com.humworks.dcs.service;

public interface LoginAttemptService {

	final int MAX_ATTEMPT = 5;
	
	void loginSucceed(String key);
	void loginFailed(String key);
	boolean isBlocked(String key);
	Integer countAttempts();
	void saveOrUpdate(String key1, String key2);
}
