package com.humworks.dcs.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.humworks.dcs.entities.ProjectMaster;
import com.humworks.dcs.service.ProjectService;

@Component
public class ProjectValidators implements Validator {

	@Autowired
	private ProjectService projectService;
	
	@Override
	public boolean supports(Class<?> project) {
		// TODO Auto-generated method stub
		return ProjectMaster.class.equals(project);
	}

	@Override
	public void validate(Object project, Errors errors) {
		ProjectMaster projectMaster = (ProjectMaster) project;
		ProjectMaster proj = projectService.findByName(projectMaster.getProjectName());
		if(projectMaster.getProjectMasterId()==null){
			if(proj!=null){
				errors.rejectValue("projectName", "project.exist");
			}
		}else{
			if(proj!=null){
				if(proj.getProjectMasterId() != projectMaster.getProjectMasterId()){
					errors.rejectValue("projectName", "project.exist");
				}
			}
		}
	}

}
