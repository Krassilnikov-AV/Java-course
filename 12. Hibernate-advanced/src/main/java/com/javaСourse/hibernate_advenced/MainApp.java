package com.javaСourse.hibernate_advenced;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.lock.OptimisticEntityLockException;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * 1. Создайте таблицу items (id serial, val int, ...), добавьте в нее 40 строк со значением 0;
 * 2.  Запустите  8  параллельных  потоков,  в  каждом  из  которых  работает  цикл,  выбирающий
 * случайную  строку  в  таблице  и  увеличивающий  val  этой  строки  на  1.  Внутри  транзакции
 * необходимо  сделать  Thread.sleep(5).  Каждый  поток  должен  сделать  по  20.000  таких
 * изменений;
 * 3. По завершению работы всех потоков проверить, что сумма всех val равна соответственно
 * 160.000;
 */
public class MainApp {

	private static final int NUMBER_OF_THREADS = 8;

	public static void main(String[] args) throws IOException {
		prepareData();
		long time = System.currentTimeMillis();
		increaseValWithEightThreads();
		System.out.println("time: " + (System.currentTimeMillis() - time));
		countSumOfVal();
	}

	private static void prepareData() throws IOException {
		SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.buildSessionFactory();
		Session session = null;
		try {
			String sql = Files.lines(Paths.get("query.sql")).collect(Collectors.joining(" "));
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

	public static void increaseValWithEightThreads() {
		final CountDownLatch countDownLatch = new CountDownLatch(NUMBER_OF_THREADS);
		Thread[] threads = new Thread[NUMBER_OF_THREADS];

		try (SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.buildSessionFactory()) {
			for (int i = 0; i < NUMBER_OF_THREADS; i++) {
				final int u = i;
				threads[i] = new Thread(() -> {
					System.out.println("Thread-" + u + " started");
					for (int j = 0; j < 20_000; j++) {
						boolean updated = false;
						Long randomRow = (long) (Math.random()) * 39 + 1;
						while (!updated) {                                         // оптимистическая блокировка
							Session session = factory.getCurrentSession();
							session.beginTransaction();
							Item item = session.get(Item.class, randomRow);
							int tmp = item.getVal();
							item.setVal(++tmp);
							unchckableSleep(5);
							try {
								session.save(item);
								session.getTransaction().commit();
								updated = true;
							} catch (OptimisticEntityLockException e) {
								session.getTransaction().rollback();
							}
							if (session != null) {
								session.close();
							}
						}
					}
					countDownLatch.countDown();
				});
				threads[i].start();
			}
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("END");
		}
	}


	private static void unchckableSleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void countSumOfVal() {
		try (SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.buildSessionFactory()) {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Object o = session.createNamedQuery("SELECT SUM(val) FROM items;").getSingleResult();
			System.out.println(o);
			if (session != null) {
				session.close();
			}
		}
	}
}