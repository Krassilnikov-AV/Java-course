/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package collection.lesson;

import java.util.*;

public class MainAppArrayList {

	public static void main(String[] args) {

		/*Заполнение списка значсениями*/
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("A", "B", "B", "J", "S", "C", "D", "XX"));
		System.out.println(arrayList.get(1)); // Вывод: B

		/*Добавление в список значений*/
		arrayList.add("DG"); //

		/*Удаление уазанных объектов из списка массива*/
		while (arrayList.remove("B")) ;
		System.out.println(arrayList);  // Вывод: [A, J, S, C, D, XX, DG]

/*Сортировка списка ...*/
		Collections.sort(arrayList);
		System.out.println(arrayList); //Вывод: [A, C, D, DG, J, S, XX]

		/*Сортировка по длине через создание ананимного класса*/

		arrayList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		System.out.println(arrayList);  //Вывод: [A, C, D, J, S, DG, XX]

		// применив стримы
		arrayList.sort((o1, o2) -> o1.length()-o2.length());
		Collections.sort(arrayList);
		System.out.println(arrayList);   // Вывод: [A, C, D, DG, J, S, XX]

	}
}