package com.xdpm.dao;

import java.util.List;

import javax.persistence.Query;

import com.xdpm.entity.Customer;

public class CustomerDAO extends AbstractCRUD<Customer>{

	public List<Customer> getAllCustomer() {
		Query query = entityManager.createQuery("from Customer where enabled = true", Customer.class);
		return query.getResultList();
	}
	
	public Customer getCustomerByID(int id) {
		return entityManager.find(Customer.class, id);
	}
	
	public void deleteCustomer(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		customer.setEnabled(false);
		update(customer);
	}
	
	
}
