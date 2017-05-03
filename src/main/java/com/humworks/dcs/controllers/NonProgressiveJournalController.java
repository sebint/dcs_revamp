package com.humworks.dcs.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humworks.dcs.entities.NonProgressiveJournalMaster;
import com.humworks.dcs.entities.ProjectMaster;
import com.humworks.dcs.entities.RemainderFrequency;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.exception.ResourceNotFoundException;
import com.humworks.dcs.service.CommonService;
import com.humworks.dcs.service.NonProgressiveJournalService;
import com.humworks.dcs.service.ProjectService;
import com.humworks.dcs.service.RemainderFrequencyService;
import com.humworks.dcs.service.UnitMeasureService;
import com.humworks.dcs.service.UserService;
import com.humworks.dcs.validators.NonProgressiveJournalValidators;

@Controller
@RequestMapping("/design/non-progressive")
public class NonProgressiveJournalController {
	
	private final String page = "auth/design/non_progressive_journal";
	private final String add = "auth/design/non_progressive_journal_add";
	private final String design = "auth/design/non_progressive_journal_design";
	
	@Autowired
	private NonProgressiveJournalService nonProgressiveService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private RemainderFrequencyService frequencyService;
	
	@Autowired
	private UnitMeasureService unitMeasureService;
	
	@Autowired
	private NonProgressiveJournalValidators nonJournalValidators;
	
	
	@GetMapping(value={"","/","list"})
	public String list(Model model){
		model.addAttribute("nonProgressiveList", nonProgressiveService.selectAll());
		return page;
	}
	
	@GetMapping("new")
	public String loadAdd(@ModelAttribute NonProgressiveJournalMaster nonprogressive){
		return add;
	}
	
	@GetMapping("{journalUrl}")
	public String view(@PathVariable("journalUrl") String journalUrl, Model model)throws Exception{
		Integer projectMasterId = commonService.getIdFromUrl(journalUrl);
		String journalName = commonService.getNameFromUrl(journalUrl);
		final NonProgressiveJournalMaster journal = nonProgressiveService.findByName(journalName,projectMasterId);
		if(journal==null){
			throw new ResourceNotFoundException(journalName);
		}
		System.out.println(journal);
		model.addAttribute("nonprogressive", journal);
		model.addAttribute("journalName",journalName);
		return add;
	}
	
	@GetMapping("{journalUrl}/design")
	public String design(@PathVariable("journalUrl") String journalUrl, Model model)throws Exception{
		Integer projectMasterId = commonService.getIdFromUrl(journalUrl);
		String journalName = commonService.getNameFromUrl(journalUrl);
		final NonProgressiveJournalMaster journal = nonProgressiveService.findByName(journalName, projectMasterId);
		if(journal==null){
			throw new ResourceNotFoundException(journalName);
		}
		model.addAttribute("nonprogressive", journal);
		model.addAttribute("unitMeasure",unitMeasureService.selectAll());
		model.addAttribute("journalName",journalName);
		return design;
	}
	
	@RequestMapping(value="{journalUrl}/design", method=RequestMethod.POST)
	public @ResponseBody String getDesign(@PathVariable("journalUrl") String journalUrl, @RequestBody String name){
		
		return "success";
	}
	
	@PostMapping("{journalUrl}")
	public String updateNonProgressive(@PathVariable("journalUrl") String journalUrl, @RequestParam String mode, final RedirectAttributes redirectAttributes, @Valid @ModelAttribute("nonprogressive") NonProgressiveJournalMaster nonProgressive, BindingResult result){
		String journalName = commonService.getNameFromUrl(journalUrl);
		try{
			nonJournalValidators.validate(nonProgressive, result);
			if (result.hasErrors()) {
				return add;
			}
			if(nonProgressiveService.update(nonProgressive)>0){
				redirectAttributes.addFlashAttribute("message", "<strong>"+journalName.replace("-", " ")+"</strong> Updated Successfully.");
			}else{
				redirectAttributes.addFlashAttribute("error", "Unable to Update Project <strong>"+journalName.replace("-", " ")+"</strong>. Try again later.");
			}
		}catch(NullPointerException np){
			np.printStackTrace();	
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unsuccessfull.Try again later.");
		}
		if(mode.equals("save")){			
			return "redirect:/design/non-progressive/";
		}else{
			return "redirect:/design/non-progressive/"+journalUrl;
		}
	}
	
	@PostMapping("new")
	public String saveAdd(@RequestParam String mode, final RedirectAttributes redirectAttributes, @Valid @ModelAttribute("nonprogressive") NonProgressiveJournalMaster nonProgressive, BindingResult result){
		
		nonJournalValidators.validate(nonProgressive, result);
		
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
	
	@GetMapping("delete/{pattern}")
	public String delete(@PathVariable String pattern, final RedirectAttributes redirectAttributes) throws Exception{
		Integer nonProgressiveMasterId = commonService.getPatternFromUrl(pattern);
		final NonProgressiveJournalMaster journal = nonProgressiveService.findById(nonProgressiveMasterId);
		if(journal==null){
			throw new ResourceNotFoundException(nonProgressiveMasterId.toString());
		}
		try{
			nonProgressiveService.delete(journal);
			redirectAttributes.addFlashAttribute("message", "<strong>"+journal.getJournalName()+"</strong> deleted successfully.");
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unable to delete <strong>"+journal.getJournalName()+"</strong>. Try again later.");
		}
		return "redirect:/design/non-progressive/";
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
}
