package com.humworks.dcs.dao.impl;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.UserRoleDao;
import com.humworks.dcs.entities.UserRole;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends AbstractDao<Integer, UserRole> implements UserRoleDao {

	@Override
	public Integer saveUserRole(UserRole userRole) {
		return save(userRole);
	}

}
