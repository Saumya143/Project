package com.example.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class User {
    
	private Integer userId;
	private String username;
	private String password;
	private String email;
	private Long phno;
	
}
