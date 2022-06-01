package com.javaСourse.hibernate.customer_1;

import com.javaСourse.hibernate.customer.Customer;

import javax.persistence.NoResultException;

public class ProductService {

	private CustomerDAO customerDAO = new CustomerDAO();

	public Customer findByName(String name) throws NoResultException {
		return customerDAO.findByName(name);
	}

	public void save(Customer_1 entity) {
		CustomerDAO.save(entity);
	}
}