/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package lesson2;

/**
 * Класс Airplane
 */
public class Airplane implements Flyable{
	@Override
	public void fly() {
		System.out.println("Самолет летит");
	}
}