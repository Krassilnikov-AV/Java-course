/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p3_synchronization;

/**
 * Класс SynchMethodsApp
 */
public class SynchMethodsApp {

	public static void main(String[] args) {
		SynchMethodsApp e1 = new SynchMethodsApp();
		SynchMethodsApp e2 = new SynchMethodsApp();
//		new Thread(() -> e1.method1()).start();
//		new Thread(() -> e1.method2()).start();
		// вывод потоков не параллельный:
		// M1 - START
		//M1 - END
		//M2 - START
		//M2 - END
		new Thread(() -> e1.method1()).start();
		new Thread(() -> e2.method3()).start();
		// вывод параллельный:
//		M1 - START
//		M3 - START
//		M3 - END
//		M1 - END
	}

	/*блок с критической секцией (synchronized), куда может зайти только один потокв еиницу времени
	 *  - монитор помогает потоку определить занят или свободен метод
	 *  - */
	private synchronized void method1() {

		System.out.println("M1 - START");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("M1 - END");
	}

	private synchronized void method2() {
		System.out.println("M2 - START");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("M2 - END");
	}

	/*
	 * блокировка синхронизации не распространяется на обычные методы
	 *  - при запуске с синхронизированным потоком работа будет выполняться параллельно*/
	private synchronized void method3() {
		System.out.println("M3 - START");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("M3 - END");
	}
}