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

@Data
@Entity
@Table(name="BATCH_RUN_DTLS")
public class BatchRunDtlsEntity {
	
	@Id
	@GeneratedValue(generator = "BATCH_RUN_SEQ",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="BATCH_RUN_SEQ",sequenceName = "BATCH_RUN_SEQ",allocationSize = 1)
	@Column(name="RUN_ID ")
	private Long runId;
	
	@Column(name="BATCH_NAME")
	private String batchName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="START_DT")
	private Date startDt;
	
	@Column(name="RUN_STATUS")
	private String runStatus;
	
	@Temporal(TemporalType.DATE)
	@Column(name="END_DT")
	private Date  endDt;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DT")
	private Date createDt;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DT")
	private Date updateDt;
	
	@Column(name="CREATE_BY")
	private String createBy;
	
	@Column(name="UPDATE_BY")
	private String updatedBy;
}
