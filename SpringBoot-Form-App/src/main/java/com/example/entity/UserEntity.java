package com.example.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER_MASTER_TAB")
public class UserEntity {
	@Id
	@GeneratedValue
	//@SequenceGenerator(name = "user_sequence", allocationSize = 1,sequenceName = "SEQUENCE_USERS")
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="USER_NAME")
	private String username;
	
	@Column(name="USER_PWD")
	private String password;
	
	@Column(name="USER_EMAIL")
	private String email;
	
	@Column(name="USER_PHNO")
	private Long phno;
	

}
