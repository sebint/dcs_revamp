package com.humworks.dcs.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.ProjectDao;
import com.humworks.dcs.entities.ProjectMaster;
import com.humworks.dcs.service.ProjectService;
import com.humworks.dcs.service.SessionService;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private SessionService sessionService;	

	@Override
	public Integer save(ProjectMaster project) {
		Integer currentUser = sessionService.getActiveUid();
		project.setIntCreatedBy(currentUser);
		project.setIntModifiedBy(currentUser);
	    return projectDao.saveProject(project);
	}

	@Override
	public Integer update(ProjectMaster project) {
		try{
			   Integer currentUser = sessionService.getActiveUid();
			   project.setIntModifiedBy(currentUser);
			   if(projectDao.updateProject(project)>0){
			    	   return 1;
			   }
//			   userDao.transactionRollback();
			   return 0;
			}catch(Exception ex){
				ex.printStackTrace();
				return 0;
			}
	}

	@Override
	public void delete(ProjectMaster project) {
		// TODO Auto-generated method stub

	}

	@Override
	public ProjectMaster findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectMaster findByName(String projectName) {
		// TODO Auto-generated method stub
		return projectDao.findByName(projectName.replace('-', ' ').toLowerCase());
	}

	@Override
	public ArrayList<ProjectMaster> selectAll() {
		return projectDao.selectAll();
	}

}
