package com.javaСourse.hibernate.customer;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class MainClassCustomer {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Customer.class)
			.addAnnotatedClass(Product.class)
			.addAnnotatedClass(Order.class)
			.addAnnotatedClass(OrderKey.class)
			.buildSessionFactory();
//CRUD
		Session session = null;

		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter command: ");
			while (sc.hasNext()) {
				String command = sc.nextLine();
				if (command.equals("exit")) {
					break;
				}
				String[] commandParts = command.split(" ");

//	/buy Customer_1 Product_1
				switch (commandParts[0]) {
//================== занесение нового клиента в БД ============
					case ("/newCustomer"):
						session = factory.getCurrentSession();
						Customer customer = new Customer();
						customer.setName("Ляпис Ряпис");
						session.beginTransaction();
						session.save(customer);
						session.getTransaction().commit();
						break;
//================== занесение нового прожукта в БД ============
					case ("/newProduct"):
						session = factory.getCurrentSession();
						Product product = new Product();
						product.setTitle("пельмени");
						product.setCost(305.23);
						session.beginTransaction();
						session.save(product);
						session.getTransaction().commit();
						break;
//================== занесение списка покупок в БД таблица customer_product============
					case ("/buy"):
						session=factory.getCurrentSession();

						break;
//================== /showProductsByPerson - просмотр покупок клиента из БД ============
					case ("/showProductsByPerson"):
						session = factory.getCurrentSession();
						Customer buyCustomer = session.get(Customer.class, 2L);
//						session
						Product buyProduct = session.get(Product.class, 1L);

						break;
					default:
						break;
//						System.out.println("/buy");
//						session = factory.getCurrentSession();
//						session.beginTransaction();
//
//						Customer customer = (Customer) session
//						.createQuery("FROM customers c WHERE c.name = :name")
//						.setParameter("name", commandParts[1]).getSingleResult();
//						Product product = (Product) session
//							.createQuery("FROM products p WHERE p.name = :name")
//							.setParameter("name", commandParts[2]).getSingleResult();
//
//						OrderKey orderKey = new OrderKey();
//						orderKey.setCustomerId(customer.getId());
//						orderKey.setProductId(product.getId());
//
//						Order order=new Order();
//						order.setOrderKey(orderKey);
//						order.setPrice(order.getPrice());
//
//						session.save(order);
//
//						session.getTransaction().commit();
//						System.out.println("Saved the next order: "+ order.toString());
//						System.out.println("Enter new command: ");
//						break;
				}
			}
		} finally {
			factory.close();
			session.close();
		}
	}
}