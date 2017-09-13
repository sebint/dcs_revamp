package com.humworks.dcs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.humworks.dcs.entities.Role;
import com.humworks.dcs.service.RoleService;

@Component
public class RoleIdToRoleConverter implements Converter<Object, Role> {
	
	@Autowired
	RoleService roleService;

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public Role convert(Object obj) {
		Integer id = Integer.parseInt((String)obj);
//		System.out.println("Sebin"+id);
		Role profile= roleService.findById(id);
//     	System.out.println("Profile : "+profile);
        return profile;
	}
}
