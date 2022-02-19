/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p2.race_condition;

/**
 * Класс Counter
 */
public class Counter {
	private int c;

	public int value() {
		return c;
	}

	public Counter() {
		c = 0;
	}

	public void inc() {
		c++;
	}
	public void dec() {
		c--;
	}
}
