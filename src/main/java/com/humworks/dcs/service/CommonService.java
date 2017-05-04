package com.humworks.dcs.service;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.humworks.dcs.entities.JsonDesignRequest;

public interface CommonService {
	
	Integer getPatternFromUrl(String pattern);
	
	Integer getIdFromUrl(String url);
	
	String getNameFromUrl(String url);
	
	String arrayListtoJson(ArrayList<JsonDesignRequest> list) throws JsonProcessingException;

}
