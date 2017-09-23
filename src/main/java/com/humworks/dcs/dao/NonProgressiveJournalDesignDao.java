package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.NonProgressiveJournalDesign;

public interface NonProgressiveJournalDesignDao {

	Long saveNonProgressive(NonProgressiveJournalDesign nonProgressive);
	
	Integer updateDesign(NonProgressiveJournalDesign nonProgressive);
		
	void deleteDesign(NonProgressiveJournalDesign nonProgressive);
	
	NonProgressiveJournalDesign findById(Long npid);
     
	NonProgressiveJournalDesign findByName(String nonProgressiveName, Long projrctMasterId);
    
    ArrayList<NonProgressiveJournalDesign> selectAll();
    
    ArrayList<Long> selectUnique();
    
    ArrayList<NonProgressiveJournalDesign> findByJournalId(Long projectMasterId);
    
    void transactionRollback();
}
