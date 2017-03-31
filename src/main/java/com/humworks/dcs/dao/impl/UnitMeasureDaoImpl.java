package com.humworks.dcs.dao.impl;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.UnitMeasureDao;
import com.humworks.dcs.entities.UnitMeasure;

@Repository("unitMeasureDao")
public class UnitMeasureDaoImpl extends AbstractDao<Integer, UnitMeasure> implements UnitMeasureDao {

	@Override
	public Integer saveUnitMeasure(UnitMeasure uom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateUnitMeasure(UnitMeasure uom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUnitMeasure(UnitMeasure user) {
		// TODO Auto-generated method stub

	}

	@Override
	public UnitMeasure findById(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitMeasure findByName(String uomLabel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UnitMeasure> selectAll() {
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<UnitMeasure> cq = cb.createQuery(UnitMeasure.class);
		Root<UnitMeasure> root = cq.from(UnitMeasure.class);
		cq.select(root);
		cq.orderBy(cb.desc(root.get("uomId")));
		return (ArrayList<UnitMeasure>) getSession().createQuery(cq).getResultList();
	}

	@Override
	public void transactionRollback() {
		// TODO Auto-generated method stub

	}

}
