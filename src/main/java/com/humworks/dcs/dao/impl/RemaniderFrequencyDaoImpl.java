package com.humworks.dcs.dao.impl;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.RemainderFrequecyDao;
import com.humworks.dcs.entities.RemainderFrequency;

@Repository
public class RemaniderFrequencyDaoImpl extends AbstractDao<Integer, RemainderFrequency> implements RemainderFrequecyDao {

	@Override
	public ArrayList<RemainderFrequency> selectAll() {
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<RemainderFrequency> cq = cb.createQuery(RemainderFrequency.class);
		Root<RemainderFrequency> root = cq.from(RemainderFrequency.class);
		cq.select(root);
		cq.orderBy(cb.desc(root.get("frequencyMasterId")));
		return (ArrayList<RemainderFrequency>) getSession().createQuery(cq).getResultList();
	}

}
