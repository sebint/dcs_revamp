package com.humworks.dcs.dao;

import java.util.List;

import com.humworks.dcs.entities.Role;

public interface RoleDao {
	
	List<Role> findAll();
	
	List<Role> listAll();
    
	Role findByType(String type);
     
	Role findById(Integer id);
}
