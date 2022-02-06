/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package animalRefactor;

import animal.Animal;

/**
 * Класс Dog
 */
class Dog extends Animal {
	public static int count;

	public Dog(String name, int maxRunDinstance, int maxSwimDinstance) {
		super("Пёс" + name + maxRunDinstance + maxSwimDinstance);
		count++;
	}
}