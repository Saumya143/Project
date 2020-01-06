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
@Table(name="BATCH_RUN_SUMMERY")
public class BatchRunSummaryEntity {
	@Id
	@Column(name="BATCH_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Batch_summery")
	@SequenceGenerator(name ="Batch_summery",allocationSize =1,initialValue =101,sequenceName = "BATCH_RUN_SUMMERY")
	private int batchId;
	@Column(name="BATCH_NAME",length = 30)
	private String batchName;
	@Column(name="RUN_STATUS",length = 30)
	private String runStatus;
	@Column(name="CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	@Column(name="UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updateDate;
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="UPDATED_BY")
	private String updatedBy;

}
