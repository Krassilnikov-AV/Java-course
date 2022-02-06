package animal;/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

/**
 * Класс animal.Main
 */
public class Main {
	/*Случайные числа*/
	private static final int MIN = 10;
	private static final int MAX = 100;

	public static void main(String[] args) {
		int counterAnimals = Animal.getCount();
		int counterDog = 0;
		int countDomestiCat = 0;
		int countTiger = 0;
		Animal[] animals = new Animal[]{
			new Dog("Бобик"),
			new DomesticCat("Дуська"),
			new Dog("Шурик"),
			new DomesticCat("Машка"),
			new Tiger("Тайга"),
			new Tiger("Шарфан")
		};
		for (Animal animal : animals) {
//			animal.run(600);
//			animal.swim(300);
			/*реализация случайных дистанций*/
			animal.run(MIN+ (int) (Math.random() * MAX));
			animal.swim(MIN+ (int) (Math.random() * MAX));
			counterAnimals++;
			counterDog = Dog.getCountDogs();
			countDomestiCat = DomesticCat.getCountDomestiCat();
			countTiger = Tiger.getCountTiger();
		}

		System.out.println("создано:\n "
			+ counterAnimals + " животных(-ое), из них\n "
			+ counterDog + " собак (-ки)\n"
			+ countDomestiCat + " домашних кошек(-ки)\n "
			+ countTiger + " тигров(-ра)");
	}
}