/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p1;

/*2-ой вариант создания потока - реализация интерфейса Runnable
 * - более простой вариант создания потоков*/

public class RunnableExampleClass implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("run-" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread t = new Thread(new RunnableExampleClass());
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main-" + i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}