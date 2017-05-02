package com.humworks.dcs.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.RoleDao;
import com.humworks.dcs.entities.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {
	
	@Override
	public List<Role> findAll() {
		try{
			CriteriaBuilder cb = createCriteriaQuery();
			CriteriaQuery<Role> cq = cb.createQuery(Role.class);
			Root<Role> root = cq.from(Role.class);
			cq.select(root);
			cq.orderBy(cb.asc(root.get("strRoleName")));
			return (List<Role>) getSession().createQuery(cq).getResultList();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Role findByType(String type) {
		
		try{
			CriteriaBuilder cb = createCriteriaQuery();
			CriteriaQuery<Role> cq = cb.createQuery(Role.class);
			Root<Role> root = cq.from(Role.class);
			cq.where(cb.equal(cb.lower(root.get("strRoleName")), type));
	        return (Role) getSession().createQuery(cq).getSingleResult();
		}catch(javax.persistence.NoResultException nr){
			return null;
		}catch(java.lang.NullPointerException np){
			return null;
		}catch(Exception ex){
			return null;
		}
	}

	@Override
	public Role findById(Integer id) {
		return getByKey(id);
	}

	@Override
	public List<Role> listAll() {
		return listAllByQuery("from Role order by intRoleId");
	}

	
}
