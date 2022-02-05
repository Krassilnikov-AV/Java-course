package animal;/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

/**
 * Класс animal.Main
 */
public class Main {

	public static void main(String[] args) {

		Animal[] animals = new Animal[]{
			new Dog("Бобик"),
			new Dog("Шурик"),
			new DomesticCat("Машка"),
			new Tiger("Шарфан")
		};
		for (Animal animal : animals) {
			animal.run(600);
			animal.swim(300);

		}
	}
}