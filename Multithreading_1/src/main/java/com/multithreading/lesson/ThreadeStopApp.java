/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson;

/**
 * Класс ThreadeStopApp
 */
public class ThreadeStopApp {

	public static void main(String[] args) {
		correct();
	}

	/*хороший вариант, который использует метод interrupt()
	 * 1. у потока есть внутреннее поле isInterrupted()  - по умолчанию false
	 * 2. когда вызывается interrupt(), то состояние этого поля переходит в true
	 * 3. если в потоке есть какой то цикл или набор шагов, который он выполняет, в каких то безопасных местах этого
	 * потока, то тогда делается проверка  (if (Thread.currentThread().isInterrupted() || inter)) кто то захотел
	 * сделать выход из потока, то тогда делается выход из цикла и завершается работа всего потока.
	 * Вывод: отличие от метода stop()
	 * 1. при написании проверки, мохно знать точно когда можно безопасно остановиться.
	 * 2.
	 *  */
	private static void correct() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				boolean inter = false;
				while (true) {
					if (Thread.currentThread().isInterrupted() || inter) {     // точки
						break;                                                  // безопасного выхода
					}
					System.out.println("tick");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {  // выбрасывается, если поток спит и не может ни чего сделать
						inter = true;
					}
				}
			}
		});
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.interrupt();
	}

	/*плохой способ остановки потока, которым легко поломать данные*/
	public static void badIdea() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("tick");
				}
			}
		});
		t.start();
		try {
			Thread.sleep(3000);
			t.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}