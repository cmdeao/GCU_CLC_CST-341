package com.gcu.model;

import com.gcu.business.LoginInterface;

public class Login implements LoginInterface{

	private String username = null;
	private String password = null;
	
	public void init()
	{
		System.out.println("LOGIN INIT METHOD");
	}
	
	public void destroy()
	{
		System.out.println("LOGIN DESTROY METHOD");	
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getUsername()
	{
		return username;
	}
}
