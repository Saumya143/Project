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


@Entity
@Table(name = "VEICHLE_OWNER_ADDRESS_DTLS")
@Data
public class VeclOwnerAddressDtlsEntity {
	@Id
	@GeneratedValue(generator = "addrs_sequence", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "addrs_sequence", allocationSize = 1, sequenceName = "ADDRS_ID_SEQ")
	@Column(name = "ADDRESS_ID")
	private Integer addressId;

	@Column(name = "HNO")
	private Integer houseNo;
	@Column(name = "STREET_NAME")
	private String streetName;
	@Column(name = "CITY")
	private String city;
	@Column(name = "ZIP_CODE")
	private Long zipCode;
	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	private LocalDateTime createDate;
	@Column(name = "UPDATE_DATE")
	@CreationTimestamp
	private LocalDateTime updateDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VIECHLE_OWNER_ID", referencedColumnName = "VIECHLE_OWNER_ID")
	private VeichleOwnerDetailsEntity veichlOwnerId;

}
