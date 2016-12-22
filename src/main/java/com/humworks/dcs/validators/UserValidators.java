package com.humworks.dcs.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.humworks.dcs.entities.User;
import com.humworks.dcs.service.UserService;

@Component
public class UserValidators implements Validator {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> arg0) {
			return User.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		 User user = (User) arg0;
		 
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "intRoleId", "intRoleId.NotEmpty");
		 if (userService.findByUsername(user.getStrUserName()) != null) {
	            errors.rejectValue("strUserName", "username.exist");
	        }
		
	}

}
