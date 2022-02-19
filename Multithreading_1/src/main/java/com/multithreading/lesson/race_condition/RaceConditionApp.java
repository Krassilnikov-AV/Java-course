/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.race_condition;

/**
 * Класс RaceConditionApp
 * - последовательность выполнения в данном случае не гарантируется!
 * - каждый поток сначало запрашивает значение, потом делает
 * инкремент или декремент
 * - несколько потоков выполняются в один момент времени, параллельно
 * - результат выполнения будет разный
 * Вывод: для исключения парллельного доступа, необхохдимо делать синхранизацию.
 * пример синхранизации потоков в классе SynchCounter
 */
public class RaceConditionApp {
	public static void main(String[] args) {
		Counter counter = new Counter();

		Thread incThread = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				counter.inc();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread decThread = new Thread(() -> {
			for (int i=0; i<100; i++) {
				counter.dec();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		try {
			incThread.start();
			decThread.start();
			incThread.join();
			decThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Значение счётчика: " + counter.value());  //
	}
}