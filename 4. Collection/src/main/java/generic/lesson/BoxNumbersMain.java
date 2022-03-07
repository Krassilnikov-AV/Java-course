/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package generic.lesson;

public class BoxNumbersMain {
	public static void main(String[] args) {
		BoxWithNumbers<Integer> intBox = new BoxWithNumbers<>(1, 2, 3, 4);
		System.out.println(intBox.average());
		BoxWithNumbers<Integer> intBox2 = new BoxWithNumbers<>(1, 2, 3, 4);
		System.out.println(intBox.average());
		BoxWithNumbers<Float> floatBox = new BoxWithNumbers<>(1.0f, 2.0f, 3.0f, 4.0f);
		System.out.println(floatBox.average());
		System.out.println(intBox.compareAverage(intBox2));
		System.out.println(intBox.compareAverage(floatBox));

		System.out.println(intBox.getClass().getName());
// разница м/д doSomething1 и doSomething2
		GenBox<Number> gbn = new GenBox<Number>(1);
		GenBox<Integer> gbi = new GenBox<>(1);
		doSomething1(gbn);
		doSomething2(gbn);
		doSomething1(gbi);
//		doSomething2(gbi);  // выдает ошибку т.к. в обобщениях не работает наследование

	}

	public static void doSomething1(GenBox<? extends Number> box) {

	}

	public static void doSomething2(GenBox<Number> box) {

	}

}