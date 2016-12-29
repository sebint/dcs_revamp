package com.humworks.dcs.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humworks.dcs.entities.Role;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.service.RoleService;
import com.humworks.dcs.service.UserService;
import com.humworks.dcs.validators.UserValidators;

@Controller	
@RequestMapping("/security/user")
public class UserController {
	
	private final String page = "auth/security/user";
	private final String add = "auth/security/user-add";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserValidators userValidators;
	
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
	
	@GetMapping("new")
	public String loadAdd(@ModelAttribute User user){
		return add;
	}
	
	@PostMapping("new")
	public String add(@RequestParam String mode, final RedirectAttributes redirectAttributes, @Valid @ModelAttribute User user, BindingResult result){
		try{
			//As intRoleId is @Trancient property the validation won't work for role alone.
			//Added user defined validation class and invoked below.
			userValidators.validate(user, result);
			if (result.hasErrors()) {
				return add;
			}
			userService.save(user);
			redirectAttributes.addFlashAttribute("message", "Successfull");
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unsuccessfull.Try again later.");
			return "redirect:/security/user/new";
		}
		if(mode.equals("save")){
			
			return "redirect:/security/user/";
		}else{
			return "redirect:/security/user/new";
		}
	}
	
	@GetMapping("{strUserName}")
	public String view(@PathVariable("strUserName") String strUserName, Model model){
		model.addAttribute("user", userService.findByUsername(strUserName));
		return add;
	}
	
	@PostMapping("update/{intUserId}")
	public String update(@PathVariable("intUserId") Integer intUserId,@Valid @ModelAttribute User user, BindingResult result){
		try{
			if (result.hasErrors()) {
				return page;
			}
			userService.update(user);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/security/user/";
	}
	
	@PostMapping("delete/{intUserId}")
	public String delete(@Valid @ModelAttribute User user, @PathVariable("intUserId") Integer intUserId, BindingResult result){
		if (result.hasErrors()) {
			return page;
		}
		userService.delete(user);
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
	
	/*-------------------------------------------------------
	 * 	To Avoid invalid url 
	 * ------------------------------------------------------
	 * */
	
	@GetMapping(value={"","new/**"})
	public String get(){
		return "redirect:/security/user/";
	}
}
