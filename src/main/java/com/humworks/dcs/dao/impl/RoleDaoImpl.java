package com.humworks.dcs.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.RoleDao;
import com.humworks.dcs.entities.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		
		Criteria criteria = createEntityCriteria();
		criteria.setProjection(Projections.projectionList()
				.add(Projections.property("intRoleId"), "intRoleId")
				.add(Projections.property("strRoleName"), "strRoleName"))
		.setResultTransformer(Transformers.aliasToBean(Role.class));
		criteria.addOrder(Order.asc("strRoleName"));
		List<Role> roles = criteria.list();
		return roles;
	}

	@Override
	public Role findByType(String type) {
		 Criteria crit = createEntityCriteria();
	     crit.add(Restrictions.eq("strRoleName", type));
	     return (Role) crit.uniqueResult();
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
