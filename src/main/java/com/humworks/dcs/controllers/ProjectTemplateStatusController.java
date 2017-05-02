package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timeline/template-status")
public class ProjectTemplateStatusController {
	
	private final String page = "auth/timeline/project_template_status";

	@GetMapping(value={"","/","list"})
	public String list(Model model){
		return page;
	}
}
