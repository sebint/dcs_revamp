package com.humworks.dcs.service;

import java.util.List;

import com.humworks.dcs.entities.Permission;

public interface PermissionService {
	
	List<Permission> ListPermission(Integer roleMasterId);

}
