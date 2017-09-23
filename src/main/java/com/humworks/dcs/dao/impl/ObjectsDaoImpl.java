package com.humworks.dcs.dao.impl;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.ObjectsDao;
import com.humworks.dcs.entities.Objects;
import com.humworks.dcs.entities.ObjectsMaster;

@Repository("objectDao")
public class ObjectsDaoImpl extends AbstractDao<Objects, Long> implements ObjectsDao {

	@Override
	public ArrayList<Objects> selectAll() {
			CriteriaBuilder cb = createCriteriaQuery();
			CriteriaQuery<Objects> cq = cb.createQuery(Objects.class);
			Root<Objects> root = cq.from(Objects.class);
			cq.select(root);
			cq.orderBy(cb.asc(root.get("intMenuSubId")));
			return (ArrayList<Objects>) getSession().createQuery(cq).getResultList();
	}

	@Override
	public ArrayList<ObjectsMaster> getParentMenu() {
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<ObjectsMaster> cq = cb.createQuery(ObjectsMaster.class);
		Root<ObjectsMaster> root = cq.from(ObjectsMaster.class);
		cq.select(root);
		cq.orderBy(cb.asc(root.get("intSeqNo")));
		return (ArrayList<ObjectsMaster>) getSession().createQuery(cq).getResultList();		
	}
}
