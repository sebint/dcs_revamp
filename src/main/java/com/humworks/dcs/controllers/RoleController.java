package com.humworks.dcs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.humworks.dcs.entities.Role;
import com.humworks.dcs.service.RoleService;

@Controller
@RequestMapping("/security/role/")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping(value={"/","list"})
	public String listRoles(Model model){
		return "auth/security/role";
	}
	
	@ModelAttribute("role")
	public Role getUser(){
		return new Role();
	}
	
	@ModelAttribute("listRoles")
	public List<Role> roles(){
		return roleService.listAll();
	}
}
