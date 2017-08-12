package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.UserRole;

public interface UserRoleDao {

	Integer saveUserRole(UserRole userRole);
	
	Integer updateUserRole(UserRole userRole);
	
	ArrayList<Integer> findByRole(Integer roleMasterId);
	
	UserRole findById(Integer urid);
	
}
