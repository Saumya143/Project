package com.usa.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usa.bo.VeichleDetailsBO;
import com.usa.dto.VeichleDetailsDTO;
import com.usa.dto.VeichleRegistrationDTO;
import com.usa.service.VeichleOwnerService;

@Controller
public class VeichleDtlsController {
	@Autowired
	VeichleOwnerService service;
	
	
	/*
	 * @RequestMapping(value = "/veclDtls") public String
	 * showFrom(@ModelAttribute("veclDetails") VeichleDetailsDTO veichleDetails) {
	 * return"veichleDetails"; }
	 */
	
	@RequestMapping(value = "/veclForm/{ownerId}",method = RequestMethod.POST)
	public String veichleFormDetails(Model model,@PathVariable("ownerId") Integer ownerId,@ModelAttribute("veclDetails") VeichleDetailsDTO veichleDetails,@ModelAttribute("veclReg") VeichleRegistrationDTO veclDTO) {
		System.out.println("VeichleOwnerController.ownerFormDetails()");
		VeichleDetailsBO bo=null;
		bo=new VeichleDetailsBO();
		BeanUtils.copyProperties(veichleDetails, bo);
		try {
			int insertVeichleDetails = service.insertVeichleDetails(bo, ownerId);
			model.addAttribute("insertVeichleDetails", insertVeichleDetails);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "veichleRegistartionDetails";
	} 


}
