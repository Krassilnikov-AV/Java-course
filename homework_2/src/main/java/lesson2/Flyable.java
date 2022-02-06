/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package lesson2;

/**
 * Класс Flyable
 */
public interface Flyable {
	default void fly() {
		System.out.println(" ");
	}

}