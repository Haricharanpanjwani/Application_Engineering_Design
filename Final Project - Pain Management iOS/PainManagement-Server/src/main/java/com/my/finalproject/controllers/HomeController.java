package com.my.finalproject.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String home(){
		
		return "home";
	}
	
}
