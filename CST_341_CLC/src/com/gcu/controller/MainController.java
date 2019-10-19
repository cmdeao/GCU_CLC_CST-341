package com.gcu.controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.model.Product;

@Controller
@RequestMapping("/user")
public class MainController {
	
	@RequestMapping(path = "/news", method = RequestMethod.GET)
	public String showcaseNews()
	{
		return "news";
	}
	
	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public String showcaseContact()
	{
		return "contact";
	}
	
	@RequestMapping(path ="/about", method = RequestMethod.GET)
	public String showcaseAbout()
	{
		return "about";
	}
	
	@RequestMapping(path = "/main", method = RequestMethod.GET)
	public String showcaseHome()
	{
		return "main";
	}
	
	@RequestMapping(path = "/addMusic", method = RequestMethod.GET)
	public ModelAndView addMusic()
	{
		return new ModelAndView("addMusic", "product", new Product());
	}
	
	@RequestMapping(path = "/added", method = RequestMethod.POST)
	public String addMusicToDB(@ModelAttribute("product") Product product, BindingResult binding, Model model)
	{
		try 
		{
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		}catch(ClassNotFoundException e)
		{
			System.out.println("Failed first exception!" + e);
		}
		
		String dbURL = "jdbc:derby://localhost:1527/MusicManagementCLC";
		String dbUser = "user";
		String dbPassword = "clcmusic";
		
		try {
			Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			String songName = product.getSongName();
			String bandName = product.getArtistName();
			String albumName = product.getAlbumName();
			float songLength = product.getSongLength();
			String songGenre = product.getSongGenre();
			
			String query = "INSERT INTO app.music (songName, artistName, albumName, songLength, songGenre) VALUES (?,?,?,?,?)";
			PreparedStatement prepState = null;
			prepState = conn.prepareStatement(query);
			prepState.setString(1, songName);
			prepState.setString(2, bandName);
			prepState.setString(3, albumName);
			prepState.setFloat(4, songLength);
			prepState.setString(5, songGenre);
			prepState.executeUpdate();
			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return "viewMusic";
	}
	
	@RequestMapping(path = "/removeMusic", method = RequestMethod.GET)
	public String removeMusic()
	{
		return "removeMusic";
	}
	
	@RequestMapping(path = "/createPlaylist", method = RequestMethod.GET)
	public String createPlaylist()
	{
		return "createPlaylist";
	}
	
	@RequestMapping(path = "/viewMusic", method = RequestMethod.GET)
	public String viewMusic()
	{
		return "viewMusic";
	}
}
