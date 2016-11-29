package com.humworks.dcs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.humworks.dcs.entities.Role;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.service.RoleService;
import com.humworks.dcs.service.UserService;

@Controller	
@RequestMapping("/security/user")
public class UserController {
	
	private final String page = "auth/security/user";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@GetMapping(value={"/","list"})
	public String getUser(Model model){
		return page;
	}
	
	@PostMapping(value={"/","list"})
	public String saveUser(@Valid @ModelAttribute User user, BindingResult result){
		if (result.hasErrors()) {
			return page;
		}
		return page;
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute User user, BindingResult result){
		if (result.hasErrors()) {
			return page;
		}
		return page;
	}
	
	@PostMapping("update")
	public String update(@Valid @ModelAttribute User user, BindingResult result){
		if (result.hasErrors()) {
			return page;
		}
		return page;
	}
	
	@PostMapping("delete")
	public String delete(@Valid @ModelAttribute User user, BindingResult result){
		if (result.hasErrors()) {
			return page;
		}
		return page;
	}
	
	@GetMapping("password/change")
	public String reset(@Valid @ModelAttribute User user, BindingResult result){
		if (result.hasErrors()) {
			return page;
		}
		return page;
	}
	
	@GetMapping("account/password-change")
	public String changePassword(@Valid @ModelAttribute User user, BindingResult result){
		if (result.hasErrors()) {
			return "auth/security/change_password";
		}
		return "auth/security/change_password";
	}
	
	
	
	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}
	
	@ModelAttribute("rolesOptions")
	public List<Role> getRoles(){
		return roleService.findAll();
	}
	
	@ModelAttribute("userList")
	public List<User> userList(){
		return userService.selectAll();
	}
	
}
