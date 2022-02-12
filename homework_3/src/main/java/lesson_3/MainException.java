/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package lesson_3;

/**
 * Класс MainException
 */
public class MainException {

	/*Демонстрация названий ошибок*/

	/*public static void main(String[] args) {
		int a = 56 / 0;    // java.lang.ArithmeticException: / by zero
	}
	/*
		public static void main(String[] args) {
		System.out.println(1);   // 1
		a(); //java.lang.StackOverflowError
			System.out.println(2);   // 2
		}
		System.out.println(3);   // 3

		static void a() {
		a();
}
	}
		*//*
public static void main(String[] args) {
	 int x = Integer.parseInt("2s0");   // java.lang.NumberFormatException: For input string: "2s0"
		System.out.println(x);
	 }
	 *//*
public static void main(String[] args) {
	String string=null;
		System.out.println(string.length());  // java.lang.NullPointerException
		}*/
	/*
public static void main(String[] args) {

		System.out.println(Double.parseDouble("2,2")); //java.lang.NumberFormatException: For input string: "2,2"
}*/
	/*Демонстрация перехвата исключений*/

	/*public static void main(String[] args) {

		try {
			System.out.println(1);
			int x = 10 / 0;           //  1
			System.out.println(2);
		}
		// возможность перехвата исключения по родителю, теряется смысл в след. исключениях в данном случае
		catch (RuntimeException e) {
			System.out.println("Перехвачено исключение значения x!");
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println("Перехвачено исключение значения x!"); // Перехвачено исключение значения x!
		}

	}*/
	/*public static void main(String[] args) {

		try {
			System.out.println(1);
			int x = 10 / 0;           //  1
			System.out.println(2);
		}
		// такая контрукция полностью меняет ход дела
		catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException: Перехвачено исключение значения x!"); // ArithmeticException: Перехвачено исключение значения x!
			// значения x!
		} catch (RuntimeException e) {
			System.out.println("RuntimeException: Перехвачено исключение значения x!");
		}
	}*/
	/*public static void main(String[] args) {

		try {
			System.out.println(1);
			int x = 10 / 0;           //  1
			System.out.println(2);
// перехваченное исключение
			try {

			} catch (Exception exc) {
				exc.printStackTrace();
			}
// закрыто перехваченное исключение
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException: Перехвачено исключение значения x!"); // ArithmeticException: Перехвачено исключение значения x!
			// значения x!
		} catch (RuntimeException e) {
			System.out.println("RuntimeException: Перехвачено исключение значения x!");
		}
	}*/
/*
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
//  Пример перехваченного исключения
		try {
			serverSocket = new ServerSocket(8189);
		} catch (
	IOException e) {
			e.printStackTrace();
// перехваченное исключение
			try {
				serverSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
// закрыто перехваченное исключение

		}
	}*/


}