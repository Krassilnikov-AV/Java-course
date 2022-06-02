package com.javaСourse.hibernate.customer_1;


import org.hibernate.*;

import javax.persistence.NoResultException;

public class ProductDAO {

	private SessionFactory sessionFactory=HibernateSessionFactoryUtil.sessionFactory;

	public Product findByName(String name) throws NoResultException {
		try (Session currentSession = sessionFactory.openSession()) {
			String query = "FROM Product p WHERE p.name = :name";
			return (Product) currentSession.createQuery(query).setParameter("name", name)
				.getSingleResult();
		}
	}


	public void save(Product entity) {
		try (Session currentSession = sessionFactory.openSession()) {
			Transaction transaction = currentSession.beginTransaction();
			currentSession.save(entity);
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