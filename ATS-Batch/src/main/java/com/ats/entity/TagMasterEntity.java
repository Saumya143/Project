package com.ats.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="TAG_MASTER")
@IdClass(TagMasterEntityPK.class)
public class TagMasterEntity {

	@Id
	@Column(name="TAG_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Tag_Master")
	@SequenceGenerator(name ="Tag_Master",allocationSize =1,initialValue =101,sequenceName = "TAG_MASTER_SEQ")
	private Integer tagId;
	@Column(name="VECL_REGNO")
	private Integer  veclRegNo;
	@Column(name="VECL_TYPE",length = 20)
	private String veclType;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TAG_START_DATE")
	private Date tagStartDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TAG_END_DATE")
	private Date tagEndDate;
	@Column(name="TAG_BAL")
	private Float tagBal;
	@Id
	private Integer userId;
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
