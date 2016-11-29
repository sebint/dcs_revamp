package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/design/templates/")
public class ProjectTemplatesController {
	
	private final String page = "auth/design/project_templates";

	@GetMapping(value={"/","list","index","home"})
	public String list(Model model){
		return page;
	}

}
