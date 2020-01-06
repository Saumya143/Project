package com.st.ats.model;

import java.util.Date;


import lombok.Data;

@Data
public class TagMaster {

	private Long tagSeq;

	private Long tagId;

	private String vhclRegNum;

	private String vhclType;

	private Date tagStartDate;

	private Date tagExpDate;

	private Double tagBal;

	private Long userId;

	private String createBy;

	private String updateBy;
}
