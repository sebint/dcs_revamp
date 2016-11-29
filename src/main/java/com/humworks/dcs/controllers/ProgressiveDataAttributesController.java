package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage/data-attribute/")
public class ProgressiveDataAttributesController {

	private final String page = "auth/administrator/progressive_data_attributes";

	@GetMapping(value={"/","list","index","home"})
	public String list(Model model){
		return page;
	}
}
