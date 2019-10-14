package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String addMusic()
	{
		return "addMusic";
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
