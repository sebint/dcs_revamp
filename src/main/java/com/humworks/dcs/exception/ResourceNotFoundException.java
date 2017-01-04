package com.humworks.dcs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)//404
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 6416852572106118119L;
	
	public ResourceNotFoundException(String resource){
		super("Resource not found Exception with "+resource);
	}

}
