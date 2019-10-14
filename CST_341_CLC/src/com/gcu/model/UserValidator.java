package com.gcu.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> valid) {
		
		return User.class.isAssignableFrom(valid);
	}

	@Override
	public void validate(Object arg0, Errors error) {
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "firstName", "required.firstName",
				"Please enter first name!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "lastName", "required.lastName",
				"Please enter last name!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "emailAddress", "required.emailAddress",
				"Please enter email address!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "phoneNumber", "required.phoneNumber",
				"Please enter phone number!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "username", "required.username",
				"Please enter username!");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "required.password",
				"Please enter password!");
	}
}
