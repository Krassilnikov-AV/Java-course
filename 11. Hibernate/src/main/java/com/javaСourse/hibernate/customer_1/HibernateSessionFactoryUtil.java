package com.javaСourse.hibernate.customer_1;

import com.javaСourse.hibernate.customer.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {

	public static final SessionFactory sessionFactory = getSessionFactory();

	public static SessionFactory sessionFactoryUtil = getSessionFactory();

	public static final SessionFactory getSessionFactory() {
		try {
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(Customer.class);
			configuration.addAnnotatedClass(Product.class);
			configuration.addAnnotatedClass(CustomerProduct.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
			return configuration.buildSessionFactory(builder.build());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}