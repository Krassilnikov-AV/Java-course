package com.javaСourse.hibernate.customer;


import com.javaСourse.hibernate.library.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainClassCustomer {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Book.class)
			.addAnnotatedClass(Author.class)
			.addAnnotatedClass(Reader.class)
			.addAnnotatedClass(Catalog.class)
			.buildSessionFactory();
//CRUD
		Session session = null;

		try {

		} finally {
			factory.close();
			session.close();
		}
	}
}