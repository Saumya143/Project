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

@Entity
@Table(name="TAG_MASTER")
@Data
public class TagMasterEntity {
	
	@Id
	@GeneratedValue(generator = "TagGen",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "TagGen_SEQ",allocationSize = 1, name = "TagGen")
	@Column(name="TAG_SEQ")
	private Long tagSeq;	
	
	@Column(name="TAG_ID")
	private Long tagId;
	
	@Column(length = 7,name = "VHCL_REG_NUM")
	private String vhclRegNum;
	
	@Column(length = 15,name="VEHICLE_TYPE")
	private String vhclType;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TAG_START_DT")
	private Date tagStartDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TAG_EXPIRY_DT")
	private Date tagExpDate;
	
	@Column(name = "TAG_BAL")
	private Double tagBal;
	
	@Column(name="USER_ID")
	private Long userId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DT")
	@CreationTimestamp
	private Date createDt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DT")
	@UpdateTimestamp
	private Date updateDt;
	
	@Column(name="CREATE_By")
	private String createBy;
	
	@Column(name="UPDATE_BY")
	private String updateBy;
}
