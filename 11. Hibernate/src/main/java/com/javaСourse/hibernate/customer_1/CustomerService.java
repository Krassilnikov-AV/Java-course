package com.javaСourse.hibernate.customer_1;


import javax.persistence.NoResultException;

public class CustomerService {

	private CustomerDAO customerDAO = new CustomerDAO();

	public Customer_1 findByName(String name) throws NoResultException {
		return customerDAO.findByName(name);
	}

	public void save(Customer_1 entity) {
		customerDAO.save(entity);
	}

	public Customer_1 findByID(Long id) {
		return customerDAO.findByID(id);
	}

	public void update(Customer_1 entity) {
		customerDAO.update(entity);
	}

}