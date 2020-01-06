package com.st.ats.model;


import lombok.Data;

@Data
public class TagTxnTrigger {

	private Long trgId;

	private Long TagId;

	private String tollPlazaId;

	private String vhclRegNum;

	private Double tollAmt;

	private String txStatus;

	private String txFailureRsn;

	private Character remMsgSwitch;

	private String createBy;

	private String updateBy;

}
