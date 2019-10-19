package com.gcu.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.Login;

import java.sql.Connection;

@Controller
@RequestMapping("/user")
public class LoginController 
{	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin()
	{
		return new ModelAndView("login", "login", new Login());
	}
	
	@RequestMapping(path = "/main", method = RequestMethod.POST)
	public String loggedApplication(@ModelAttribute("user") @Validated Login login, BindingResult binding, Model model)
	{
		String returnPage = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		}catch(ClassNotFoundException e){
			System.out.println("Login Controller failed first Exception");
		}
		String url = "jdbc:derby://localhost:1527/MusicManagementCLC";
		String uName = "user";
		String password = "clcmusic";
		String inputUser = login.getUsername();
		String inputPass = login.getPassword();
		if(inputUser.isEmpty() || inputPass.isEmpty())
		{
			System.out.println("NOTHING IN A FIELD");
			returnPage = "login";
			return returnPage;
		}
		try {
			Connection conn = DriverManager.getConnection(url, uName, password);
			System.out.println("Login Connection Was Successful");
			String query = "SELECT * FROM app.users";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				if(rs.getString("username").equals(inputUser) && rs.getString("password").equals(inputPass))
				{
					System.out.println("We have a match!");
					returnPage = "main";
				}
				else
				{
					System.out.println("FAILED LOGIN");
					returnPage = "login";
				}
			}
		}catch(SQLException e){
			System.out.println("Login Connection Failed!");
			e.printStackTrace();
		}
		return returnPage;
	}
}
