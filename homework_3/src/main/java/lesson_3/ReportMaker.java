/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package lesson_3;

import java.io.*;

/**
 * Класс ReportMaker
 */
/*в данном случае при написании класса запись исключения ни куда уходит,
 * и его не возможно корректно обработать, т.к. не знаем кто будет пользоваться
 * данным методом.*/

//public class ReportMaker {
//
//	public static void makePDFReport(String path, String data) {
//		try {
//			FileOutputStream out = new FileOutputStream("1.txt");  // возможная ошибка о том что путь к файлу может
//			// быть не найден
//			out.write(data.getBytes());
//			out.close();
//		} catch (IOException e) {           // перехват и распечатка исключения
//			e.printStackTrace();
//		}
//	}
//}

/*в данном случае будет выбрасываться исключение при вызове метода в другом классе*/
public class ReportMaker {

	public static void makePDFReport(String path, String data) throws IOException {
		FileOutputStream out = new FileOutputStream("1.txt");  // возможная ошибка о том что путь к файлу может

		out.write(data.getBytes());
		out.close();

	}
}