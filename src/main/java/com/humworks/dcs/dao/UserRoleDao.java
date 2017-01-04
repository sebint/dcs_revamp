package com.humworks.dcs.dao;

import com.humworks.dcs.entities.UserRole;

public interface UserRoleDao {

	Integer saveUserRole(UserRole userRole);
	
	Integer updateUserRole(UserRole userRole);
	
	UserRole findById(Integer urid);
	
}
