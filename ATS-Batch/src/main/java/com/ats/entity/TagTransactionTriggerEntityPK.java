package com.ats.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class TagTransactionTriggerEntityPK implements Serializable {

	private int txId;
	private int tagId;
	private int tollPlazaId;
}
