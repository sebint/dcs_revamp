package com.humworks.dcs.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.humworks.dcs.entities.Login;

@Component
public class PasswordResetValidators implements Validator {

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

}
