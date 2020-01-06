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
@Table(name="TAG_TX_TRIGGER")
@Data
public class TagTxnTriggerEntity {

	@Id
	@GeneratedValue(generator = "TXN_SEQ",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="TXN_SEQ",sequenceName = "TXN_NO_SEQ",allocationSize = 1,initialValue = 10000001)
	@Column(name="TRG_ID ")
	private Long trgId;

	
	@Column(name="TAG_ID")
	private Long tagId;
	
	
	@Column(name="TOLL_PLAZA_ID")
	private String tollPlazaId;
	
	@Column(length = 7,name = "VHCL_REG_NUM")
	private String vhclRegNum;
	
	@Column(name="TOLL_AMT")
	private Double tollAmt;
	
	@Column(name = "TX_STATUS")
	private String txStatus;
	
	@Column(name="TX_FAILURE_RSN")
	private String txFailureRsn;
	
 	@Column(name="REMAINDER_MSG_SW")
	private String remMsgSwitch;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DT")
	@CreationTimestamp
	private Date createDt;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DT")
	@UpdateTimestamp
	private Date updateDt;


	@Column(name="CREATE_BY")
	private String createBy;
	
	@Column(name="UPDATE_BY")
	private String updateBy;

}

