package com.humworks.dcs.dao.impl;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.NonProgressiveJournalDao;
import com.humworks.dcs.entities.NonProgressiveJournalMaster;
import com.humworks.dcs.entities.RemainderFrequency;

@Repository("nonProgressiveDao")
public class NonProgressiveJournalDaoImpl extends AbstractDao<Integer, NonProgressiveJournalMaster> implements NonProgressiveJournalDao {

	@Override
	public Integer saveNonProgressive(NonProgressiveJournalMaster nonProgressive) {
		return save(nonProgressive);
	}

	@Override
	public Integer updateNonProgressive(NonProgressiveJournalMaster nonProgressive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNonProgressive(NonProgressiveJournalMaster nonProgressive) {
		// TODO Auto-generated method stub

	}

	@Override
	public NonProgressiveJournalMaster findById(Integer npid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NonProgressiveJournalMaster findByName(String nonProgressiveName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NonProgressiveJournalMaster> selectAll() {
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<NonProgressiveJournalMaster> cq = cb.createQuery(NonProgressiveJournalMaster.class);
		Root<NonProgressiveJournalMaster> root = cq.from(NonProgressiveJournalMaster.class);
		cq.select(root);
		cq.orderBy(cb.desc(root.get("projectMasterId")));
		return (ArrayList<NonProgressiveJournalMaster>) getSession().createQuery(cq).getResultList();
	}

	@Override
	public void transactionRollback() {
		// TODO Auto-generated method stub

	}

}
