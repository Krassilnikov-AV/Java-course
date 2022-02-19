/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p1;

/**
 * Пример потока демона
 * - java приложение работает дотех пор пока работает хотя бы один поток, в данном случае main
 */
public class DaemonExample {

	public static void main(String[] args) {
		Thread tTimer = new Thread(() -> {
			int time = 0;
			while (true) {
				try {
					Thread.sleep(1000);
					time++;
					System.out.println("time: " + time);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		tTimer.setDaemon(true);        // без setDaemon(true) поток не завершится
		tTimer.start();
//		tTimer.getState(); // состояние потока
//		tTimer.setPriority(5);  // установка приоритета
		System.out.println("main -> sleep");
//		tTimer.getStackTrace();  //
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main -> end");
	}
}