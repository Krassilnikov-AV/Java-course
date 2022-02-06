/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package animalRefactor;

/**
 * Класс Tiger
 */
public class Tiger extends Cat {
	public static int count;

	public Tiger(String name, int maxRunDinstance, int maxSwimDinstance) {
		super("Тигр ", name, maxRunDinstance, maxSwimDinstance);
		count++;
	}
}