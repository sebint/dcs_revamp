package com.humworks.dcs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humworks.dcs.entities.Objects;
import com.humworks.dcs.entities.ObjectsMaster;
import com.humworks.dcs.service.ObjectService;

@Controller
@RequestMapping("/security/object")
public class ObjectController {

	private final String page = "auth/security/object";
	
	@Autowired
	private ObjectService objectService;

	@GetMapping(value={"/","list",""})
	public String list(Model model){
		return page;
	}
	
	@ModelAttribute("objects")
	public Objects getObjects(){
		return new Objects();
	}
	
	@ModelAttribute("objectsList")
	public List<Objects> menuList(){
		try{
			return objectService.selectAll();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	@PostMapping(value={"/"})
	public String update(final RedirectAttributes redirectAttributes, @ModelAttribute("objects") Objects objects, BindingResult result){
		return page;
	}	
	
	@ModelAttribute("menuOptions")
	public List<ObjectsMaster> getRoles(){
		return objectService.findParentMenu();
	}
}
