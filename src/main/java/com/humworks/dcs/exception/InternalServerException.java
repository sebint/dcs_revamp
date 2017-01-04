package com.humworks.dcs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)//500
public class InternalServerException extends Exception {

	private static final long serialVersionUID = -1977080548192986599L;

	public InternalServerException(Exception ex){
		super("Internal Server Error "+ex);
	}
}
