
package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WelcomeController {
	
	
	@GetMapping("/welcome/{name}")
	public String welcome(@PathVariable("name") String name ) {
	//String WELCOME="welcome to microservice";
		return name+", welcome to project batch";
	}

}
