/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package animalRefactor;

/**
 * Класс Cat
 */
public abstract class Cat extends Animal {
public static int count;
	public Cat(String type, String name, int maxRunDinstance, int maxSwimDinstance) {
		super(type, name, maxRunDinstance, maxSwimDinstance);
		count++;
	}
}