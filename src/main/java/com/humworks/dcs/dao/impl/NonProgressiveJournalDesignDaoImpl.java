package com.humworks.dcs.dao.impl;

import java.util.ArrayList;

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
	public Integer updateNonProgressive(NonProgressiveJournalDesign nonProgressive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNonProgressive(NonProgressiveJournalDesign nonProgressive) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NonProgressiveJournalDesign> findByProjectId(Integer projectMasterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transactionRollback() {
		// TODO Auto-generated method stub

	}

}
