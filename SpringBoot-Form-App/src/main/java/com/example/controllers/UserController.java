package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.UserEntity;
import com.example.pojo.User;
import com.example.repositary.UserMasterRepositary;

@Controller
public class UserController {
	Integer curentpage=0;
	 
	@Autowired
	UserMasterRepositary userMasterRepo;

	
	@RequestMapping(value = "/registerUser")
	public String loadForm(Model model) {
		User userObj = new User();// form binding obj
		model.addAttribute("user", userObj);// storing in model
		return "userReg";// logical view name
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, Model model) {
		System.out.println(user);
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);

		UserEntity saveEntity = userMasterRepo.save(entity);
		// logic to store in db
		if (saveEntity.getUserId() != null) {
			model.addAttribute("succMsg", "Registration Successfull");
		} else {
			model.addAttribute("failureMsg", "Registration failure");
		}

		return "userReg";// logical view name
	}

	@RequestMapping(value = "/viewUser")
	public String showData(Model model,@RequestParam("pn") Integer currPage) {
		
		Integer pageSize=3;
		curentpage=currPage;
		
		PageRequest page = PageRequest.of(currPage-1, pageSize);
		
		  Page<UserEntity> pageEntity =userMasterRepo.findAll(page);
		  List<UserEntity> userEntity=pageEntity.getContent();
		  int totalPage=pageEntity.getTotalPages();
		 
		  model.addAttribute("tp",totalPage);
		  model.addAttribute("cp", currPage);
		  System.out.println(totalPage);
		  
		List<User> userList = new ArrayList();
		for (UserEntity entity : userEntity) {
			User user = new User();
			BeanUtils.copyProperties(entity, user);
			userList.add(user);
		}
		model.addAttribute("userList", userList);

		return "show_view";
	}

	@RequestMapping(value = "/deleteUser")
	public String deleteUserById(Integer userId) {
		userMasterRepo.deleteById(userId);
		return "redirect:viewUser?pn="+1+"";
	}

	@RequestMapping(value="/edituser")
	public String editUser(Model model ,@RequestParam("userId") Integer userId,@ModelAttribute("user") User user) {
		Optional<UserEntity> optionalEntity = userMasterRepo.findById(userId);
		
		if(optionalEntity.isPresent()){
			UserEntity userEntity = optionalEntity.get();
			//User user=new User();
			BeanUtils.copyProperties(userEntity, user);
			model.addAttribute("editUser", userEntity.getUserId());
			System.out.println(curentpage);
			model.addAttribute("cp",curentpage);
		}
		//loadForm(model);
		return"editUser";
	}
	
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") User user,Model model,@RequestParam("userId") Integer userId) {
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(user, entity);
		entity.setUserId(userId);
		userMasterRepo.save(entity);
		model.addAttribute("succMsg", "Update sucessful");
		loadForm(model);
		
		return "userReg";
	}
	
	
	@RequestMapping("/allEmailId")
	public @ResponseBody List<String> findAllEmailId(){
		
		return userMasterRepo.findAllEmailId();
		
	}
 
	/*
	 * @RequestMapping("/emailById") public @ResponseBody List<String>
	 * findEmailById(@RequestParam("uid") Integer userId){
	 * 
	 * return userMasterRepo.findEmailById(userId);
	 * 
	 * }
	 */
}
