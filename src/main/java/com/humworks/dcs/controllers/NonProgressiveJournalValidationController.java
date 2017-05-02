package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assessment/nonproressive-validate")
public class NonProgressiveJournalValidationController {

	private final String page = "auth/assessment/journal_validation_non_progressive";

	@GetMapping(value={"/","list",""})
	public String list(Model model){
		return page;
	}
}
