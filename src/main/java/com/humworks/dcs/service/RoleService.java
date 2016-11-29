package com.humworks.dcs.service;

import java.util.List;

import com.humworks.dcs.entities.Role;

public interface RoleService {
	
	List<Role> findAll();
	
	List<Role> listAll();
    
	Role findByType(String type);
     
	Role findById(Integer id);
}
