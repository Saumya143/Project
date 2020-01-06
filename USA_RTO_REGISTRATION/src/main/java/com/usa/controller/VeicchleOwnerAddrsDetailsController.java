package com.usa.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usa.bo.VeichleOwnerAddresBO;
import com.usa.dto.VeichleDetailsDTO;
import com.usa.dto.VeichleOwnerAddresDTO;
import com.usa.service.VeichleOwnerService;

@Controller
public class VeicchleOwnerAddrsDetailsController {
	@Autowired
	VeichleOwnerService service;
	
	/*
	 * @RequestMapping(value = "/ownerAddress") public String
	 * showFrom(@ModelAttribute("ownerAdrsDtls") VeichleOwnerAddresDTO
	 * veichleOwnerAddresDetails) { return"veichleOwnerAddrs"; }
	 */
	
	@RequestMapping(value = "/registrationAddrs/{ownerId}",method = RequestMethod.POST)
	public String ownerAddressDetails(@PathVariable("ownerId") Integer ownerId,Model model,@ModelAttribute("ownerAdrsDtls") VeichleOwnerAddresDTO veichleOwnerAddresDetails,@ModelAttribute("veclDetails") VeichleDetailsDTO veichleDetails) {
		System.out.println("VeichleOwnerController.ownerFormDetails()");
		VeichleOwnerAddresBO bo=null;
		bo=new VeichleOwnerAddresBO();
		BeanUtils.copyProperties(veichleOwnerAddresDetails, bo);
		try {
			int insertOwnerAddress = service.insertOwnerAddress(bo,ownerId);
			model.addAttribute("insertOwnerAddress", insertOwnerAddress);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "veichleDetails";
	} 


}
