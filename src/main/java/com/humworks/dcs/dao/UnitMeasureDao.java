package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.UnitMeasure;

public interface UnitMeasureDao {
	
	Long saveUnitMeasure(UnitMeasure uom);
	
	Integer updateUnitMeasure(UnitMeasure uom);
	
	void deleteUnitMeasure(UnitMeasure user);    
	
	UnitMeasure findById(Integer uid);
     
	UnitMeasure findByName(String uomLabel);
    
    ArrayList<UnitMeasure> selectAll();
    
    void transactionRollback();
}
