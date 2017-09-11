package com.humworks.dcs.dao;

import com.humworks.dcs.entities.UserStatus;

public interface UserStatusDao {
	
	Integer saveStatus(UserStatus userStatus);
	Integer updateStatus(String field, Integer value, Integer userId);

}
