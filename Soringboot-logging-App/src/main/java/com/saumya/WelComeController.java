package com.saumya;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelComeController {

	
	private static final Logger logger=org.slf4j.LoggerFactory.getLogger(WelComeController.class);
	@GetMapping("/getMsg")
	public String getMsg() {
		logger.info("message started");
		String msg="welcome to logging application";
		logger.info("message endded");
		return msg;
	}
}
