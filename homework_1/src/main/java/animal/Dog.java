/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package animal;

/**
 * Класс Dog
 */
class Dog extends Animal {
	private static int countDogs = 0;

	Dog(String name) {
		super(name);
		countDogs++;
	}

	static int getCountDogs() {
		return countDogs;
	}

	@Override
	public void run(long lengthRun) {
		if (lengthRun >= 0 && lengthRun <= 1000) {
			System.out.println(this.name + " пробежал " + lengthRun + " метров");
		}
		if (lengthRun > 1000) {
			System.out.println("Собака " + this.name + " " + lengthRun + " метров не пробежит");
		}
		if (lengthRun < 0) {
			System.out.println("не допустимое значение!");
		}
	}

	@Override
	public void swim(long lengthSwim) {
		if (lengthSwim >= 0 && lengthSwim <= 150) {
			System.out.println(this.name + "пробежал(-а)" + lengthSwim + " метров");
		}
		if (lengthSwim > 150) {
			System.out.println(this.name + " " + lengthSwim + " метров не проплывёт");
		}
		if (lengthSwim < 0) {
			System.out.println("не допустимое значение!");
		}

	}
}