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
import com.usa.bo.VeichleOwnerAddresBO;
import com.usa.bo.VeichleOwnerBO;
import com.usa.dto.VeichleDetailsDTO;
import com.usa.dto.VeichleOwnerAddresDTO;
import com.usa.dto.VeichleOwnerDTO;
import com.usa.dto.VeichleRegistrationDTO;
import com.usa.service.VeichleOwnerService;

@Controller
public class VeichleOwnerController {
	@Autowired
	VeichleOwnerService service;

	@RequestMapping(value = "/registrationForm")
	public String ownerFormDetails(@ModelAttribute("OwnerDetails") VeichleOwnerBO veichleOwnerDetails) {
		System.out.println("VeichleOwnerController.ownerFormDetails()");
		return "veichleOwner";
	} 
	@RequestMapping(value="/veclOnrReg",method = RequestMethod.POST )
	public String showFrom(Model model, @ModelAttribute("OwnerDetails") VeichleOwnerDTO dto,@ModelAttribute("ownerAdrsDtls") VeichleOwnerAddresDTO veichleOwnerAddresDetails) {
		System.out.println("VeichleOwnerController.showFrom()");
		VeichleOwnerBO bo=null;
		bo=new VeichleOwnerBO();
		BeanUtils.copyProperties(dto, bo);
		 try {
		 int insert = service.insert(bo);
		 model.addAttribute("ownerId",insert);
	
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		return"veichleOwnerAddrs";
	}

	@RequestMapping(value = "/edituser")
	public String editOwnerDetails(Model model,Integer veichleOwnerId,@ModelAttribute("OwnerDetails") VeichleOwnerBO veichleOwnerDetails) {
		   VeichleOwnerDTO dto=new VeichleOwnerDTO();
		   //use service
		   service.edit(veichleOwnerId);
		   BeanUtils.copyProperties(veichleOwnerDetails, dto);
		   model.addAttribute("OwnerDetails", dto);
		   //model.addAttribute("id",veichleOwnerId);
		return"veichleOwnerAddrs";
	}
	

	
	
}
