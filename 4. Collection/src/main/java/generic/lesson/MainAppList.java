/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package generic.lesson;

import java.util.List;

public class MainAppList {


	public static <T extends Number> T getFirstElement(List<T> list) {
		return list.get(0);

	}

	public static void main(String[] args) {
		method1(new int[] {1, 2, 3, 4});
		method2(1, 2, 3, 4);  // аналогично, только короче
	}

	public static void method1(int[] arr) {
	}

	public static void method2(int... arr) {
	}
}