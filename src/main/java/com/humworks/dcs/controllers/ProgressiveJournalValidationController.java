package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assessment/progressive-validate/")
public class ProgressiveJournalValidationController {

	private final String page = "auth/assessment/journal_validation_progressive";

	@GetMapping(value={"/","list","index","home"})
	public String list(Model model){
		return page;
	}

}
