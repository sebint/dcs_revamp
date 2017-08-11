package com.humworks.dcs.dao.impl;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.UserRoleDao;
import com.humworks.dcs.entities.UserRole;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends AbstractDao<Integer, UserRole> implements UserRoleDao {

	@Override
	public Integer saveUserRole(UserRole userRole) {
		return save(userRole);
	}

	@Override
	public Integer updateUserRole(UserRole userRole) {
		String hql = "UPDATE UserRole SET intRoleId = :intRoleId, intModifiedBy =:intModifiedBy,"
				+ " dtDateModified =:dtDateModified"
				+ " WHERE intUserId = :intUserId";
	Query query = getSession().createQuery(hql);
	query.setParameter("intRoleId", userRole.getIntRoleId());
	query.setParameter("intModifiedBy", userRole.getIntModifiedBy());
	query.setParameter("dtDateModified", new Date());
	query.setParameter("intUserId", userRole.getIntUserId());
	return query(query);		
	}

	@Override
	public UserRole findById(Integer urid) {
		return getByKey(urid);
	}

	@Override
	public ArrayList<Integer> findByRole(Integer roleMasterId) {	
				
		String hql = "SELECT intUserId FROM UserRole WHERE intRoleId =:intRoleId";
		@SuppressWarnings("unchecked")
		TypedQuery<Integer> query = getSession().createQuery(hql).setParameter("intRoleId", roleMasterId);
		ArrayList<Integer> uids = (ArrayList<Integer>) query.getResultList();
		if(uids != null){
			return uids;
		}
		return null;
		
	}

}
