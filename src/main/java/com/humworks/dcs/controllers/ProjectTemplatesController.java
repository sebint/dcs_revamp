package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.humworks.dcs.entities.ProjectMaster;

@Controller
@RequestMapping("/design/templates/")
public class ProjectTemplatesController {
	
	private final String page = "auth/design/project_templates";
	private final String add = "auth/design/project_templates_add";

	@GetMapping(value={"/","list","index","home"})
	public String list(Model model){
		return page;
	}
	
	@GetMapping("new")
	public String loadAdd(@ModelAttribute ProjectMaster project){
		return add;
	}
	
	@ModelAttribute("project")
	public ProjectMaster getProject(){
		return new ProjectMaster();
	}

}
