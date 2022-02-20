/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p3_synchronization;

/**
 * Класс SynchStatticMethodApp
 */
public class SynchStatticMethodApp {


	public static void main(String[] args) {
		SynchStatticMethodApp e = new SynchStatticMethodApp();

	/*Вданном случае вызов методов будет работать последовательно*/
		new Thread(() -> classMethod()).start();
		new Thread(() -> classMethod()).start();
	//   Synch Static method Start
	//   Synch Static Method End
	//   Synch Static method Start
	//   Synch Static Method End

	/* В приведенном примере ниже вызов метода класса и
	  метода объекта будут работать параллельно */
		new Thread(() -> classMethod()).start();
		new Thread(() -> e.objectMethod()).start();
	//    Synch Static method Start
	//    Synch Object method Start
	//    Synch Static Method End
	//    Synch Object Method End
	}

	/*В данном случае монитором статического метода выступает сам класс
	 * т.е. какой то поток начал выполнять classMethod(), то в этот момент времени
	 * ни какой другой поток не может вызывать синхронизованный статический метод*/
	private synchronized static void classMethod() {
		System.out.println("Synch Static method Start");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Synch Static Method End");
	}

	private synchronized void objectMethod() {
		System.out.println("Synch Object method Start");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Synch Object Method End");
	}
}