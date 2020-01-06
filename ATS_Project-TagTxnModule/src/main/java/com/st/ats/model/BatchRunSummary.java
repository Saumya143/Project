package com.st.ats.model;


import lombok.Data;

@Data
public class BatchRunSummary {

	private Long summaryId;

	private String batchName;

	private String summaryDtls;

	private String createBy;

	private String updateBy;
}
