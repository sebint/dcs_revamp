package com.humworks.dcs.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.humworks.dcs.entities.ProjectMaster;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.exception.ResourceNotFoundException;
import com.humworks.dcs.service.ProjectService;
import com.humworks.dcs.service.UserService;
import com.humworks.dcs.validators.ProjectValidators;

@Controller
@RequestMapping("/design/templates/")
public class ProjectTemplatesController {
	
	private final String page = "auth/design/project_templates";
	private final String add = "auth/design/project_templates_add";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProjectValidators projectValidator;

	@GetMapping(value={"/","list"})
	public String list(Model model){
		return page;
	}
	
	@GetMapping("new")
	public String loadAdd(@ModelAttribute ProjectMaster project){
		return add;
	}
	
	@PostMapping("new")
	public String saveAdd(@RequestParam String mode, final RedirectAttributes redirectAttributes, @Valid @ModelAttribute("project") ProjectMaster project, BindingResult result){
		try{
			projectValidator.validate(project, result);
			if (result.hasErrors()) {
				return add;
			}
			if(projectService.save(project)>0){
				redirectAttributes.addFlashAttribute("message", "Project Created Successfully.");
			}else{
				redirectAttributes.addFlashAttribute("error", "Unable to Create Project. Try again later.");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unable to Create Project. Try again later.");
			return "redirect:/design/templates/new";
		}
		if(mode.equals("save")){			
			return "redirect:/design/templates/";
		}else{
			return "redirect:/design/templates/new";
		}
	}
	
	@GetMapping("{projectName}")
	public String view(@PathVariable("projectName") String projectName, Model model)throws Exception{
		final ProjectMaster project = projectService.findByName(projectName);
		if(project==null){
			throw new ResourceNotFoundException(projectName);
		}
		model.addAttribute("project", project);
		return add;
	}
	
	@PostMapping("{projectName}")
	 public String updateProject(@PathVariable("projectName") String projectName, @RequestParam String mode, final RedirectAttributes redirectAttributes, @Valid @ModelAttribute("project") ProjectMaster project, BindingResult result){
		try{
			projectValidator.validate(project, result);
			if (result.hasErrors()) {
				return add;
			}
			if(projectService.update(project)>0){
				redirectAttributes.addFlashAttribute("message", "<strong>"+projectName.replace("-", " ")+"</strong> Updated Successfully.");
			}else{
				redirectAttributes.addFlashAttribute("error", "Unable to Update Project <strong>"+projectName.replace("-", " ")+"</strong>. Try again later.");
			}			
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unsuccessfull.Try again later.");
		}
		if(mode.equals("save")){			
			return "redirect:/design/templates/";
		}else{
			return "redirect:/design/templates/"+projectName;
		}
	}
	
	@GetMapping("delete/{projectMasterId}")
	public String delete(@PathVariable Integer projectMasterId, final RedirectAttributes redirectAttributes) throws Exception{
		final ProjectMaster project = projectService.findById(projectMasterId);
		if(project==null){
			throw new ResourceNotFoundException(projectMasterId.toString());
		}
		try{
			projectService.delete(project);
			redirectAttributes.addFlashAttribute("message", "<strong>"+project.getProjectName()+"</strong> deleted successfully.");
		}catch(Exception ex){
			ex.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Unable to delete <strong>"+project.getProjectName()+"</strong>. Try again later.");
		}
		return "redirect:/design/templates/";
	}
	
	@ModelAttribute("project")
	public ProjectMaster getProject(){
		return new ProjectMaster();
	}
	
	@ModelAttribute("userList")
	public List<User> userList(){
		return userService.selectAll();
	}
	
	@ModelAttribute("projectList")
	public List<ProjectMaster> projectList(){
		return projectService.selectAll();
	}
	
/*	@GetMapping("")
	public String get(){
		return "redirect:/design/templates/";
	}
	@GetMapping("new/**")
	public String getNew(){
		return "redirect:/design/templates/new";
	}*/

}
