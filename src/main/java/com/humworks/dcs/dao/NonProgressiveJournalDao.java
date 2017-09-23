package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.NonProgressiveJournalMaster;

public interface NonProgressiveJournalDao {
	
	Long saveNonProgressive(NonProgressiveJournalMaster nonProgressive);
	
	Integer updateNonProgressive(NonProgressiveJournalMaster nonProgressive);
		
	void deleteNonProgressive(NonProgressiveJournalMaster nonProgressive);
	
	NonProgressiveJournalMaster findById(Long npid);
     
	NonProgressiveJournalMaster findByName(String nonProgressiveName, Long projrctMasterId);
    
    ArrayList<NonProgressiveJournalMaster> selectAll();
    
    ArrayList<NonProgressiveJournalMaster> findByProjectId(Long projectMasterId);
    
    ArrayList<NonProgressiveJournalMaster> findByIds(ArrayList<Long> idx);
    
    void transactionRollback();

}
