package com.humworks.dcs.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.UnitMeasureDao;
import com.humworks.dcs.entities.UnitMeasure;
import com.humworks.dcs.service.SessionService;
import com.humworks.dcs.service.UnitMeasureService;

@Service("unitMeasureService")
@Transactional
public class UnitMeasureImpl implements UnitMeasureService {
	
	@Autowired
	private UnitMeasureDao unitMeasureDao;
	
	@Autowired
	private SessionService sessionService;

	@Override
	public Integer save(UnitMeasure uom) {
		Integer currentUser = sessionService.getActiveUid();
		uom.setIntCreatedBy(currentUser);
		uom.setIntModifiedBy(currentUser);
		uom.setStatus(1);
		return unitMeasureDao.saveUnitMeasure(uom);

	}

	@Override
	public Integer update(UnitMeasure uom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UnitMeasure uom) {
		// TODO Auto-generated method stub

	}

	@Override
	public UnitMeasure findById(Integer id) {
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
		return unitMeasureDao.selectAll();
	}

}
