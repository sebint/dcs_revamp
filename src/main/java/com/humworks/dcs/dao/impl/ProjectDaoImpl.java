package com.humworks.dcs.dao.impl;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.ProjectDao;
import com.humworks.dcs.entities.ProjectMaster;

@Repository("projectDao")
public class ProjectDaoImpl extends AbstractDao<Integer, ProjectMaster> implements ProjectDao {

	@Override
	public Integer saveProject(ProjectMaster project) {
		return save(project);
	}

	@Override
	public Integer updateProject(ProjectMaster project) {
		try{
			update(project);
			return 1;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public void deleteProject(ProjectMaster project) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer findUid(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectMaster findById(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectMaster findByName(String projectName) {
		try{
			CriteriaBuilder cb = createCriteriaQuery();
			CriteriaQuery<ProjectMaster> cq = cb.createQuery(ProjectMaster.class);
			Root<ProjectMaster> root = cq.from(ProjectMaster.class);
			cq.where(cb.equal(cb.lower(root.get("projectName")), projectName));
	        return (ProjectMaster) getSession().createQuery(cq).getSingleResult();
		}catch(javax.persistence.NoResultException nr){
			return null;
		}catch(java.lang.NullPointerException np){
			return null;
		}catch(Exception ex){
			return null;
		}
	}

	@Override
	public ArrayList<ProjectMaster> selectAll() {
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<ProjectMaster> cq = cb.createQuery(ProjectMaster.class);
		Root<ProjectMaster> root = cq.from(ProjectMaster.class);
		cq.select(root);
		cq.orderBy(cb.desc(root.get("projectMasterId")));
		return (ArrayList<ProjectMaster>) getSession().createQuery(cq).getResultList();
	}

	@Override
	public void transactionRollback() {
		// TODO Auto-generated method stub

	}

}
