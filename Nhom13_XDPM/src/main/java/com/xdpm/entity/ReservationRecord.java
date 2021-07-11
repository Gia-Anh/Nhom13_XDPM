package com.xdpm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ReservationRecord_PK.class)
public class ReservationRecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6529419403185446230L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "titleID")
	private Title title;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "customerID")
	private Customer customer;
	
	private Date orderDate;
	
	public ReservationRecord() {
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
}
