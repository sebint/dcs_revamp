package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report/photo")
public class PhotoReportController {

	private final String page = "auth/report/photo_report";

	@GetMapping(value={"/","list",""})
	public String list(Model model){
		return page;
	}
}
