/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package generic.lesson;

public class MainApp {
	public static void main(String[] args) {
		SimplBox intBox1 = new SimplBox(10);
		SimplBox intBox2 = new SimplBox(20);
		// ....
		intBox1.setObj("Java"); // или Error

		// ....
		if (intBox1.getObj() instanceof Integer && intBox2.getObj() instanceof Integer) {
			int sum = (Integer) intBox1.getObj() + (Integer) intBox2.getObj();
			System.out.println("sum: " + sum);
		} else {
			System.out.println("Error");
		}
	}
}
