/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.homework.homwork2;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Класс Car
 */
public class Car implements Runnable {
	private static int CARS_COUNT;
	private static AtomicInteger ai;

	private Race race;
	private int speed;
	private String name;
	private CyclicBarrier barrier;

	static {
		CARS_COUNT = 0;
		ai = new AtomicInteger(0);
	}


	public String getName() {
		return name;
	}

	public int getSpeed() {
		return speed;
	}

	public Car(Race race, int speed, CyclicBarrier barrier) {
		this.race = race;
		this.speed = speed;
		CARS_COUNT++;
		this.name = "Участник #" + CARS_COUNT;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(this.name + " готовится");
			Thread.sleep(500 + (int) (Math.random() * 800));
			System.out.println(this.name + " готов");


		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < race.getStages().size(); i++) {
			race.getStages().get(i).go(this);
		}

//		static Object monitor =...;
//		static boolean haveWinter = false;
//		synchronized (monitor) {
//			if (!haveWinter) {
//				haveWinter = true;
//				System.out.println(name + " WIN");
//			}
//		}

		if (ai.incrementAndGet() == 1) {
			System.out.println(name + " - WIN");
		}
		try {
			barrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}