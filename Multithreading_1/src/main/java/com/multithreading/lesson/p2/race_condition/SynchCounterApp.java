/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p2.race_condition;

/**
 * Класс SynchCounterApp
 * - при запуске напианного класса всегда будет ноль, т.к. потоки синхранизированы
 */
public class SynchCounterApp {
	public static void main(String[] args) {
		SynchCounter synchCounter = new SynchCounter();

		Thread incThread = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				synchCounter.inc();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread decThread = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				synchCounter.dec();
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
			incThread.join();     // в данном случае будут работать по одному  и последовательно
			decThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Значение счётчика: " + synchCounter.value());  //

	}
}