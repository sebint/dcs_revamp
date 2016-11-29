package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage/lookup/")
public class LookupDataController {

	private final String page = "auth/administrator/lookup_data";

	@GetMapping(value={"/","list","index","home"})
	public String list(Model model){
		return page;
	}
}
