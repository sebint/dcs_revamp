package com.humworks.dcs.dao;

import java.util.List;

import com.humworks.dcs.entities.Permission;

public interface PermissionDao {
	
	List<Permission> FindPermissionByRole(Integer roleMasterId);
}
