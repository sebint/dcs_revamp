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
public class NonProgressiveJournalServiceImpl implements NonProgressiveJournalService {
	
	@Autowired
	private NonProgressiveJournalDao nonProgressiveDao;
	
	@Autowired
	private SessionService sessionService;

	public void setNonProgressiveDao(NonProgressiveJournalDao nonProgressiveDao) {
		this.nonProgressiveDao = nonProgressiveDao;
	}

	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}

	@Override
	@Transactional
	public Integer save(NonProgressiveJournalMaster nonProgressive) {
		Integer currentUser = sessionService.getActiveUid();
		nonProgressive.setIntCreatedBy(currentUser);
		nonProgressive.setIntModifiedBy(currentUser);
		nonProgressive.setStatus(1);
		return nonProgressiveDao.saveNonProgressive(nonProgressive);
	}

	@Override
	@Transactional
	public Integer update(NonProgressiveJournalMaster nonProgressive) {
		try{
			   Integer currentUser = sessionService.getActiveUid();
			   nonProgressive.setIntModifiedBy(currentUser);
			   nonProgressive.setStatus(1);
			   if(nonProgressiveDao.updateNonProgressive(nonProgressive)>0){
			    	   return 1;
			   }
//			   userDao.transactionRollback();
			   return 0;
			}catch(Exception ex){
				ex.printStackTrace();
				return 0;
			}
	}

	@Override
	@Transactional
	public void delete(NonProgressiveJournalMaster nonProgressive) {
		nonProgressiveDao.deleteNonProgressive(nonProgressive);

	}

	@Override
	@Transactional(readOnly = true)
	public NonProgressiveJournalMaster findById(Integer id) {
		return nonProgressiveDao.findById(id); 
	}

	@Override
	@Transactional(readOnly = true)
	public NonProgressiveJournalMaster findByName(String journalName, Integer projectMasterId) {
		return nonProgressiveDao.findByName(journalName.replace('-', ' ').toLowerCase(), projectMasterId);
	}

	@Override
	@Transactional(readOnly = true)
	public ArrayList<NonProgressiveJournalMaster> selectAll() {
		return nonProgressiveDao.selectAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ArrayList<NonProgressiveJournalMaster> findByProjectId(Integer projectMasterId) {
		return nonProgressiveDao.findByProjectId(projectMasterId);
	}

	@Override
	@Transactional(readOnly = true)
	public ArrayList<NonProgressiveJournalMaster> findByIds(ArrayList<Long> idx) {
		return nonProgressiveDao.findByIds(idx);
	}

}
