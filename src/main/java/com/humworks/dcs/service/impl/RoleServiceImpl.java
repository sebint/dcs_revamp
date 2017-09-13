package com.humworks.dcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.RoleDao;
import com.humworks.dcs.entities.Role;
import com.humworks.dcs.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Role findByType(String type) {
		return roleDao.findByType(type.replace('-', ' ').toLowerCase());
	}

	@Override
	@Transactional(readOnly = true)
	public Role findById(Integer id) {
		return roleDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> listAll() {
		return roleDao.listAll();
	}

}
