package com.humworks.dcs.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.humworks.dcs.entities.Login;
import com.humworks.dcs.service.UserService;

@Component
public class PasswordResetValidators implements Validator {
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> user) {
		return Login.class.equals(user);
	}

	@Override
	public void validate(Object user, Errors errors) {
		Login login = (Login) user;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "strPassword", "strPassword.NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "strConfirmPassword", "strConfirmPassword.NotEmpty");
		
		if(!login.getStrPassword().equals(login.getStrConfirmPassword())){
			errors.rejectValue("strConfirmPassword", "passwords.not.match");
		}
	}
	
	public void currentValidate(Object user, Errors errors){
		Login login = (Login) user;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "strConfirmPassword", "strConfirmPassword.NotEmpty");
		
		if(!login.getStrPassword().equals(login.getStrConfirmPassword())){
			errors.rejectValue("strConfirmPassword", "passwords.not.match");
		}
		
		if(!userService.checkPassword(login.getIntUserId(), login.getStrExPassword())){
			errors.rejectValue("strExPassword", "invalid.current.password");
		}
	}

}
