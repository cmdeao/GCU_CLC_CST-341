package com.gcu.controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.data.DataService;
import com.gcu.model.Product;

@Controller
@RequestMapping("/user")
public class MainController {
	
	DataService ds = new DataService();
	List<Product> musicList = new ArrayList<Product>();
	
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
		ds.createMusic(product);
		musicList = ds.displayAll();
		model.addAttribute("list", musicList);
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
	public String viewMusic(@ModelAttribute("product") Product product, Model model)
	{
		//List<Product> musicList = new ArrayList<Product>();
		musicList = ds.displayAll();
		model.addAttribute("list", musicList);
		return "viewMusic";
	}
}
