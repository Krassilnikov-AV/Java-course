/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p4_deadlock;

/**
 * Класс DeadlockRepaired
 * - представляет решение проблемы Deadlock.
 *
 * Вывод в консоли:
 *
 * DeadThreadOne is holding LOCK 1...
 * DeadThreadOne is waiting for LOCK 2...
 * DeadThreadOne is holding LOCK 1 and LOCK 2...
 * DeadThreadTwo is holding LOCK 2...
 * DeadThreadTwo is waiting for LOCK 1...
 * DeadThreadOne is holding LOCK 1 and LOCK 2...
 */
public class DeadlockRepaired {
	private static final Object lock1 = new Object();
	private static final Object lock2 = new Object();

	public static void main(String[] args) {
		DeadlockRepaired.DeadlockRepairedOne threadOne = new DeadlockRepaired.DeadlockRepairedOne();
		DeadlockRepaired.DeadlockRepairedTwo threadTwo = new DeadlockRepaired.DeadlockRepairedTwo();
		threadOne.start();
		threadTwo.start();
	}

	private static class DeadlockRepairedOne extends Thread {
		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("DeadThreadOne is holding LOCK 1...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("DeadThreadOne is waiting for LOCK 2...");
				synchronized (lock2) {
					System.out.println("DeadThreadOne is holding LOCK 1 and LOCK 2...");
				}
			}
		}
	}

	private static class DeadlockRepairedTwo extends Thread {
		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("DeadThreadTwo is holding LOCK 2...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("DeadThreadTwo is waiting for LOCK 1...");
				synchronized (lock2) {
					System.out.println("DeadThreadOne is holding LOCK 1 and LOCK 2...");
				}
			}
		}
	}
}