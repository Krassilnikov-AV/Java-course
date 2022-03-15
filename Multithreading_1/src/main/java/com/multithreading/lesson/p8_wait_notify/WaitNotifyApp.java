/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p8_wait_notify;

/*WaitNotifyApp - представленный класс позволяет печатать поочерёдно буквы А и В
* с применением wait и notify
* Вывод: A B A B A B A B A B */

public class WaitNotifyApp {
	private final Object mon = new Object();
	private volatile char currentLetter = 'A';  // volatile(«изменчивый») означает, что значение переменной будет изменяться разными потоками.

	public static void main(String[] args) {
		WaitNotifyApp waitNotifyApp = new WaitNotifyApp();
		new Thread(() -> {
			waitNotifyApp.printA();
		}).start();
		new Thread(() -> {
			waitNotifyApp.printB();
		}).start();
	}


	private void printA() {
		synchronized (mon) {
			try {
				for (int i = 0; i < 5; i++) {
					while (currentLetter != 'A') {    //
						mon.wait();
					}
					System.out.print("A ");
					currentLetter = 'B';
					mon.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void printB() {
		synchronized (mon) {
			try {
				for (int i = 0; i < 5; i++) {
					while (currentLetter != 'B') {
						mon.wait();                  //режим ожидания по монитору
					}
					System.out.print("B ");
					currentLetter = 'A';
					mon.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}