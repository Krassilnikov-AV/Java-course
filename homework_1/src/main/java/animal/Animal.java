/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package animal;

/**
 * Класс Animal
 */
public abstract class Animal {
	String name;
	static int coutAnimals = 0;

	public Animal() {
	}

	public Animal(String name) {
		coutAnimals++;
		this.name = name;
	}

	public void run(long lengthRun) {
	}

	public void swim(long lengthSwim) {
	}

	public static int getCount() {
		return coutAnimals;
	}
}