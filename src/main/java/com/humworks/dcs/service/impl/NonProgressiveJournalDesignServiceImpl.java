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
public class NonProgressiveJournalDesignServiceImpl implements NonProgressiveJournalDesignService {

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private NonProgressiveJournalDesignDao nonProgressiveDesignDao;
	
	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}

	public void setNonProgressiveDesignDao(NonProgressiveJournalDesignDao nonProgressiveDesignDao) {
		this.nonProgressiveDesignDao = nonProgressiveDesignDao;
	}

	@Override
	@Transactional
	public Long save(NonProgressiveJournalDesign nonProgressive) {
		String currentUser = sessionService.getActiveFullName();
		nonProgressive.setIntCreatedBy(currentUser);
		nonProgressive.setIntModifiedBy(currentUser);
		nonProgressive.setStatus(1);
		return nonProgressiveDesignDao.saveNonProgressive(nonProgressive);
	}

	@Override
	@Transactional
	public Integer update(NonProgressiveJournalDesign nonProgressive) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void delete(NonProgressiveJournalDesign nonProgressive) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(readOnly = true)
	public NonProgressiveJournalDesign findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public NonProgressiveJournalDesign findByName(String projectName, Integer projectMasterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ArrayList<NonProgressiveJournalDesign> selectAll() {
		return nonProgressiveDesignDao.selectAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public ArrayList<Long> selectUnique(){
		return nonProgressiveDesignDao.selectUnique();
	}

	@Override
	@Transactional(readOnly = true)
	public ArrayList<NonProgressiveJournalDesign> findByJournalId(Long journalMasterId) {
		// TODO Auto-generated method stub
		return nonProgressiveDesignDao.findByJournalId(journalMasterId);
	}

}
