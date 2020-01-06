package com.usa.dto;

import lombok.Data;

@Data
public class VeichleOwnerAddresDTO {
	
	private Integer houseNo;
	private String streetName;
	private String city;
	private Long zipCode;
}
