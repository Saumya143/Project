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

import io.micrometer.core.annotation.Counted;
import lombok.Data;

@Data
@Entity
@Table(name="TAG_TRANSACTION_TRIGGER")
@IdClass(TagTransactionTriggerEntityPK.class)
public class TagTransactionTriggerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Tag_tx_trigger")
	@SequenceGenerator(name ="Tag_tx_trigger",allocationSize =1,initialValue =101,sequenceName = "TAG_TRANSACTION_SEQ")
    @Column(name="TX_ID")
	private Integer txId;
	@Id
	@Column(name="TAG_ID")
	private Integer tagId;
	@Column(name="VECL_REG_NO")
	private Integer veclRegNo;
	@Id
	@Column(name="TOLLPLAZA_ID")
	private Integer tollPlazaId;
	@Column(name="TOLL_AMT")
	private Integer tollAmt;
	@Column(name="TX_STATUS")
	private String txStatus;
	@Column(name="TAG_START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tagStartDate;
	@Column(name="TAG_END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tagEndDate;
	@Column(name="CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	@Column(name="UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date updateDate;
	@Column(name="CREATE_BY")
	private String createdBy;
	@Column(name="UPDATE_BY")
	private String updatedBy;
	
	
}
