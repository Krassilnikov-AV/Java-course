package com.multithreading.lesson.p1;

/**
 * 3-ий способ создания Thread через анонимный класс
 */
public class AnonymousExampleClass {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		try {
			t.join();  // заставляет поток, в котором join выполняется подождать, указанный поток t
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("END");
	}
}