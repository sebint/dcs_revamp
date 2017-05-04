package com.humworks.dcs.dao.impl;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.NonProgressiveJournalDesignDao;
import com.humworks.dcs.entities.NonProgressiveJournalDesign;

@Repository("nonProgressiveDesignDao")
public class NonProgressiveJournalDesignDaoImpl extends AbstractDao<Integer, NonProgressiveJournalDesign>
		implements NonProgressiveJournalDesignDao {

	@Override
	public Integer saveNonProgressive(NonProgressiveJournalDesign nonProgressive) {
		return save(nonProgressive);
	}

	@Override
	public Integer updateDesign(NonProgressiveJournalDesign nonProgressive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDesign(NonProgressiveJournalDesign nonProgressive) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NonProgressiveJournalDesign findById(Integer npid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NonProgressiveJournalDesign findByName(String nonProgressiveName, Integer projrctMasterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NonProgressiveJournalDesign> selectAll() {
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<NonProgressiveJournalDesign> cq = cb.createQuery(NonProgressiveJournalDesign.class);
		Root<NonProgressiveJournalDesign> root = cq.from(NonProgressiveJournalDesign.class);
		cq.select(root);
		cq.where(cb.equal(root.get("status"),1));
//		1:Active
//		2.Deleted
		cq.orderBy(cb.asc(root.get("colOrder")));
		return (ArrayList<NonProgressiveJournalDesign>) getSession().createQuery(cq).getResultList();
	}

	@Override
	public ArrayList<NonProgressiveJournalDesign> findByJournalId(Integer journalMasterId) {
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<NonProgressiveJournalDesign> cq = cb.createQuery(NonProgressiveJournalDesign.class);
		Root<NonProgressiveJournalDesign> root = cq.from(NonProgressiveJournalDesign.class);
		cq.select(root);
		cq.where(cb.equal(root.get("status"),1),
				 cb.equal(root.get("nonProgressiveMasterId"),journalMasterId));
		cq.orderBy(cb.asc(root.get("colOrder")));
		return (ArrayList<NonProgressiveJournalDesign>) getSession().createQuery(cq).getResultList();
	}
	
	@Override
	public ArrayList<Long> selectUnique(){
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<NonProgressiveJournalDesign> root = cq.from(NonProgressiveJournalDesign.class);
		cq.select(root.get("nonProgressiveMasterId")).distinct(true);
		cq.where(cb.equal(root.get("status"),1));
		return (ArrayList<Long>) getSession().createQuery(cq).getResultList();
	}

	@Override
	public void transactionRollback() {
		// TODO Auto-generated method stub
		
	}

}
