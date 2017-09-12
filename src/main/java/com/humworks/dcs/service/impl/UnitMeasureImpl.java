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
public class UnitMeasureImpl implements UnitMeasureService {
	
	@Autowired
	private UnitMeasureDao unitMeasureDao;
	
	@Autowired
	private SessionService sessionService;

	public void setUnitMeasureDao(UnitMeasureDao unitMeasureDao) {
		this.unitMeasureDao = unitMeasureDao;
	}

	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}

	@Override
	@Transactional
	public Integer save(UnitMeasure uom) {
		Integer currentUser = sessionService.getActiveUid();
		uom.setIntCreatedBy(currentUser);
		uom.setIntModifiedBy(currentUser);
		uom.setStatus(1);
		return unitMeasureDao.saveUnitMeasure(uom);

	}

	@Override
	@Transactional
	public Integer update(UnitMeasure uom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void delete(UnitMeasure uom) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(readOnly = true)
	public UnitMeasure findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public UnitMeasure findByName(String uomLabel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ArrayList<UnitMeasure> selectAll() {
		return unitMeasureDao.selectAll();
	}

}
