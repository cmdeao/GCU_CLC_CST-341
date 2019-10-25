package com.gcu.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.gcu.model.Product;
import com.gcu.model.User;

public class DataService implements DataAccessInterface<Object>
{

	@Autowired
	public List<Product> displayAll() 
	{
		List<Product> musicList = new ArrayList<Product>();
		Connection newConn = null;
		newConn = connect();
		String queryStatement = "SELECT * FROM app.music";
		
		try 
		{
			Statement state = newConn.createStatement();
			ResultSet rs = state.executeQuery(queryStatement);
			while(rs.next())
			{
				Product currentProduct = new Product();
				currentProduct.setSongName(rs.getString(1));
				currentProduct.setArtistName(rs.getString(2));
				currentProduct.setAlbumName(rs.getString(3));
				currentProduct.setSongLength(rs.getFloat(4));
				currentProduct.setSongGenre(rs.getString(5));
				musicList.add(currentProduct);
			}
			rs.close();
			newConn.close();
			System.out.println("Retrieved all the music data from the DB");
		}
		catch (SQLException e)
		{
			System.out.println("Failed retrieving music data.");
			e.printStackTrace();
		}
		return musicList;
	}

	@Override
	public void createUser(Object t) 
	{
		User addedUser = new User();
		addedUser = (User) t;
		Connection newConnection = null;
		newConnection = connect();
		String query = "INSERT INTO app.users (firstname, lastname, emailaddress, phonenumber, username, password) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = newConnection.prepareStatement(query);
			ps.setString(1, addedUser.getFirstName());
			ps.setString(2, addedUser.getLastName());
			ps.setString(3, addedUser.getEmailAddress());
			ps.setInt(4, addedUser.getPhoneNumber());
			ps.setString(5, addedUser.getUsername());
			ps.setString(6, addedUser.getPassword());
			ps.executeUpdate();
			newConnection.close();
		} catch (SQLException e) {
			System.out.println("Failed to insert user into the database!");
			e.printStackTrace();
		}
	}

	@Override
	public void createMusic(Object t) 
	{
		Product newProduct = new Product();
		newProduct = (Product) t;
		Connection newConn = null;
		newConn = connect();
		String query = "INSERT INTO app.music (songName, artistName, albumName, songLength, songGenre) VALUES (?,?,?,?,?)";
		PreparedStatement ps = null;
		
		try {
			ps = newConn.prepareStatement(query);
			ps.setString(1, newProduct.getSongName());
			ps.setString(2, newProduct.getArtistName());
			ps.setString(3, newProduct.getAlbumName());
			ps.setFloat(4, newProduct.getSongLength());
			ps.setString(5, newProduct.getSongGenre());
			ps.executeUpdate();
			newConn.close();
		}catch (SQLException e) {
			System.out.println("Failed to insert song");
			e.printStackTrace();
		}
	}

	@Override
	public void login(String username, String password) 
	{
		//Create a connection to the server. (Call the connect method)/
		//Iterate through the database and add all the users and passwords to a list.
		//Iterate through the list to find a match for both of the passed strings.
		//Possibly change this method return from "void" into a "bool".
		//Remove the code in LoginController to find a match. Call this method
		//from within LoginController. 
		//Redirect to the appropriate page based on the bool.
	}

	public Connection connect() 
	{	
		Connection conn = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			System.out.println("Passed first exception");
		}
		catch(ClassNotFoundException e){
			System.out.println("Failed first exception");
		}
		String url = "jdbc:derby://localhost:1527/MusicManagementCLC";
		String uName = "user";
		String password = "clcmusic";
		
		try {
			conn = DriverManager.getConnection(url, uName, password);
		} catch (SQLException e) {
			System.out.println("Failed");
			e.printStackTrace();
		}
		return conn;
	}
}
