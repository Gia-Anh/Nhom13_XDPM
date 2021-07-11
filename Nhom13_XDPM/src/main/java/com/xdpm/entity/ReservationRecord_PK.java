package com.xdpm.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ReservationRecord_PK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2214643202335894045L;

	private int title;
	private int customer;
	
	public ReservationRecord_PK() {
	}

	public ReservationRecord_PK(int title, int customer) {
		super();
		this.title = title;
		this.customer = customer;
	}

	public int getTitle() {
		return title;
	}

	public void setTitle(int title) {
		this.title = title;
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
		result = prime * result + title;
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
		ReservationRecord_PK other = (ReservationRecord_PK) obj;
		if (customer != other.customer)
			return false;
		if (title != other.title)
			return false;
		return true;
	}
	
	
}
