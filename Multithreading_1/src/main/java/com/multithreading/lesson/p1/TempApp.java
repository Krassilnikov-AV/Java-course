/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p1;

/**
 * Класс TempApp
 * Вывод: 1-start_ 2-start_ 3-start_ 1-end_ 2-end_ 3-end_  (по 3 блока)
 * такой вывод объясняется тем, что поле value неизменное, оно постоянное
 */
public class TempApp {

	private static Integer mon = 0;

	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (mon) {
				System.out.print("1-start_ ");
				mon++;                           // создает новый объект и ссылается на следующий
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("1-end_ ");
			}
		}).start();
		new Thread(() -> {
			synchronized (mon) {
				System.out.print("2-start_ ");
				mon++;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("2-end_ ");
			}
		}).start();

		new Thread(() -> {
			synchronized (mon) {
				System.out.print("3-start_ ");
				mon++;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.print("3-end_ ");
			}
		}).start();
	}
}