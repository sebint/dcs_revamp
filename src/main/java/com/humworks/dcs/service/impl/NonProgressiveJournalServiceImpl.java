package com.humworks.dcs.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.NonProgressiveJournalDao;
import com.humworks.dcs.entities.NonProgressiveJournalMaster;
import com.humworks.dcs.service.NonProgressiveJournalService;
import com.humworks.dcs.service.SessionService;

@Service("nonProgressiveService")
@Transactional
public class NonProgressiveJournalServiceImpl implements NonProgressiveJournalService {
	
	@Autowired
	private NonProgressiveJournalDao nonProgressiveDao;
	
	@Autowired
	private SessionService sessionService;

	@Override
	public Integer save(NonProgressiveJournalMaster nonProgressive) {
		Integer currentUser = sessionService.getActiveUid();
		nonProgressive.setIntCreatedBy(currentUser);
		nonProgressive.setIntModifiedBy(currentUser);
		nonProgressive.setStatus(1);
		return nonProgressiveDao.saveNonProgressive(nonProgressive);
	}

	@Override
	public Integer update(NonProgressiveJournalMaster nonProgressive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(NonProgressiveJournalMaster nonProgressive) {
		// TODO Auto-generated method stub

	}

	@Override
	public NonProgressiveJournalMaster findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NonProgressiveJournalMaster findByName(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NonProgressiveJournalMaster> selectAll() {
		return nonProgressiveDao.selectAll();
	}

}
