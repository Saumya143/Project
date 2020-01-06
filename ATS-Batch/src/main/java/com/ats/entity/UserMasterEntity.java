package com.ats.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="USER_MASTER")
public class UserMasterEntity {
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "User_Master")
	@SequenceGenerator(name ="User_Master",allocationSize =1,initialValue =101,sequenceName = "USER_MASTER_SEQ")
	private Integer userId;
	
	@Column(name="FIRST_NAME",length = 30)
	private String firstName;
	@Column(name="LAST_NAME",length = 30)
	private String lastName;
	@Column(name="EMAIL",length = 40)
	private String email;
	@Column(name="MOBILE_NO",length = 10)
	private Long mobileNo;
	@Column(name="GENDER",length = 10)
	private String gender;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	@CreationTimestamp
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE")
	@UpdateTimestamp
	private Date updateDate;
	@Column(name="CREATE_DATE")
	private String createdBy;
	@Column(name="UPDATE_DATE")
	private String updatedBy;


}
