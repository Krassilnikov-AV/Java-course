/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.homework.homwork2;

import java.util.*;

/**
 * Класс Race
 */
public class Race {

	private ArrayList<Stage> stages;

	public ArrayList<Stage> getStages() {
		return stages;
	}

	public Race(Stage... stages) {
		this.stages = new ArrayList<>(Arrays.asList(stages));
	}

}