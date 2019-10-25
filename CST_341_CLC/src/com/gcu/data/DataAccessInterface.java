package com.gcu.data;

import java.util.List;

import com.gcu.model.Product;

public interface DataAccessInterface <T>
{
	public List<Product> displayAll();
	public void createUser(T t);
	public void createMusic(T t);
	public void login(String username, String password);
}
