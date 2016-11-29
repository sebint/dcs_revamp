package com.humworks.dcs.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.humworks.dcs.entities.Login;
import com.humworks.dcs.entities.SpringUser;
import com.humworks.dcs.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping(value={"/","/login"})
	public String index(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

//	@GetMapping("login")
//	public String login(Model model) {
//		model.addAttribute("login", new Login());
//		return "login";
//	}
	

	@PostMapping("login")
	public String authenticate(@Valid @ModelAttribute Login login, BindingResult result) {
		if (result.hasErrors()) {
			return "login";
		}
		return "redirect:/dashboard";
	}
	

	@GetMapping("dashboard")
	public String dashboard() {
		return "auth/dashboard";
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication !=null){
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/login";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
