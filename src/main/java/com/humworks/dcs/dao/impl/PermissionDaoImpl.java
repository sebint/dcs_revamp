package com.humworks.dcs.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.PermissionDao;
import com.humworks.dcs.entities.Permission;

@Repository("permissionDao")
public class PermissionDaoImpl extends AbstractDao<Integer, Permission> implements PermissionDao  {

	@Override
	public List<Permission> FindPermissionByRole(Integer roleMasterId) {		
		try{
			CriteriaBuilder cb = createCriteriaQuery();
			CriteriaQuery<Permission> cq = cb.createQuery(Permission.class);
			Root<Permission> root = cq.from(Permission.class);
			cq.where(cb.equal(root.get("roleMasterId"), roleMasterId));
	        return (List<Permission>) getSession().createQuery(cq).getResultList();
		}catch(javax.persistence.NoResultException nr){
			return null;
		}catch(java.lang.NullPointerException np){
			return null;
		}catch(Exception ex){
			return null;
		}
	}

}
