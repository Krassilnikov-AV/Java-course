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
}