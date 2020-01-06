package com.usa.compositeKey;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class CompositeKey implements Serializable {
	
	 private int veichleRegId;
	 private String veichleRegNo;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeKey other = (CompositeKey) obj;
		if (veichleRegId != other.veichleRegId)
			return false;
		if (veichleRegNo == null) {
			if (other.veichleRegNo != null)
				return false;
		} else if (!veichleRegNo.equals(other.veichleRegNo))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + veichleRegId;
		result = prime * result + ((veichleRegNo == null) ? 0 : veichleRegNo.hashCode());
		return result;
	}
	 
	 
	
	 
}
