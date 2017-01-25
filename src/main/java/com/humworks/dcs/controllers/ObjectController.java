package com.humworks.dcs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.humworks.dcs.entities.ObjectsMaster;
import com.humworks.dcs.service.ObjectService;

@Controller
@RequestMapping("/security/object/")
public class ObjectController {

	private final String page = "auth/security/object";
	
	@Autowired
	private ObjectService objectService;

	@GetMapping(value={"/","list","index","home"})
	public String list(Model model){
		return page;
	}
	
	@ModelAttribute("objectsList")
	public List<ObjectsMaster> menuList(){
		try{
			return objectService.selectAll();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
