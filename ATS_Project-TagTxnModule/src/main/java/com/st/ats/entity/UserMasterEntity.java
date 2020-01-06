package com.st.ats.entity;

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
/**
 * this is Entity class for ats user which is bind repository to send data in database
 * 
 * @author Rituraj
 *
 */
@Data
@Entity
@Table(name="USER_MASTER")
public class UserMasterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Ats_id_gen")
	@SequenceGenerator(name ="Ats_id_gen",allocationSize =1,sequenceName = "ATS_USER_SEQ")
	@Column(name="USER_ID")
	private Long userId;
	
	@Column(name="First_NAME",length = 50)
	private String fname;
	
	@Column(name="Last_Name",length = 50)
	private String lname;
	
	@Column(name="EMAIL_ID",length = 50)
	private String email;
	
	@Column(name="gender",length = 10)
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
	private Date  dob;
	
	@Column(name="MOBLIE_NUM")
	private Long phno;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_DT")
	@CreationTimestamp
	private Date createDate;
	
	@UpdateTimestamp
	@Column(name="Update_DT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@Column(name="Created_BY")
	private String createdBY;

	@Column(name="UPDATED_BY")
	private String updatedBy;
	
}
