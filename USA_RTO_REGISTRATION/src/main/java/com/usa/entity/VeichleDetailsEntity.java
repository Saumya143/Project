package com.usa.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "VEICHLE_DTLS")
public class VeichleDetailsEntity {
	
	@Id
	@GeneratedValue(generator = "veichle_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "veichle_sequence", allocationSize = 1, sequenceName = "VEICHLE_SEQUENCE_ID_DETAILS")
	@Column(name = "VIECHLE_DETAILS_ID")
	private Integer veichleDetailsId;
	@Column(name = "VEICHLE_TYPE")
	private String veichleType;
	@Column(name = "MFG_YEAR")
	private Integer mfgYear;
	@Column(name = "VEICHLE_BRAND")
	private String veclBrand;
	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	private LocalDateTime createDate;
	@Column(name = "UPDATE_DATE")
	@CreationTimestamp
	private LocalDateTime uodateDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VIECHLE_OWNER_ID", referencedColumnName = "VIECHLE_OWNER_ID")
	private VeichleOwnerDetailsEntity veichlOwnerId;
	

}
