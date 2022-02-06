/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package animalRefactor;

/**
 * Класс HouseCat
 */
public class HouseCat extends Cat {
	public static int count;

	public HouseCat(String name, int maxRunDinstance, int maxSwimDinstance) {
//		super("Домашний кот ", name, maxRunDinstance, 0);
		super("Домашний кот " + name + maxRunDinstance + 0);
		count++;
	}
}