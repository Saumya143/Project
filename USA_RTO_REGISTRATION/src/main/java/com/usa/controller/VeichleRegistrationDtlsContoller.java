package com.usa.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usa.bo.VeichleRegistrationBO;
import com.usa.dto.VeichleRegistrationDTO;
import com.usa.service.VeichleOwnerService;

@Controller
public class VeichleRegistrationDtlsContoller {
	@Autowired
	VeichleOwnerService service;
	
	@RequestMapping(value="/veclReg/{ownerId}",method = RequestMethod.POST)
	public String veichleRegistrationForm(Model model,@PathVariable("ownerId") Integer ownerId,@ModelAttribute("veclReg") VeichleRegistrationDTO veclReg)
	{
		System.out.println("VeichleRegistrationDtls.veichleRegistrationForm()");
		VeichleRegistrationBO bo=null;
		bo=new VeichleRegistrationBO();
		BeanUtils.copyProperties(veclReg, bo);
		try {
			int insertVeichleReg = service.insertVeichleReg(bo, ownerId);
			model.addAttribute("oenerID",insertVeichleReg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return"redirect:veclReg";
	}

}
