package com.humworks.dcs.service;

import java.util.ArrayList;

import com.humworks.dcs.entities.UnitMeasure;

public interface UnitMeasureService {

	Long save(UnitMeasure uom);
	
	Integer update(UnitMeasure uom);    
	
	void delete(UnitMeasure uom);
	
	UnitMeasure findById(Integer id);
        
    UnitMeasure findByName(String uomLabel);
    
    ArrayList<UnitMeasure> selectAll();
	
}
