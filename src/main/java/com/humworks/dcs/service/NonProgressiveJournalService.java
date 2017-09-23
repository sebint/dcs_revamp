package com.humworks.dcs.service;

import java.util.ArrayList;

import com.humworks.dcs.entities.NonProgressiveJournalMaster;

public interface NonProgressiveJournalService {

	Long save(NonProgressiveJournalMaster nonProgressive);
	
	Integer update(NonProgressiveJournalMaster nonProgressive);
	
	void delete(NonProgressiveJournalMaster nonProgressive);
	
	NonProgressiveJournalMaster findById(Long id);
	
	ArrayList<NonProgressiveJournalMaster> findByIds(ArrayList<Long> idx);
    
	NonProgressiveJournalMaster findByName(String projectName, Long projectMasterId);
    
    ArrayList<NonProgressiveJournalMaster> selectAll();

    ArrayList<NonProgressiveJournalMaster> findByProjectId(Long projectMasterId);
}
