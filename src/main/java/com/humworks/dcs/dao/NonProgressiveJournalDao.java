package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.NonProgressiveJournalMaster;

public interface NonProgressiveJournalDao {
	
	Integer saveNonProgressive(NonProgressiveJournalMaster nonProgressive);
	
	Integer updateNonProgressive(NonProgressiveJournalMaster nonProgressive);
		
	void deleteNonProgressive(NonProgressiveJournalMaster nonProgressive);
	
	NonProgressiveJournalMaster findById(Integer npid);
     
	NonProgressiveJournalMaster findByName(String nonProgressiveName);
    
    ArrayList<NonProgressiveJournalMaster> selectAll();
    
    void transactionRollback();

}
