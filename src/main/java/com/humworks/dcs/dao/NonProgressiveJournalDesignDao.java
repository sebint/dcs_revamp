package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.NonProgressiveJournalDesign;

public interface NonProgressiveJournalDesignDao {

	Integer saveNonProgressive(NonProgressiveJournalDesign nonProgressive);
	
	Integer updateNonProgressive(NonProgressiveJournalDesign nonProgressive);
		
	void deleteNonProgressive(NonProgressiveJournalDesign nonProgressive);
	
	NonProgressiveJournalDesign findById(Integer npid);
     
	NonProgressiveJournalDesign findByName(String nonProgressiveName, Integer projrctMasterId);
    
    ArrayList<NonProgressiveJournalDesign> selectAll();
    
    ArrayList<NonProgressiveJournalDesign> findByProjectId(Integer projectMasterId);
    
    void transactionRollback();
}
