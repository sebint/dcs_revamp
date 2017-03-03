package com.humworks.dcs.service;

import java.util.ArrayList;

import com.humworks.dcs.entities.NonProgressiveJournalMaster;

public interface NonProgressiveJournalService {

	Integer save(NonProgressiveJournalMaster nonProgressive);
	
	Integer update(NonProgressiveJournalMaster nonProgressive);
	
	void delete(NonProgressiveJournalMaster nonProgressive);
	
	NonProgressiveJournalMaster findById(Integer id);
    
	NonProgressiveJournalMaster findByName(String projectName);
    
    ArrayList<NonProgressiveJournalMaster> selectAll();
}
