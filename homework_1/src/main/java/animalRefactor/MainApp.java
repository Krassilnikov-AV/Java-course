/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package animalRefactor;

/**
 * Класс MainApp
 */
public class MainApp {

	//	public static void main(String[] args) {
//		Animal[] animals = new Animal[]{
//			new HouseCat("Барсик", 150, 50),
//			new Dog("Bobik", 250, 90),
//			new Tiger("Shihan", 2000, 90)
//		};
//		for (Animal o : animals) {
//			o.run(150);
//			o.swim(30);
//		}
//	}
	public static void main(String[] args) {
		Animal[] animals = new Animal[]{
//	new Dog("Bobok", 250, 100),
			new HouseCat("Dodo", 150, 50),
			new Tiger("Shihan", 2500, 800),
//			new Dog("Bobik", 1000, 150)
		};
		for (Animal o : animals) {
			o.swim(150);
			o.run(1500);
		}
	}
}