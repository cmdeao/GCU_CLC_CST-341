package com.gcu.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.data.DataService;
import com.gcu.model.User;

@Controller
@RequestMapping("/user")
public class RegistrationController {
	
	//The next two methods are required to validate the user input
	//during registration.
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(validator);
	}
	
	//The base page for registering a user.
	@RequestMapping(path ="/register", method = RequestMethod.GET)
	public ModelAndView displayRegistration()
	{
		return new ModelAndView("registerUser", "user", new User());
	}
	
	//CHANGE THIS PATH TO SEE A DIFFERENT PAGE WHEN AN ACCOUNT IS REGISTERED!
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String showcaseRegistartionDB(@ModelAttribute("user") @Validated User user, BindingResult binding, Model model)
	{
		DataService testing = new DataService();
		if(binding.hasErrors())
		{
			return "registerUser";
		}
		testing.createUser(user);
		String userDB;
		userDB = "login";
		return userDB;
	}
}