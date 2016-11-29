package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timeline/journal-status/")
public class ProjectJournalStatusController {

	private final String page = "auth/timeline/project_journal_status";

	@GetMapping(value={"/","list","index","home"})
	public String list(Model model){
		return page;
	}
}
