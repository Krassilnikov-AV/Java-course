/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson;

/**
 * Класс ThreadeOrderApp не гарантирует порядочного выполнения потоков
 */
public class ThreadeOrderApp {

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(1);
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(2);
			}
		}).start();
	}
}