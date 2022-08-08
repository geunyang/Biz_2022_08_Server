package com.callor.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "",method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/guest",method=RequestMethod.GET)
	public String guest() {
		
		return null;
		
	}
	
	@RequestMapping(value="/403",method=RequestMethod.GET)
	public String error403() {
		return "error/403";
	}
	
	
}
