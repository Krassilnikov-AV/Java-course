/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package animal;

/**
 * Класс DomesticCat
 */
public class DomesticCat extends Animal {

	public DomesticCat(String name) {
		super(name);
		coutAnimals++;
	}

	@Override
	public void swim(long lengthSwim) {
		System.out.println("Домашняя кошка не умеет плавать :(");

	}

	@Override
	public void run(long lengthRun) {
		if (lengthRun >= 0 && lengthRun <= 200) {
			System.out.println("Домашняя кошка " +this.name + " пробежла " + lengthRun + " метров");
		}
		if (lengthRun > 200) {
			System.out.println("Домашняя кошка "+this.name+ " " + lengthRun + " метров не пробежит");
		}
		if (lengthRun<0) {
			System.out.println("не допустимое значение!");
		}
	}
}