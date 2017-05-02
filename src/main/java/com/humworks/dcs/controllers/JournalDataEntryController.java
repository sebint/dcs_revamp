package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assessment/journal-entry")
public class JournalDataEntryController {

	private final String page = "auth/assessment/journal_data_entry";

	@GetMapping(value={"/","list",""})
	public String list(Model model){
		return page;
	}

}
