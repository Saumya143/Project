package com.usa.restController;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usa.bo.VeichleRegistrationBO;
import com.usa.dto.VeichleRegistrationDTO;
import com.usa.entity.VeichleRegDetailsEntity;
import com.usa.repositary.VeichleRegRepositary;

@RestController
public class VeichleRegIdRestController {

	@Autowired
	VeichleRegRepositary veichleRegRepositary;
	
	
	@GetMapping(value="/get/{ownerId}",produces = {"application/json","application/xml"})
	public VeichleRegistrationBO getVeichleRegId(@RequestParam("ownerId") int ownerId)
	
	{
		Optional<VeichleRegDetailsEntity> optional = veichleRegRepositary.findById(ownerId);
		VeichleRegistrationBO veclBO=new VeichleRegistrationBO();
		VeichleRegDetailsEntity entity=optional.get();
		BeanUtils.copyProperties(entity,veclBO );
		System.out.println(veclBO);
		return veclBO;
	}
}
