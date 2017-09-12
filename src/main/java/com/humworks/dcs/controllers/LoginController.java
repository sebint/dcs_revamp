package com.humworks.dcs.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humworks.dcs.entities.Login;
import com.humworks.dcs.service.MailService;
import com.humworks.dcs.service.UserService;
import com.humworks.dcs.validators.PasswordResetValidators;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	@Autowired
	private PasswordResetValidators resetValidators;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setResetValidators(PasswordResetValidators resetValidators) {
		this.resetValidators = resetValidators;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	@GetMapping(value={"/","/login"})
	public String index(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}
	
	@Autowired
    private MailService mailService;
	

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
        //System.out.println(requestMappingHandlerMapping.getHandlerMethods().keySet());
/*		Object object = new Object();
		System.out.println("In");
		mailService.sentMail(object)*/;
		return "auth/dashboard";
	}
	
	@GetMapping("logout")
	public String logout(final RedirectAttributes redirectAttributes,HttpServletRequest request, HttpServletResponse response) {
		logoutProcess(request,response);
		redirectAttributes.addFlashAttribute("message", "You have successfully logged out.");
		return "redirect:/login";
	}
	
	@GetMapping("invalid-session")
	public String invalidSession(final RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("info", "Your login session expired.");
		return "redirect:/login";
	}
	
	@GetMapping("reset")
	public String getResetPassword(Model model){
		model.addAttribute("reset", new Login());;
		return "reset";
	}
	
	@PostMapping("reset")
	public String postResetPassword(Model model,final RedirectAttributes redirectAttributes,@ModelAttribute("reset") Login reset, BindingResult result, HttpServletRequest request, HttpServletResponse response){
		try{
			resetValidators.validate(reset, result);
			if (result.hasErrors()) {
				return "reset";
			}
			if(userService.resetPassword(reset)>0){
				if(userService.updateStatus("boolPwdChange", 0, reset.getIntUserId())>0) {
					logoutProcess(request,response);
					model.addAttribute("headerText", "Your <b class=\"text-primary\">Password</b> has been reset successfully!");
					model.addAttribute("subText", "Please click below to login again.");
					model.addAttribute("redirectUrl", "/login");
					return "message";
				}
			}else{
				redirectAttributes.addFlashAttribute("error", "Unable to Change Password. Try again later.");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unable to Change Password. Try again later.");
		}
		return "redirect:/reset";
	}
	
	private void logoutProcess(HttpServletRequest request, HttpServletResponse response){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication !=null){
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
	}

//	private String getPrincipal() {
//		String userName = null;
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if (principal instanceof UserDetails) {
//			userName = ((UserDetails) principal).getUsername();
//		} else {
//			userName = principal.toString();
//		}
//		return userName;
//	}

}
