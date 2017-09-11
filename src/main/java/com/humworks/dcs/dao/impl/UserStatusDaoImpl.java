package com.humworks.dcs.dao.impl;

import javax.persistence.Query;

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
	
	@Override
	public Integer updateStatus(String field, Integer value, Integer userId) {
		String hql = "UPDATE UserStatus SET "+field +"="+value+" WHERE intUserId =:intUserId";
		Query query = getSession().createQuery(hql).setParameter("intUserId", userId);
		return query(query);	
	}

}
