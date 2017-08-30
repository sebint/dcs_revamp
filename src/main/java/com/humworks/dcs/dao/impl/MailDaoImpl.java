package com.humworks.dcs.dao.impl;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.MailDao;
import com.humworks.dcs.entities.Mail;

public class MailDaoImpl extends AbstractDao<Integer, Mail> implements MailDao {

	@Override
	public Mail sent(String from, String[] to, String subject, String msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
