package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/design/non-progressive/")
public class NonProgressiveJournalController {
	
	private final String page = "auth/design/non_progressive_journal";

	@GetMapping(value={"/","list","index","home"})
	public String list(Model model){
		return page;
	}
}
