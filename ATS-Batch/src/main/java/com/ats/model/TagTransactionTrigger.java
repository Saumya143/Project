package com.ats.model;

import lombok.Data;

@Data
public class TagTransactionTrigger {
	
	private int txId;
	private int tagId;
	private int veclRegNo;
	private int tollPlazaId;
	private int tollAmt;
	private String txStatus;


}
