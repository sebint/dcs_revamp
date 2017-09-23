package com.humworks.dcs.dao;

import com.humworks.dcs.entities.UserStatus;

public interface UserStatusDao {
	
	Long saveStatus(UserStatus userStatus);
	Long updateStatus(String field, Integer value, Long userId);

}
