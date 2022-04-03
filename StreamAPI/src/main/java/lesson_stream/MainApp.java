/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package lesson_stream;

public class MainApp {
	public static void main(String[] args) {

///*пример анонимного класса*/

//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//			}
//		}).start();
//
///*пример лямбда-выражения*/
//
//		new Thread(
//			() -> {
//
//			}
//		).start();
//	}
		/*пример разной работы одного и того же метода
		 * - почему?
		 * - отработал один поток, потом другой
		 * - ляьбда - это какой то метод...
		 * */
		doSomething(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Java");
			}
		});

		doSomething(() -> System.out.println(100));
	}

	public static void doSomething(Runnable runnableObj) {
		runnableObj.run();
	}

}

