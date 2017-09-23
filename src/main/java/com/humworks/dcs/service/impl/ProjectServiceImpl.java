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
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private SessionService sessionService;	

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}

	@Override
	@Transactional
	public Long save(ProjectMaster project) {
		String currentUser = sessionService.getActiveFullName();
		project.setIntCreatedBy(currentUser);
		project.setIntModifiedBy(currentUser);
	    return projectDao.saveProject(project);
	}

	@Override
	@Transactional
	public Integer update(ProjectMaster project) {
		try{
			   String currentUser = sessionService.getActiveFullName();
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
	@Transactional
	public void delete(ProjectMaster project) {
		projectDao.deleteProject(project);

	}

	@Override
	@Transactional(readOnly= true)
	public ProjectMaster findById(Integer id) {
		// TODO Auto-generated method stub
		return projectDao.findById(id);
	}

	@Override
	@Transactional(readOnly= true)
	public ProjectMaster findByName(String projectName) {
		// TODO Auto-generated method stub
		return projectDao.findByName(projectName.replace('-', ' ').toLowerCase());
	}

	@Override
	@Transactional(readOnly= true)
	public ArrayList<ProjectMaster> selectAll() {
		return projectDao.selectAll();
	}

}
