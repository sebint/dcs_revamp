package com.humworks.dcs.service;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.humworks.dcs.entities.JsonDesignRequest;

public interface CommonService {
	
	Long getPatternFromUrl(String pattern);
	
	Long getIdFromUrl(String url);
	
	String getNameFromUrl(String url);
	
	String arrayListtoJson(ArrayList<JsonDesignRequest> list) throws JsonProcessingException;

}
