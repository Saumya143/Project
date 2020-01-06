package com.ats.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class TagMasterEntityPK implements Serializable {
	private Integer tagId;
	
	private Integer userId;

}
