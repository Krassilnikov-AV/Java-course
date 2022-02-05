/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package animal;

/**
 * Класс Tiger
 */
public class Tiger extends Animal {
	private static int countTiger=0;

	public Tiger(String name) {
		super(name);
		countTiger++;
	}

	public static int getCountTiger() {
		return countTiger;
	}

	@Override
	public void swim(long lengthSwim) {
		System.out.println("Тигр не умеет плавать :(");

	}

	@Override
	public void run(long lengthRun) {
		if (lengthRun >= 0 && lengthRun <= 3000) {
			System.out.println("Tигр " + this.name + " пробежал: " + lengthRun + " метров");
		}
		if (lengthRun > 3000) {
			System.out.println("Тигр " + this.name + lengthRun + " метров не пробежит");
		}
		if (lengthRun<0) {
			System.out.println("не допустимое значение!");
		}

	}
}