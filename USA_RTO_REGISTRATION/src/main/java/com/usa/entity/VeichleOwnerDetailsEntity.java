package com.usa.entity;



import java.time.LocalDateTime;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "VIECHLE_OWNER_DTLS")
public class VeichleOwnerDetailsEntity {

	@Id
	@GeneratedValue(generator = "user_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "user_sequence", allocationSize = 1, sequenceName = "SEQUENCE_VEICHLE")
	@Column(name = "VIECHLE_OWNER_ID")
	private int veichleOwnerId;
	
	@Column(name = "FIRST_NAME" ,length=15)
	//@NotEmpty(message = "Enter the first name")
	private String firstName;
	@Column(name = "LAST_NAME",length = 10)
	//@NotEmpty(message = "Enter the last name")
	private String lastName;
	//@NotEmpty(message = "gender must not be empty")
	@Column(name = "GENDER",length = 6)
	private String gender;
	//@NotEmpty(message = "Enter the email id")
	@Column(name = "EMAIL",length = 30 )
	@Email
	private String email;
	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	//@NotEmpty(message = "Enter your date if birth")
	private Date dob;
	@Column(name = "PHNO")
	//@Size(max = 10,min = 10)
	private Long phnNo;
	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	//@NotEmpty(message = "Enter the created date")
	private LocalDateTime createDate;
	@Column(name = "UPDATE_DATE")
	@CreationTimestamp
	//@NotEmpty(message = "Enter the updated date")
	private LocalDateTime updateDate;

}
