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
@Table(name="BATCH_RUN_SUMMARY")
public class BatchRunSummaryEntity {

	@Id
	@GeneratedValue(generator = "BatchSUMMRY",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "BATCH_SUMMRY_SEQ",allocationSize = 1, name = "BatchSUMMRY")
	@Column(name="SUMMARY_ID")
	private Long summaryId;
	
	@Column(name="BATCH_NAME")
	private String batchName;
	
	@Column(name="SUMMARY_DTLS")
	private String summaryDtls;

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
