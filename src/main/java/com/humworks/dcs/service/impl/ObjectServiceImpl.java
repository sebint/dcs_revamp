package com.humworks.dcs.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.ObjectsDao;
import com.humworks.dcs.entities.Objects;
import com.humworks.dcs.entities.ObjectsMaster;
import com.humworks.dcs.service.ObjectService;

@Service("objectService")
@Transactional
public class ObjectServiceImpl implements ObjectService {

	@Autowired
	private ObjectsDao objectDao;
	
	@Override
	public ArrayList<Objects> selectAll() {			
		 return objectDao.selectAll();
	}

	@Override
	public ArrayList<ObjectsMaster> findParentMenu() {
//		System.out.println(objectDao.getParentMenu());
		return objectDao.getParentMenu();
	}


}
