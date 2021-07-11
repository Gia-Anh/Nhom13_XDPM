package com.xdpm.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RentalRecord_PK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6552172749567280305L;
	
	private int disk;
	private int customer;
	
	public RentalRecord_PK() {
	}

	public RentalRecord_PK(int disk, int customer) {
		super();
		this.disk = disk;
		this.customer = customer;
	}

	public int getDisk() {
		return disk;
	}

	public void setDisk(int disk) {
		this.disk = disk;
	}

	public int getCustomer() {
		return customer;
	}

	public void setCustomer(int customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customer;
		result = prime * result + disk;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentalRecord_PK other = (RentalRecord_PK) obj;
		if (customer != other.customer)
			return false;
		if (disk != other.disk)
			return false;
		return true;
	}
	
	
}
