package com.javaСourse.hibernate.library_books;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.*;


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
//========== занести имя чиитателя с консоли =============
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter command: ");
			while (sc.hasNext()) {
				String command = sc.nextLine();
				if (command.equals("exit")) {
					break;
				}
				String[] commandParts = command.split(" ");
				switch (commandParts[0]) {
//========= занести имя автора с консоли =============
					case ("автор1"):
						session = factory.getCurrentSession();
						Author author = new Author();
						author.setName("Миха Двинов");
						session.beginTransaction();
						session.save(author);
						session.getTransaction().commit();
						break;
					case ("автор2"):
						session = factory.getCurrentSession();
						Author author2 = new Author();
						author2.setName("Александр Пушкин");
						session.beginTransaction();
						session.save(author2);
						session.getTransaction().commit();
						break;
//========= занести читателя с прочитанной книгой в БД с консоли =============
					case ("читатель"):
						session = factory.getCurrentSession();
						session.beginTransaction();
						Reader reader = session.get(Reader.class, 3);
						Book book = session.get(Book.class, 2);
						reader.getBooks().add(book);
						session.getTransaction().commit();
						break;
//============= получение какого то количества объектов при помощи HQL ===========
					case ("book list"):
						session = factory.getCurrentSession();
						session.beginTransaction();
//						List<Book> allBooks = session.createQuery("from Book").getResultList();
						Book booksList = (Book) session
							.createQuery("from Book b where b.title =:title")
							.setParameter("title", "potters_1").getSingleResult();
						session.getTransaction().commit();
						System.out.println(booksList.toString());
						break;
//			READ
//============= чтение данных из БД ================
					//======== чтение указанного катлога - работает===========
					case ("catalog1"):
						session = factory.getCurrentSession();
						session.beginTransaction();
						Catalog catalog1 = session.get(Catalog.class, 2L);
						session.getTransaction().commit();
						System.out.println(catalog1);
						break;
//          UPDATE  обновление выполняет ORM
//===================== обновление данных каталога ====================
					case ("/catalog_update"):
						session = factory.getCurrentSession();
						session.beginTransaction();
						Catalog catalog3 = session.get(Catalog.class, 3L);
						catalog3.setTitle("Catalog3 = Fantasy3");
						session.getTransaction().commit();
						System.out.println(catalog3);
						break;
//**************** достать определённое кол-во элементов при помощи HQL запросов
					case ("/all books"):
						session = factory.getCurrentSession();
						session.beginTransaction();
						List<Book> allBooks = session.createQuery("from Book").getResultList();
						System.out.println(allBooks);
						session.getTransaction().commit();
						break;
//~~~~~~~~~~~~~~~~~~~~~~ выбрать определённое название книги с автором
					case ("/title_book_author"):
						session = factory.getCurrentSession();
						session.beginTransaction();
						String queryBook = "from Book b where b.title = :title";
						List<Book> bookTitleAuthor =
							session.createQuery(queryBook).setParameter("title", "вишневый сад").getResultList();
//						for (Book b : bookTitleAuthor)
						session.getTransaction().commit();
						System.out.println(bookTitleAuthor);
						break;

					default:
						break;
				}
//========== занести имя автора =====================
//			session = factory.getCurrentSession();
//			Author author=new Author();
//			author.setName("Михаил Дзержинский");
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


			}
		} finally {
			factory.close();
			session.close();
		}
	}
}