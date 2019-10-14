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
		if(binding.hasErrors())
		{
			return "registerUser";
		}
		//This checks if we have the right class for the Derby DB.
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			System.out.println("Passed first exception");
		}
		catch(ClassNotFoundException e){
			System.out.println("Failed first exception");
		}
		//DO NOT CHANGE THESE STRINGS!!!
		String url = "jdbc:derby://localhost:1527/MusicManagementCLC";
		String uName = "user";
		String password = "clcmusic";
		//USE A DIFFERENT STRING TO RETURN A DIFFERENT PAGE WHEN THE REGISTARTION IS COMPLETE
		String userDB = "login";
		//Exception handling for inputting a user into the UserDB.
		try {
			Connection conn = DriverManager.getConnection(url, uName, password);
			String firstName = user.getFirstName();
			String lastName = user.getLastName();
			String email = user.getEmailAddress();
			int phone = user.getPhoneNumber();
			String username = user.getUsername();
			String userpass = user.getPassword();
			String query = "INSERT INTO app.users (firstname, lastname, emailaddress, phonenumber, username, password) VALUES (?,?,?,?,?,?)";
			PreparedStatement prepStatement = null;
			prepStatement = conn.prepareStatement(query);
			prepStatement.setString(1, firstName);
			prepStatement.setString(2, lastName);
			prepStatement.setString(3, email);
			prepStatement.setInt(4, phone);
			prepStatement.setString(5, username);
			prepStatement.setString(6, userpass);
			prepStatement.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Failed");
			e.printStackTrace();
		}
		return userDB;
	}
}