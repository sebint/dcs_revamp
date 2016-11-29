package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/design/manage-template/")
public class ManageTemplatesController {

	private final String page = "auth/design/manage_templates";

	@GetMapping(value={"/","list","index","home"})
	public String list(Model model){
		return page;
	}
}
