package com.usa.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.usa.compositeKey.CompositeKey;
import com.usa.coustomerGenerator.RegistrationNumberGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "VEICHLE_REG_DTLS")
@IdClass(CompositeKey.class)
public class VeichleRegDetailsEntity {
	
	@Id
	@GeneratedValue(generator = "reg_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "reg_sequence", allocationSize = 1, sequenceName = "VECL_REG_SEQ_VCLE")
	@Column(name = "VIECHLE_REG_ID")
	private int veichleRegId;
	@Id
	@GeneratedValue(generator = "reg_sequence", strategy = GenerationType.SEQUENCE)
	@GenericGenerator(name = "reg_sequence",strategy = "com.usa.coustomerGenerator.RegistrationNumberGenerator", parameters = {
			@Parameter(name = RegistrationNumberGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = RegistrationNumberGenerator.VALUE_PREFIX_PARAMETER, value = "OR_"),
			@Parameter(name = RegistrationNumberGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	
	@SequenceGenerator(name = "reg_sequence", allocationSize = 1, sequenceName = "VECL_REG_NO_SEQ_VCLE")
	@Column(name = "VEICHLE_REG_NO")
	private String veichleRegNo;
	@Column(name = "REG_DATE")
	@Temporal(TemporalType.DATE)
	private Date regDate;
	@Column(name = "REG_CENTER")
	private String regCenter;
	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	private LocalDateTime createDate;
	@Column(name = "UPDATE_DATE")
	@CreationTimestamp
	private LocalDateTime updateDate;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VIECHLE_OWNER_ID", referencedColumnName = "VIECHLE_OWNER_ID")
	private VeichleOwnerDetailsEntity veichlOwnerId;
	

}
