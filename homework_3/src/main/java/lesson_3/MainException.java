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
/*
	public static void main(String[] args) {
		try {
			a();
		} catch (ArithmeticException e) {
			System.out.println("main перехватил  AE");  // main перехватил  AE
		}
	}
	static void a() {
		b();
	}

	static void b() {
		int x = 10 / 0;
	}*/

	/*public static void main(String[] args) {
		// не проверяемое исключение
		int x = 10 / 0;
		// проверяемое исключение
		try {
			FileOutputStream out=new FileOutputStream("1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}*/
	/*- - - - - - - - - - - - - - - - - - - - - - - - - */
	/*Выброс через throw*//*
	public static void main(String[] args) {
		System.out.println(1);              // 1
		try {
			throw new RuntimeException("Runtime Exception!!!");
		} catch (RuntimeException e) {
			System.out.println("RE");      // RE
		}
	}*/
	/*- - - - - - - - - - - - - - - - - - - - - - - - - */

	/*пример использования исключений в "бою"*/
/*	public static void main(String[] args) throws Exception {
		System.out.println(1);          //1
		int coef = 0;
		try {
			coef = sdrt(-100);
		} catch (ArithmeticException e) {
			coef = 7;
		}
		// выброс ещё одного исключения
		try {

		} catch (RuntimeException e) {
			System.out.println(1);
			throw new ArithmeticException("Exception thrown!!!!");

		}
	}
*/
	/*ситуация "не хочу обрабатывать исключение"*/
/*
	public static void doSomething() throws FileNotFoundException {
		FileOutputStream out = new FileOutputStream("1.txt");
	}

	private static int sdrt(int n) {
		if (n < 0) {
			// return -1; // не корректно, и не понятно что за вывод
			throw new ArithmeticException("Невозможно взять корень из отрицательного числа!!!");
		}
		return n / 2;
	}
*/
	/*- - - - - - - - - - - - - - - - - - - - - - - - - */

/*public static void main(String[] args) {
		try {
			ReportMaker.makePDFReport("1.txt", "rtsrtrst");
		} catch (IOException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.showAndWait();
		}
	}*/

	/*public static void main(String[] args) {
		try{
			int x=10/0;

		}catch (NullPointerException e) {
			System.out.println("Exception");
		} finally {
			System.out.println(1); // 1
			                        // Exception in thread "main" java.lang.ArithmeticException: / by zero
			                        //	at lesson_3.MainException.main(MainException.java:202)
		}
	} */

	/*- - - - - - - - - - - - - - - - - - - - - - - - - */

	/*
	public static void main(String[] args) {
		System.out.println(doSomething());   //  2
	}

	public static int doSomething() {
		try {
			return 1;
		} finally {
			return 2;   // так лучше не делать, чтоб не видеть странного поведения программы!
			// finally обычно служит для закрытия потоков.
		}
		try (FileOutputStream out = new FileOutputStream("1.txt")) {
      // FileOutputStream является наследником AutoCloseable и поэтому может применять с 7ой Java try с ресурсами
// так же можно создавать свои классы наследоваясь от AutoCloseable
		} catch (IOException e) {
			System.out.println("connection....");
		}
	}*/
/*- - - - - - - - - - - - - - - - - - - - - */

	// выброс собственно созданного исключения
	public static void main(String[] args) {
		throw new MyLibException();
	}

}