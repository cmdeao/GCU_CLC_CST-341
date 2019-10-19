package com.gcu.business;

public interface LoginInterface {

	public void setUsername(String username);
	public void setPassword(String password);
	public String getUsername();
	public String getPassword();
	public void init();
	public void destroy();
}
