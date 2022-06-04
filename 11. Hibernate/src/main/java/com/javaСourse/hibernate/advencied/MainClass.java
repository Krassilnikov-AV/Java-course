package com.javaСourse.hibernate.advencied;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.*;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) throws IOException {
//		prepareData();
		work();
	}

	public static void work() {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.buildSessionFactory();
		Session session = null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();
			Product product = session.get(Product.class, 1L);
			System.out.println(product);
			Customer customer = session.get(Customer.class, 1L);
			System.out.println(customer);
			Manufacturer manufacturer = session.get(Manufacturer.class, 1L);
			System.out.println(manufacturer);
			System.out.println("PRICE: " + manufacturer.avgProductsPrice);

			Product product1 = new Product();
			product1.setPrice(new BigDecimal(100));
			product1.setManufacturer(manufacturer);
			product1.setTitle("DemoTitle");
			session.save(product1);

			System.out.println("PRICE: " + manufacturer.avgProductsPrice);
			session.getTransaction().commit();
//			System.out.println(manufacturer.getProducts());
		} finally {
			factory.close();
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * - создание фабрики -> открытие файла с запросом по указанному пути ->
	 * -> получение стрима строк из файла -> собали коллектом и поставили пробелы м/д записями ->
	 * -> начало транзакции -> выполнили запрос -> commit и далее закрытие.
	 * ! - При каждом запуске перестраивается
	 */
	private static void prepareData() throws IOException {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.buildSessionFactory();

		Session session = null;
		try {
			String sql = Files.lines(Paths.get("drop-and-create.sql")).collect(Collectors.joining(" "));
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createNativeQuery(sql).executeUpdate();
			session.getTransaction().commit();
		} finally {
			factory.close();
			if (session != null) {
				session.close();
			}
		}
	}
}