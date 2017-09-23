package com.humworks.dcs.service;

public interface SessionService {

	Long getActiveUid();
	
	String getActiveUsername();
	
	String getActiveFullName();
}
