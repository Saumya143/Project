package com.st.ats.model;

import java.util.Date;

import lombok.Data;

@Data
public class BatchRunDtls {

	private Long runId;

	private String batchName;

	private Date startDt;

	private String runStatus;

	private Date endDt;

	private String createBy;

	private String updatedBy;
}
