package com.humworks.dcs.dao.impl;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.UserStatusDao;
import com.humworks.dcs.entities.UserStatus;

@Repository("userStatusDao")
public class UserStatusDaoImpl extends AbstractDao<Integer, UserStatus> implements UserStatusDao {
	
	@Override
	public Integer saveStatus(UserStatus userStatus) {
		return save(userStatus);
	}

}
