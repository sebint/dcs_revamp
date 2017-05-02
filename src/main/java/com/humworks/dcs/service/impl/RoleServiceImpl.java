package com.humworks.dcs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.RoleDao;
import com.humworks.dcs.entities.Role;
import com.humworks.dcs.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public Role findByType(String type) {
		return roleDao.findByType(type.replace('-', ' ').toLowerCase());
	}

	@Override
	public Role findById(Integer id) {
		return roleDao.findById(id);
	}

	@Override
	public List<Role> listAll() {
		return roleDao.listAll();
	}

}
