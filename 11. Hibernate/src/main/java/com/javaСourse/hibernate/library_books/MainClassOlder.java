package com.javaСourse.hibernate.library_books;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

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
//			session = factory.getCurrentSession();
//			session.beginTransaction();
///** получение названия указанного каталога*/
//			Catalog catalog2 = session.get(Catalog.class, 2L);
//			session.getTransaction().commit();
///** вывод запрошенных данных в консоли*/
//			System.out.println(catalog2);
//================== обновление данных в таблицах БД =====================
//          UPDATE  обновление выполняет ORM
//******************* обновление данных каталога ****************************************************
//			session = factory.getCurrentSession();
//			session.beginTransaction();
///** создаём экземпляр класса Catalog, и в параметре метода get указаваю id каталога, которого необходимо поменять.
// * +: - не нужно делать запросы SQL
// *    - не нужно дополнительно что то обновлять*/
//			Catalog catalog2 = session.get(Catalog.class, 3L);
///** при помощи метода setTitle указываю новое название выбранного ранее каталога*/
//			catalog2.setTitle("Catalog3 = Fantasy9");
//			session.getTransaction().commit();
//			System.out.println(catalog2); // вывод при запросе данных из БД: Catalog: id=3, title='Catalog3 =
//			// Fantasy9'
//**************** отвязка объекта от Hibernate при помощи метода detach() ****************************
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Catalog catalog3 = session.get(Catalog.class, 3L);
///** при помощи метода detach() говорим, что не хотим чтоб объект был связан с таблицей*/
//			session.detach(catalog3); //отвязать объект от контекста
///** после вызова метода detach() ни каких изменений не произойдёт в БД*/
//			catalog3.setTitle("Catalog3 = Fantasy#12");    // вывод при запросе данных из БД: Catalog: id=3, title='Catalog3 = Fantasy9'
//			session.getTransaction().commit();
//			System.out.println(catalog3);
//**************** удаление объекта ***************************************
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Catalog catalog4 = session.get(Catalog.class, 3L);
//			session.remove(catalog4);  // удаление объекта
//			session.getTransaction().commit();
//			System.out.println(catalog4);
//**************** достать определённое кол-во элементов
			session = factory.getCurrentSession();
			session.beginTransaction();
			List<Book> allBooks = session.createQuery("from Book").getResultList();
			System.out.println(allBooks);
			session.getTransaction().commit();
//			session.merge(catalog2); // выполнит возврат если не закомичн удаленый объект
//			session.persist(catalog2);   // добавление объекта к контексту

//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Book bookJava1 = session.get(Book.class, 1L);
//			bookJava1.getTitle("Java 1 Advenced");
//			session.getTransaction().commit();
//			System.out.println(bookJava1);

		} finally {
			factory.close();
			session.close();
		}
	}
}