/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.lesson.p2.race_condition;

/**
 * Класс SynchCounter
 * - synchronized - говорит о том, что в нутрь этого метода в единицу времени может зайти только один поток.
 */
public class SynchCounter {
	private int c;

	public int value() {
		return c;
	}

	public SynchCounter() {
		c = 0;
	}

	public synchronized void inc() {
		c++;
	}
	public synchronized void dec() {
		c--;
	}
}