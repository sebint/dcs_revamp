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
public class ObjectServiceImpl implements ObjectService {

	@Autowired
	private ObjectsDao objectDao;	
	
	public void setObjectDao(ObjectsDao objectDao) {
		this.objectDao = objectDao;
	}

	@Override
	@Transactional(readOnly = true)
	public ArrayList<Objects> selectAll() {			
		 return objectDao.selectAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ArrayList<ObjectsMaster> findParentMenu() {
//		System.out.println(objectDao.getParentMenu());
		return objectDao.getParentMenu();
	}


}
