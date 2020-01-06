package com.st.ats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.st.ats.constant.ATSConstants;
import com.st.ats.model.AtsUser;
import com.st.ats.properties.AppProperties;
import com.st.ats.service.AtsUserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	/**
	 * injecting service class object for performing business operations
	 */
	@Autowired
	private AtsUserService userService;
	/**
	 * inject temporary cache class object to get messages for response to user
	 */
	@Autowired
	private AppProperties prop;

	
	
	@RequestMapping("/index")
	public String loadRegPage(Model model) {
		model.addAttribute(ATSConstants.MODE_KEY_FOR_ATSUSER, new AtsUser());
		return ATSConstants.LOG_VIEW_FOR_ADMIN_REG;
	}
	
	@PostMapping("/register")
	public String handleRegisterBtn(@ModelAttribute("atsUserMod") AtsUser atsUser, RedirectAttributes attributes) throws Exception {
		userService.saveUserDtls(atsUser);
		attributes.addFlashAttribute(ATSConstants.MODE_KEY_FOR_SUCC_MSG,
				prop.getMessages().get(ATSConstants.MODE_KEY_FOR_SUCC_MSG));
		return ATSConstants.REDIRECT_VIEW_FOR_PRG_PATTERN;
	}

	@RequestMapping("/findUnlockUser")
	public String handleViewAdmin() {
		
		
		
		
		return ATSConstants.LOG_VIEW_FOR_ADMIN_LIST;
	}
	
	
	
}
