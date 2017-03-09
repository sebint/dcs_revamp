package com.humworks.dcs.service;

public interface EncryptionService {
	
	Long encrypt(Long value);
	
	Long decrypt(Long cypher);	
	
}
