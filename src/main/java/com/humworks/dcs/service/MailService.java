package com.humworks.dcs.service;

import com.humworks.dcs.entities.Mail;

public interface MailService {
	
	Mail sentMail(String from, String[] to, String subject, String msg);

}
