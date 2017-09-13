package com.humworks.dcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.PermissionDao;
import com.humworks.dcs.entities.Permission;
import com.humworks.dcs.service.PermissionService;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDao permissionDao; 
	
	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Permission> ListPermission(Integer roleMasterId) {
		return permissionDao.FindPermissionByRole(roleMasterId);
	}

}
