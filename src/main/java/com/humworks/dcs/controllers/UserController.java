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

import com.humworks.dcs.entities.Login;
import com.humworks.dcs.entities.Role;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.exception.InternalServerException;
import com.humworks.dcs.exception.ResourceNotFoundException;
import com.humworks.dcs.service.RoleService;
import com.humworks.dcs.service.UserService;
import com.humworks.dcs.validators.PasswordResetValidators;
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
	
	@Autowired
	private PasswordResetValidators resetValidators;
	
	@GetMapping(value={"/","list"})
	public String getUser(Model model){
		return page;
	}
	
/*	@PostMapping(value={"/","list"})
	public String saveUser(@Valid @ModelAttribute User user, BindingResult result){
		if (result.hasErrors()) {
			return page;
		}
		return page;
	}*/
	
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
			
			if(user.getBoolPwdChange()==null){
				user.setBoolPwdChange(0);
			}
			if(user.getBoolLockPwd()==null){
				user.setBoolLockPwd(0);
			}
			
			if (result.hasErrors()) {
				return add;
			}
			userService.save(user);
			redirectAttributes.addFlashAttribute("message", "User Created Successfully.");
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unable to Create User. Try again later.");
			return "redirect:/security/user/new";
		}
		if(mode.equals("save")){			
			return "redirect:/security/user/";
		}else{
			return "redirect:/security/user/new";
		}
	}
	
	@GetMapping("{strUserName}")
	public String view(@PathVariable("strUserName") String strUserName, Model model)throws Exception{
		final User user = userService.findByUsername(strUserName);
		if(user==null){
			throw new ResourceNotFoundException(strUserName);
		}
		model.addAttribute("optn", true);
		model.addAttribute("user", user);
		return add;
	}
	
	@PostMapping("{strUserName}")
	public String update(@PathVariable String strUserName, @RequestParam String mode, Model model, final RedirectAttributes redirectAttributes, @Valid @ModelAttribute User user, BindingResult result) throws Exception {
		try{
			userValidators.validateUp(user, result);
			
			model.addAttribute("optn", true);
			
			if(user.getBoolPwdChange()==null){
				user.setBoolPwdChange(0);
			}
			if(user.getBoolLockPwd()==null){
				user.setBoolLockPwd(0);
			}
			
			if (result.hasErrors()) {
				return add;
			}
			user.setIntUserId(userService.findUid(strUserName));
			if(user.getIntUserId()!=null){
				if(userService.update(user)>0){
					redirectAttributes.addFlashAttribute("message", "<strong>"+strUserName+"</strong> Updated Successfully.");
				}else{
					redirectAttributes.addFlashAttribute("error", "Unable to Update <strong>"+strUserName+"</strong>. Try again later.");
				}
			}else{
				throw new InternalServerException(new Exception("No Primary Key found for User"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unsuccessfull.Try again later.");
		}
		if(mode.equals("save")){			
			return "redirect:/security/user/";
		}else{
			return "redirect:/security/user/"+strUserName;
		}
	}
	
	@GetMapping("delete/{strUserName}")
	public String delete(@PathVariable String strUserName, final RedirectAttributes redirectAttributes) throws Exception{
		final User user = userService.findByUsername(strUserName);
		if(user==null){
			throw new ResourceNotFoundException(strUserName);
		}
		try{
			userService.delete(user);
			redirectAttributes.addFlashAttribute("message", "<strong>"+strUserName+"</strong> deleted successfully.");
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unable to delete <strong>"+strUserName+"</strong>. Try again later.");
		}
		return "redirect:/security/user/";
	}
	
	@PostMapping("reset")
	public String reset(final RedirectAttributes redirectAttributes,@ModelAttribute("reset") Login reset, BindingResult result){
		try{
			resetValidators.validate(reset, result);
			if (result.hasErrors()) {
				return page;
			}
			if(userService.resetPassword(reset)>0){
				redirectAttributes.addFlashAttribute("message", "Password Reset Successfully.");
			}else{
				redirectAttributes.addFlashAttribute("error", "Unable to Reset Password. Try again later.");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unable to Reset Password. Try again later.");
		}
		return "redirect:/security/user/";
	}
	
	@GetMapping("account/password-change")
	public String loadChangePassword(Model model){
		return "auth/security/change_password";
	}		
	
	@PostMapping("account/password-change")
	public String changePassword(final RedirectAttributes redirectAttributes, @ModelAttribute("reset") Login reset, BindingResult result){
		try{
			resetValidators.currentValidate(reset, result);
			if (result.hasErrors()) {
				return "auth/security/change_password";
			}
			if(userService.resetPassword(reset)>0){
				redirectAttributes.addFlashAttribute("message", "Password Changed Successfully.");
			}else{
				redirectAttributes.addFlashAttribute("error", "Unable to Change Password. Try again later.");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unable to Change Password. Try again later.");
		}
		return "redirect:/security/user/account/password-change";
	}	
	
	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}
	
	@ModelAttribute("reset")
	public Login getLogin(){
		return new Login();
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
