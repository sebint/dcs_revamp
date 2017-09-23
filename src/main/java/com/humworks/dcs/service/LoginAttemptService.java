package com.humworks.dcs.service;

public interface LoginAttemptService {

	final int MAX_ATTEMPT = 5;
	
	void loginSucceed(String key);
	void loginFailed(String key);
	boolean isBlocked(String key);
	Integer countAttempts(String key);
	void saveOrUpdate(String key1, String key2);
	Long updateStatus(String field, Integer value, Long userId);
}
