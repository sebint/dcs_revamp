package com.humworks.dcs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humworks.dcs.entities.Objects;
import com.humworks.dcs.entities.ObjectsMaster;
import com.humworks.dcs.entities.Role;
import com.humworks.dcs.exception.ResourceNotFoundException;
import com.humworks.dcs.service.ObjectService;
import com.humworks.dcs.service.PermissionService;
import com.humworks.dcs.service.RoleService;
import com.humworks.dcs.service.UserService;

@Controller
@RequestMapping("/security/role")
public class RoleController {

	private final String page = "auth/security/role";
	private final String view = "auth/security/role-view";
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ObjectService objectService;
	
	@Autowired
	private PermissionService permissionService;
	
	
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

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
		model.addAttribute("users",userService.findByRoleId(role.getIntRoleId()));
		model.addAttribute("object", object);
		//System.out.println(object);
		//permissionService.ListPermission(role.getIntRoleId());
		return view;
	}
	
	@PostMapping("{strRoleName}")
	public String setPermission(@PathVariable("strRoleName") String strRoleName, final RedirectAttributes redirectAttributes, @Valid @ModelAttribute("object") ObjectsMaster object, BindingResult result){
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
