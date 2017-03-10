package com.humworks.dcs.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.UnitMeasureDao;
import com.humworks.dcs.entities.UnitMeasure;

@Repository("unitMeasureDao")
public class UnitMeasureDaoImpl implements UnitMeasureDao {

	@Override
	public Integer saveUnitMeasure(UnitMeasure uom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateUnitMeasure(UnitMeasure uom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUnitMeasure(UnitMeasure user) {
		// TODO Auto-generated method stub

	}

	@Override
	public UnitMeasure findById(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitMeasure findByName(String uomLabel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UnitMeasure> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transactionRollback() {
		// TODO Auto-generated method stub

	}

}
