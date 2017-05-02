package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage/attribute-group")
public class DataAttributeGroupController {
	private final String page = "auth/administrator/data_attribute_group";

	@GetMapping(value={"/","list",""})
	public String list(Model model){
		return page;
	}
}
