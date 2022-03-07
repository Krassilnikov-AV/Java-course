/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package generic.lesson;

/*
 * При ниже предложенной конструкции кода, можно менять в конструкторе тип ожидаемых параметров.
 * Решает следующие проблемы:
 * 1. избавление от проверок
 * 2. не нужно приводить к определенному типу
 * 3. вместо определенного типа нельзя положить другой тип данных
 * */
public class MainAppGen {

	public static void main(String[] args) {
		GenBox<String> strBox = new GenBox<>("Java");
		GenBox<Integer> intBox1 = new GenBox<Integer>(20);
		GenBox<Integer> intBox2 = new GenBox<Integer>(100);

		// в любом случае прилетают типы int
		int sum = intBox1.getObj() + intBox2.getObj();
		System.out.println(sum);
	}



}