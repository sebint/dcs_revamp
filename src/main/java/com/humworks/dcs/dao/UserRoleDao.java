package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.UserRole;

public interface UserRoleDao {

	Long saveUserRole(UserRole userRole);
	
	Long updateUserRole(UserRole userRole);
	
	ArrayList<Long> findByRole(Long roleMasterId);
	
	UserRole findById(Long urid);
	
}
