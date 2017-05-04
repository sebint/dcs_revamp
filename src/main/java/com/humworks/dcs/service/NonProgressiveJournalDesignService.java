package com.humworks.dcs.service;

import java.util.ArrayList;

import com.humworks.dcs.entities.NonProgressiveJournalDesign;

public interface NonProgressiveJournalDesignService {

	Integer save(NonProgressiveJournalDesign nonProgressive);
	
	Integer update(NonProgressiveJournalDesign nonProgressive);
	
	void delete(NonProgressiveJournalDesign nonProgressive);
	
	NonProgressiveJournalDesign findById(Integer id);
    
	NonProgressiveJournalDesign findByName(String projectName, Integer projectMasterId);
    
    ArrayList<NonProgressiveJournalDesign> selectAll();

    ArrayList<NonProgressiveJournalDesign> findByJournalId(Integer projectMasterId);

	ArrayList<Long> selectUnique();
}
