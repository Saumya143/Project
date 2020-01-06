package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bo.UserBO;


@Controller
public class MainController {
	
	public MainController() {
		System.out.println("****MainController.MainController()***");
	}
	
	@RequestMapping(value = "/registrationurl",method = RequestMethod.GET)
	public String createFrom(Model model) {
		UserBO bo=null;
		bo=new UserBO();
		model.addAttribute("userDetails", bo);
		return "userRegd";
		
	}

}
