package com.humworks.dcs.service;

import java.util.ArrayList;

import com.humworks.dcs.entities.NonProgressiveJournalDesign;

public interface NonProgressiveJournalDesignService {

	Long save(NonProgressiveJournalDesign nonProgressive);
	
	Integer update(NonProgressiveJournalDesign nonProgressive);
	
	void delete(NonProgressiveJournalDesign nonProgressive);
	
	NonProgressiveJournalDesign findById(Integer id);
    
	NonProgressiveJournalDesign findByName(String projectName, Integer projectMasterId);
    
    ArrayList<NonProgressiveJournalDesign> selectAll();

    ArrayList<NonProgressiveJournalDesign> findByJournalId(Long projectMasterId);

	ArrayList<Long> selectUnique();
}
