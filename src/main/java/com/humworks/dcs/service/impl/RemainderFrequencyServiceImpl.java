package com.humworks.dcs.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.RemainderFrequecyDao;
import com.humworks.dcs.entities.RemainderFrequency;
import com.humworks.dcs.service.RemainderFrequencyService;

@Service("frequencyService")
@Transactional
public class RemainderFrequencyServiceImpl implements RemainderFrequencyService {

	@Autowired
	private RemainderFrequecyDao frequencyDao;
	
	@Override
	public ArrayList<RemainderFrequency> selectAll() {
		return frequencyDao.selectAll();
	}

}
