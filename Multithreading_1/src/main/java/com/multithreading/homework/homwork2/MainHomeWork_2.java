/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.multithreading.homework.homwork2;

import java.util.concurrent.*;

/**
 * Класс MainHomeWork_2
 */
public class MainHomeWork_2 {

	public static final int CARS_COUNT = 4;

	public static void main(String[] args) {
		System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
		CyclicBarrier barier = new CyclicBarrier(CARS_COUNT+1);
		Race race = new Race(new Road(60), new Tunnel( ), new Road(40));
		Car[] cars = new Car[CARS_COUNT];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(race, 20 + (int) (Math.random() * 10), barier);
		}
		for (int i = 0; i < cars.length; i++) {
			new Thread(cars[i]).start();
		}
		try {
			barier.await();
			System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
			barier.await();
			System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}