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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humworks.dcs.entities.ProjectMaster;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.service.UserService;

@Controller
@RequestMapping("/design/templates/")
public class ProjectTemplatesController {
	
	private final String page = "auth/design/project_templates";
	private final String add = "auth/design/project_templates_add";
	
	@Autowired
	private UserService userService;

	@GetMapping(value={"/","list"})
	public String list(Model model){
		return page;
	}
	
	@GetMapping("new")
	public String loadAdd(@ModelAttribute ProjectMaster project){
		return add;
	}
	
	@PostMapping("new")
	public String saveAdd(@RequestParam String mode, final RedirectAttributes redirectAttributes, @Valid @ModelAttribute ProjectMaster project, BindingResult result){
		if (result.hasErrors()) {
			return add;
		}
		return page;
	}
	
	@ModelAttribute("project")
	public ProjectMaster getProject(){
		return new ProjectMaster();
	}
	
	@ModelAttribute("userList")
	public List<User> userList(){
		return userService.selectAll();
	}
	
/*	@GetMapping("")
	public String get(){
		return "redirect:/design/templates/";
	}
	@GetMapping("new/**")
	public String getNew(){
		return "redirect:/design/templates/new";
	}*/

}
