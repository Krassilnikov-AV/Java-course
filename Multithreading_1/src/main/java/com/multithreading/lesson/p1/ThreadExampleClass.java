/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p1;

/*1-ый вариант создания потока - наследование от класса Thread
 * - не удобно если класс наследуется от другого класса
 * - если как то подкрутить многопоточность*/


public class ThreadExampleClass extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("thread-" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Thread t = new ThreadExampleClass();
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