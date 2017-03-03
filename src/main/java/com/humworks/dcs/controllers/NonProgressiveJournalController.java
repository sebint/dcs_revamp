package com.humworks.dcs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humworks.dcs.entities.NonProgressiveJournalMaster;
import com.humworks.dcs.entities.ProjectMaster;
import com.humworks.dcs.entities.RemainderFrequency;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.service.NonProgressiveJournalService;
import com.humworks.dcs.service.ProjectService;
import com.humworks.dcs.service.RemainderFrequencyService;
import com.humworks.dcs.service.UserService;

@Controller
@RequestMapping("/design/non-progressive/")
public class NonProgressiveJournalController {
	
	private final String page = "auth/design/non_progressive_journal";
	private final String add = "auth/design/non_progressive_journal_add";
	
	@Autowired
	private NonProgressiveJournalService nonProgressiveService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private RemainderFrequencyService frequencyService;
	
	
	@GetMapping(value={"/","list"})
	public String list(Model model){
		return page;
	}
	
	@GetMapping("new")
	public String loadAdd(@ModelAttribute NonProgressiveJournalMaster nonprogressive){
		return add;
	}
	
	@PostMapping("new")
	public String saveAdd(@RequestParam String mode, final RedirectAttributes redirectAttributes, @Valid @ModelAttribute("nonprogressive") NonProgressiveJournalMaster nonProgressive, BindingResult result){
		if(result.hasErrors()){
			return add;
		}
		try{			
			if(nonProgressiveService.save(nonProgressive)>0){
				redirectAttributes.addFlashAttribute("message", "Non-Progressive Journal Created Successfully.");
			}else{
				redirectAttributes.addFlashAttribute("error", "Unable to Create Non-Progressive Journal. Try again later.");
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(mode.equals("save")){			
			return "redirect:/design/non-progressive/";
		}else{
			return "redirect:/design/non-progressive/new";
		}
	}
	
	@ModelAttribute("nonprogressive")
	public NonProgressiveJournalMaster getNonProgressive(){
		return new NonProgressiveJournalMaster();
	}
	
	@ModelAttribute("userList")
	public List<User> getUser(){
		return userService.selectAll();
	}
	
	@ModelAttribute("projectList")
	public List<ProjectMaster> getProject(){
		return projectService.selectAll();
	}
	
	@ModelAttribute("frequencyList")
	public List<RemainderFrequency> getFrequecy(){
		return frequencyService.selectAll();
	}
	
	@ModelAttribute("nonProgressiveList")
	public List<NonProgressiveJournalMaster> getAll(){
		return nonProgressiveService.selectAll();
	}
}
