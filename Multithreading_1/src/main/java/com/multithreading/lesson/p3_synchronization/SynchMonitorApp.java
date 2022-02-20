/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p3_synchronization;

/**
 * Класс SynchMonitorApp
 */
public class SynchMonitorApp {
	private Object monitor = new Object();

	public static void main(String[] args) {
		SynchMonitorApp e2 = new SynchMonitorApp();
		new Thread(() -> e2.method()).start();
		new Thread(() -> e2.method()).start();
		new Thread(() -> e2.method()).start();
	}

	private void method() {
		try {
		// часть будет выполняться параллельно
			System.out.println("NonSynch-Begin " + Thread.currentThread().getName());
			for (int i = 0; i < 3; i++) {
				System.out.println("...");
				Thread.sleep(200);
			}
			System.out.println("NonSynch-End " + Thread.currentThread().getName());
			synchronized (monitor) {
		// часть будет выполняться последовательно
				System.out.println("Synch-Begin " + Thread.currentThread().getName());
				for (int i = 0; i < 3; i++) {
					System.out.println("...");
					Thread.sleep(400);
				}
				System.out.println("Synch-End " + Thread.currentThread().getName());
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}