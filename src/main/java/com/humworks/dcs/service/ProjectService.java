package com.humworks.dcs.service;

import java.util.ArrayList;

import com.humworks.dcs.entities.ProjectMaster;

public interface ProjectService {
	
	Integer save(ProjectMaster project);
	
	Integer update(ProjectMaster project);
	
	void delete(ProjectMaster project);
	
	ProjectMaster findById(Integer id);
    
	ProjectMaster findByName(String projectName);
    
    ArrayList<ProjectMaster> selectAll();
}
