package com.humworks.dcs.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.NonProgressiveJournalDao;
import com.humworks.dcs.entities.NonProgressiveJournalMaster;

@Repository("nonProgressiveDao")
public class NonProgressiveJournalDaoImpl extends AbstractDao<Integer, NonProgressiveJournalMaster> implements NonProgressiveJournalDao {

	@Override
	public Integer saveNonProgressive(NonProgressiveJournalMaster nonProgressive) {
		return save(nonProgressive);
	}

	@Override
	public Integer updateNonProgressive(NonProgressiveJournalMaster nonProgressive) {
		try{
			update(nonProgressive);
			return 1;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}

	@Override
	public void deleteNonProgressive(NonProgressiveJournalMaster nonProgressive) {
		delete(nonProgressive);
	}

	@Override
	public NonProgressiveJournalMaster findById(Integer npid) {
		return getByKey(npid);
	}

	@Override
	public NonProgressiveJournalMaster findByName(String nonProgressiveName,Integer projectMasterId) {
		try{
			CriteriaBuilder cb = createCriteriaQuery();
			CriteriaQuery<NonProgressiveJournalMaster> cq = cb.createQuery(NonProgressiveJournalMaster.class);
			Root<NonProgressiveJournalMaster> root = cq.from(NonProgressiveJournalMaster.class);
			List<Predicate> predicates = new ArrayList<Predicate>();
			predicates.add(cb.equal(cb.lower(root.get("journalName")), nonProgressiveName));
			predicates.add(cb.equal(root.get("projectMasterId"), projectMasterId));
			predicates.add(cb.equal(root.get("status"), 1));
			cq.where(predicates.toArray(new Predicate[]{}));			
	        return (NonProgressiveJournalMaster) getSession().createQuery(cq).getSingleResult();
		}catch(javax.persistence.NoResultException nr){
			return null;
		}catch(java.lang.NullPointerException np){
			return null;
		}catch(Exception ex){
			return null;
		}
	}

	@Override
	public ArrayList<NonProgressiveJournalMaster> selectAll() {
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<NonProgressiveJournalMaster> cq = cb.createQuery(NonProgressiveJournalMaster.class);
		Root<NonProgressiveJournalMaster> root = cq.from(NonProgressiveJournalMaster.class);
		cq.select(root);
		cq.where(cb.equal(root.get("status"),1));
//		1:Active
//		2.Deleted
		cq.orderBy(cb.desc(root.get("projectMasterId")));
		return (ArrayList<NonProgressiveJournalMaster>) getSession().createQuery(cq).getResultList();
	}
	
	

	@Override
	public void transactionRollback() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<NonProgressiveJournalMaster> findByProjectId(Integer projectMasterId) {
		CriteriaBuilder cb = createCriteriaQuery();
		CriteriaQuery<NonProgressiveJournalMaster> cq = cb.createQuery(NonProgressiveJournalMaster.class);
		Root<NonProgressiveJournalMaster> root = cq.from(NonProgressiveJournalMaster.class);
		cq.select(root);
		cq.where(cb.equal(root.get("projectMasterId"),projectMasterId));
		cq.orderBy(cb.desc(root.get("projectMasterId")));
		return (ArrayList<NonProgressiveJournalMaster>) getSession().createQuery(cq).getResultList();
	}

}
