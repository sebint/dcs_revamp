package com.humworks.dcs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/assessment/change-log/")
public class AuditDataChangeLogController {
	
	private final String page = "auth/assessment/audit_data_change_log";

	@GetMapping(value={"/","list","index","home"})
	public String list(Model model){
		return page;
	}

}
