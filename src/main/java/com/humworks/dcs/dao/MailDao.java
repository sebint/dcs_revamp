package com.humworks.dcs.dao;

import com.humworks.dcs.entities.Mail;

public interface MailDao {
	
	Mail sent(String from, String[] to, String subject, String msg);

}
