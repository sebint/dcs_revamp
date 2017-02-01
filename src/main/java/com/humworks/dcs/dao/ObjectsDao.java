package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.Objects;
import com.humworks.dcs.entities.ObjectsMaster;

public interface ObjectsDao {
	
	ArrayList<Objects> selectAll();
	
	ArrayList<ObjectsMaster> getParentMenu();
}
