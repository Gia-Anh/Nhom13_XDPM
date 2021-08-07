package com.xdpm.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.xdpm.entity.Customer;

public class CustomerDAO extends AbstractCRUD<Customer> {

	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
		Query query = entityManager.createQuery("from Customer where enabled = true", Customer.class);
		return query.getResultList();
	}

	public Customer getCustomerByID(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		if (customer != null && customer.isEnabled()) {
			return customer;
		}
		return null;
	}

	public void deleteCustomer(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		customer.setEnabled(false);
		update(customer);
	}

	@Override
	public Customer update(Customer t) {
		Customer customer = entityManager.find(Customer.class, t.getId());
		customer.setName(t.getName());
		customer.setAddress(t.getAddress());
		customer.setPhoneNumber(t.getPhoneNumber());
		return super.update(customer);
	}

	public boolean addCustomer(Customer t) {
		EntityTransaction transaction = entityManager.getTransaction();
		t.setEnabled(true);
		try {
			transaction.begin();
			entityManager.persist(t);
			entityManager.flush();
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return false;
	}

	@Override
	public Customer add(Customer t) {
		t.setEnabled(true);
		return super.add(t);
	}

}
