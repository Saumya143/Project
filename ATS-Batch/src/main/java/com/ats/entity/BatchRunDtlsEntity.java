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
@Table(name="BATCH_RUN_DETLS")
public class BatchRunDtlsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Batch_Run_dtls")
	@SequenceGenerator(name ="Batch_Run_dtls",allocationSize =1,initialValue =101,sequenceName = "BATCH_DETLS_SEQ")
	@Column(name="RUN_ID")
	private int runId;
	@Column(name="BATCH_NAME",length = 30)
	private String batchName;
	@Column(name="RUN_STATUS",length = 30)
	private String runStatus;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_DATE")
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_DATE")
	private Date endDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	@CreationTimestamp
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE")
	@UpdateTimestamp
	private Date updateDate;
	@Column(name = "CREATE_BY",length = 30)
	private String createdBy;
	@Column(name = "UPDATE_BY",length = 30)
	private String updatedBy;
	
	


}
