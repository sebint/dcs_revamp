package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.NonProgressiveJournalDesign;

public interface NonProgressiveJournalDesignDao {

	Integer saveNonProgressive(NonProgressiveJournalDesign nonProgressive);
	
	Integer updateDesign(NonProgressiveJournalDesign nonProgressive);
		
	void deleteDesign(NonProgressiveJournalDesign nonProgressive);
	
	NonProgressiveJournalDesign findById(Integer npid);
     
	NonProgressiveJournalDesign findByName(String nonProgressiveName, Integer projrctMasterId);
    
    ArrayList<NonProgressiveJournalDesign> selectAll();
    
    ArrayList<Long> selectUnique();
    
    ArrayList<NonProgressiveJournalDesign> findByJournalId(Integer projectMasterId);
    
    void transactionRollback();
}
