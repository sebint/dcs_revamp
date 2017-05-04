package com.humworks.dcs.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.NonProgressiveJournalDesignDao;
import com.humworks.dcs.entities.NonProgressiveJournalDesign;
import com.humworks.dcs.service.NonProgressiveJournalDesignService;
import com.humworks.dcs.service.SessionService;

@Service("nonProgressiveJournalDesignService")
@Transactional
public class NonProgressiveJournalDesignServiceImpl implements NonProgressiveJournalDesignService {

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private NonProgressiveJournalDesignDao nonProgressiveDesignDao;
	
	@Override
	public Integer save(NonProgressiveJournalDesign nonProgressive) {
		Integer currentUser = sessionService.getActiveUid();
		nonProgressive.setIntCreatedBy(currentUser);
		nonProgressive.setIntModifiedBy(currentUser);
		nonProgressive.setStatus(1);
		return nonProgressiveDesignDao.saveNonProgressive(nonProgressive);
	}

	@Override
	public Integer update(NonProgressiveJournalDesign nonProgressive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(NonProgressiveJournalDesign nonProgressive) {
		// TODO Auto-generated method stub

	}

	@Override
	public NonProgressiveJournalDesign findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NonProgressiveJournalDesign findByName(String projectName, Integer projectMasterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NonProgressiveJournalDesign> selectAll() {
		return nonProgressiveDesignDao.selectAll();
	}
	
	@Override
	public ArrayList<Long> selectUnique(){
		return nonProgressiveDesignDao.selectUnique();
	}

	@Override
	public ArrayList<NonProgressiveJournalDesign> findByJournalId(Integer journalMasterId) {
		// TODO Auto-generated method stub
		return nonProgressiveDesignDao.findByJournalId(journalMasterId);
	}

}
