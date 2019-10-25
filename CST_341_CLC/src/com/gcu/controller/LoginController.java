package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.gcu.data.DataService;
import com.gcu.model.Login;

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
		DataService service = new DataService();
		if(service.login(login.getUsername(), login.getPassword()))
		{
			returnPage = "main";
		}
		else
		{
			returnPage = "login";
		}
		return returnPage;
	}
}
