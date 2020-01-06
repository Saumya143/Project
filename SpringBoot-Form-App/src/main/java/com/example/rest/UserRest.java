package com.example.rest;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.UserEntity;
import com.example.pojo.User;
import com.example.repositary.UserMasterRepositary;

@RestController
public class UserRest {

	@Autowired
	UserMasterRepositary userMasterRepo;
	 
	@GetMapping(value="/get",produces = {"application/json","application/xml"})
	public User getUserById(@RequestParam("uid") Integer userId) {
		Optional<UserEntity> optional = userMasterRepo.findById(userId);
		User user=new User();
		UserEntity entity = optional.get();
		BeanUtils.copyProperties(entity, user);
		return user;
	}
}
