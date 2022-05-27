package com.javaСourse.hibernate.library;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class MainClass {
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
//========== занести имя читателя =====================
//			session = factory.getCurrentSession();
//			Author author=new Author();
//			author.setName("Евгений");
//			session.beginTransaction();
//			session.save(author);
//			session.getTransaction().commit();
//			==========================
// заполнение таблицы books_readers
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Reader reader = session.get(Reader.class, 2);
//			Book book=session.get(Book.class, 2);
//			reader.getBooks().add(book);
//			session.getTransaction().commit();
//===================
//			CREATE  запрос выполняет ORM
//=============== занести название каталога ==================
//			session = factory.getCurrentSession();
//			Catalog catalog = new Catalog("Fantasy #15");
//			session.beginTransaction();
//			session.save(catalog);
//			session.getTransaction().commit();
//====================================================
//			READ
//============= чтение списка каталога ================
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Catalog catalog2 = session.get(Catalog.class, 2L);
//			session.getTransaction().commit();
//			System.out.println(catalog2);

//          UPDATE  обновление выполняет ORM
//=====================
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Book bookJava1 = session.get(Book.class, 1L);
//			bookJava1.getTitle("potters_1*");
//			session.getTransaction().commit();
//			System.out.println(bookJava1);

//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Catalog catalog2 = session.get(Catalog.class, 3L);
//			session.detach(catalog2); //отвязать объект от контекста
//			session.remove(catalog2);  // удаление объекта
//			session.merge(catalog2); // выполнит возврат если не закомичн удаленый объект
//			session.persist(catalog2);   // добавление объекта к контексту
//			catalog2.setTitle("Fantasy #8");
//			session.getTransaction().commit();
//			System.out.println(catalog2);


		} finally {
			factory.close();
			session.close();
		}
	}
}