package com.humworks.dcs.service;

import java.util.ArrayList;

import com.humworks.dcs.entities.Objects;
import com.humworks.dcs.entities.ObjectsMaster;

public interface ObjectService {
	
	ArrayList<Objects> selectAll();
	
	ArrayList<ObjectsMaster> findParentMenu();
}
