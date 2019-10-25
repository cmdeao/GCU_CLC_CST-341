package com.gcu.business;

public interface RegistrationInterface 
{
	public void setFirstName(String firstName);
	public void setLastName(String lastName);
	public void setEmailAddress(String emailAddress);
	public void setPhoneNumber(int phoneNumber);
	public void setUsername(String username);
	public void setPassword(String password);
	public String getFirstName();
	public String getLastName();
	public String getEmailAddress();
	public int getPhoneNumber();
	public String getUsername();
	public String getPassword();
	
	public void init();
	public void destroy();
}
