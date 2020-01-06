package com.ats.model;

import java.util.Date;

import lombok.Data;

@Data
public class BatchRunDtls {
	private int runId;
	private String batchName;
	private String runStatus;
	private Date startDate;
	private Date endDate;
	

}
