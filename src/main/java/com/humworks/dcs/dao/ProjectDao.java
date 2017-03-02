package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.ProjectMaster;

public interface ProjectDao {
	
	Integer saveProject(ProjectMaster project);
	
	Integer updateProject(ProjectMaster project);
		
	void deleteProject(ProjectMaster project);
    
	Integer findUid(String projectName);
	
	ProjectMaster findById(Integer pid);
     
	ProjectMaster findByName(String projectName);
    
    ArrayList<ProjectMaster> selectAll();
    
    void transactionRollback();

}
