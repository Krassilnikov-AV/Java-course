/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.homework.homwork2;

/**
 * Класс Stage
 */
public abstract class Stage {
	protected int length;
	protected String description;

	public String getDescription() {
		return description;
	}

	public abstract void go(Car c);
}