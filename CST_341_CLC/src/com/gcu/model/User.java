package com.gcu.model;

import com.gcu.business.RegistrationInterface;

public class User implements RegistrationInterface{

	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void init()
	{
		System.out.println("User INIT method!");
	}
	
	public void destroy()
	{
		System.out.println("User DESTROY method!");
	}
			
	
	private String lastName;
	private String emailAddress;
	private int phoneNumber;
	private String username;
	private String password;
}
