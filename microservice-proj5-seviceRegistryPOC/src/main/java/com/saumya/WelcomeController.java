
package com.saumya;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	
	@GetMapping("/welcome")
	public String welcome( ) {
	//String WELCOME="welcome to microservice";
		return ", welcome to microservice";
	}

}
