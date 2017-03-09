package com.humworks.dcs.service.impl;

import com.humworks.dcs.service.EncryptionService;

public class EncryptionServiceImpl implements EncryptionService {

	@Override
	public Long encrypt(Long value) {
		Long appendedValue = Long.parseLong("43"+(Long.toString(value)));
		return (value * appendedValue);
	}

	@Override
	public Long decrypt(Long cypher) {
		// TODO Auto-generated method stub
		return null;
	}

}
