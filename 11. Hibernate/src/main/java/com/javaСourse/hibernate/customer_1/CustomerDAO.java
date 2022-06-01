package com.javaСourse.hibernate.customer_1;

import com.javaСourse.hibernate.customer.Customer;
import org.hibernate.*;

import javax.persistence.NoResultException;

public class CustomerDAO {

	private SessionFactory sessionFactory = HibernateSessionFactoryUtil
		.sessionFactoryUtil;

	public Customer findByName(String name) throws NoResultException {
		try (Session currentSession = sessionFactory.openSession()) {
			String query = "FROM Customer c WHERE c.name = :name";
			return (Customer) currentSession.createQuery(query).setParameter("name", name)
				.getSingleResult();
		}
	}

	public void save(Product product) {
		try (Session currentSession = sessionFactory.openSession()) {
			Transaction transaction = currentSession.beginTransaction();
			currentSession.save(product);
			transaction.commit();
		}
	}

	public Product findByID(Long id) {
		try (Session currentSession = sessionFactory.openSession()) {
			Transaction transaction = currentSession.beginTransaction();
			Product entity =currentSession.get(Product.class, id);
			transaction.commit();
			return entity;
		}
	}

	public void update(Product product) {
		try (Session currentSession = sessionFactory.openSession()) {
			Transaction transaction = currentSession.beginTransaction();
			currentSession.update(product);
			transaction.commit();
		}
	}

	public void buyProduct(Customer_1 customer_1, Product product) {
		try (Session currentSession = sessionFactory.openSession()) {
			Transaction transaction = currentSession.beginTransaction();
			CustomerProduct cp = new CustomerProduct(customer_1, product);
			currentSession.save(cp);
			transaction.commit();
		}
	}
}