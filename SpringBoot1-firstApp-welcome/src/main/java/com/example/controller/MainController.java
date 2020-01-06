package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	public MainController() {
		System.out.println("MainController.MainController(--)");
	}

	@RequestMapping(value = "/welcome")
	public String welcomeMsg(Model model) {
		String msgtxt="Good Morning";
		model.addAttribute("msg",msgtxt);
		return "welcome";
	}
	
	@RequestMapping(value = "/greet ")
	public String welcomeMsg1(Model model) {
		String msgtxt="Good Afternoon";
		model.addAttribute("msg",msgtxt);
		return "welcome";
	}
}
