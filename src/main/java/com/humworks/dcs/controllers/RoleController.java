package com.humworks.dcs.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.humworks.dcs.entities.Objects;
import com.humworks.dcs.entities.ObjectsMaster;
import com.humworks.dcs.entities.Role;
import com.humworks.dcs.exception.ResourceNotFoundException;
import com.humworks.dcs.service.ObjectService;
import com.humworks.dcs.service.RoleService;

@Controller
@RequestMapping("/security/role")
public class RoleController {

	private final String page = "auth/security/role";
	private final String view = "auth/security/role-view";
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ObjectService objectService;
	
	@GetMapping(value={"","/","list"})
	public String listRoles(Model model){
		return page;
	}
	
	@GetMapping("{strRoleName}")
	public String view(@PathVariable("strRoleName") String strRoleName, Model model)throws Exception{
		final Role role = roleService.findByType(strRoleName);
		if(role==null){
			throw new ResourceNotFoundException(strRoleName);
		}
		final ArrayList<ObjectsMaster> object = objectService.findParentMenu();
		model.addAttribute("role", role);
		model.addAttribute("object", object);
		return view;
	}
	
	@ModelAttribute("role")
	public Role getUser(){
		return new Role();
	}
	
	@ModelAttribute("listRoles")
	public List<Role> roles(){
		return roleService.listAll();
	}
	
	@ModelAttribute("listPages")
	public List<Objects> homePages(){
		return objectService.selectAll();
	}
}
