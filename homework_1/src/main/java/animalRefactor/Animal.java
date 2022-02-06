/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package animalRefactor;

/**
 * Класс Animal
 */
public abstract class Animal {
	public static int count;

	String name;
	String type;

	int maxRunDinstance;
	int maxSwimDinstance;

	public Animal(String type, String name, int maxRunDinstance, int maxSwimDinstance) {
		count++;
		this.type = type;
		this.name = name;
		this.maxRunDinstance = maxRunDinstance;
		this.maxSwimDinstance = maxSwimDinstance;
	}

	public void run(int distance) {
		if (distance <= maxRunDinstance) {
			System.out.println(type + " " + name + " успешно справился с кроссом " + distance+" м");
		} else {
			System.out.println(type + " " + name + " не смог справиться с кроссом" + distance+" м");
		}
	}

	public void swim(int distance) {
		if (maxRunDinstance == 0) {
			System.out.println(type + " " + name + " не умеет плавать!");
			return;
		}
		if (distance <= maxSwimDinstance) {
			System.out.println(type + " " + name + " успешно справился с заплывом"+ distance+" м");
		} else {
			System.out.println(type + " " + name + " не смог справиться с заплывом"+ distance+" м");
		}
	}
}