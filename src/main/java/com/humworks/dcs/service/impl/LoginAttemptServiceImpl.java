package com.humworks.dcs.service.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.humworks.dcs.dao.LoginAttemptDao;
import com.humworks.dcs.dao.UserStatusDao;
import com.humworks.dcs.entities.LoginAttempt;
import com.humworks.dcs.service.LoginAttemptService;

@Service("loginAttemptService")
@Transactional
public class LoginAttemptServiceImpl implements LoginAttemptService {
	
	@Autowired
	private LoginAttemptDao loginAttemptDao;
	
	@Autowired
	private UserStatusDao userStatusDao;
	
	private LoadingCache<String, Integer> attemptsCache;
	
	public LoginAttemptServiceImpl() {
		super();
		attemptsCache = CacheBuilder.newBuilder().
		          expireAfterWrite(1, TimeUnit.DAYS).build(new CacheLoader<String, Integer>() {
		            public Integer load(String key) {
		                return 0;
		            }
		        });
	}

	@Override
	public void loginSucceed(String key) {
		attemptsCache.invalidate(key);

	}

	@Override
	public void loginFailed(String key) {
		int attempts = 0;
        try {
            attempts = attemptsCache.get(key);
        } catch (ExecutionException e) {
            attempts = 0;
        }
        attempts++;
        attemptsCache.put(key, attempts);

	}

	@Override
	public boolean isBlocked(String key) {
		 try {
	            return attemptsCache.get(key) >= MAX_ATTEMPT;
	        } catch (ExecutionException e) {
	            return false;
	        }
	}

	@Override
	public Integer countAttempts(String key) {	
		LoginAttempt loginAttempt = loginAttemptDao.checkExists(key);
		return (loginAttempt != null) ? loginAttempt.getUserAtmptCount() : 0 ;
	}

	@Override
	public void saveOrUpdate(String key1, String key2) {
		LoginAttempt loginAttempt = loginAttemptDao.checkExists(key1);
		if(loginAttempt != null) {
			if(loginAttemptDao.checkLifeSpan(key1)) {
				loginAttempt.setIsHistory(1);
				loginAttemptDao.saveUpdate(loginAttempt);
				loginAttemptDao.saveUpdate(new LoginAttempt(1,key1,key2,0));
			}else {
				loginAttempt.setUserAtmptCount(loginAttempt.getUserAtmptCount()+1);
				loginAttempt.setDtDateModified(null);
				loginAttemptDao.saveUpdate(loginAttempt);
			}
			
		}else {
			loginAttemptDao.saveUpdate(new LoginAttempt(1,key1,key2,0));
		}
		
	}

	@Override
	public Integer updateStatus(String field, Integer value, Integer userId) {
		return userStatusDao.updateStatus(field, value, userId);
	}

}
