package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.Objects;

public interface ObjectsDao {
	
	ArrayList<Objects> selectAll();
}
