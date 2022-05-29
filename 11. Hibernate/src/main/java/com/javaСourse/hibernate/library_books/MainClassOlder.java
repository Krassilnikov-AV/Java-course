package com.javaСourse.hibernate.library_books;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class MainClassOlder {
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
//================= занесение в таблицу authors данных =====================
//			session = factory.getCurrentSession();
//			Author author=new Author();
//			author.setName("Rowling");
//			session.beginTransaction();
//			session.save(author);
//			session.getTransaction().commit();
//================= занесение в таблицу books_readers данных =====================
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Reader reader = session.get(Reader.class, 3);
//			Book book = session.get(Book.class, 3);
//			reader.getBooks().add(book);
//			session.getTransaction().commit();
//================= занесение в таблицу catalogs нового каталога =====================
///** запрос у фабрики сессии*/
//			session = factory.getCurrentSession();
///** создание экземпляра класса каталог с требуемыми данными для занесения в таблицу*/
//			Catalog catalog = new Catalog("Fantasy #15");
///** начало управления транзакциями:
// * - начало танзакции */
//			session.beginTransaction();
///** - сохранение транзакции, при котором каталог попадает в таблицу*/
//			session.save(catalog);
///** - фиксация транзакции в БД*/
//			session.getTransaction().commit();

//			READ
//=============== чтение данных из таблиц БД ====================
			session = factory.getCurrentSession();
			session.beginTransaction();
/** получение названия указанного каталога*/
			Catalog catalog2 = session.get(Catalog.class, 2L);
			session.getTransaction().commit();
/** вывод запрошенных данных в консоли*/
			System.out.println(catalog2);
//================== обновление данных в таблицах БД =====================
//          UPDATE  обновление выполняет ORM

//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Book bookJava1 = session.get(Book.class, 1L);
//			bookJava1.getTitle("Java 1 Advenced");
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