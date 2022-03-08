/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task.fruit;

/**
 * Класс MainApp
 */
public class MainApp {

	public static void main(String[] args) {
		FruitBox<Apple> applBox = new FruitBox<>(new Apple());
		FruitBox<Apple> anotherApplBox = new FruitBox<>(new Apple());
		FruitBox<Orange> orangeBox = new FruitBox<>(new Orange());
		FruitBox<Fruit> fruitBox = new FruitBox<>();

		applBox.transfer(fruitBox);
		applBox.transfer(anotherApplBox);

//		applBox.transfer(orangeBox);    // видно, что дженерики запрещают ложить апельсины в коробку для яблок
//		fruitBox.transfer(applBox);  // видно, что дженерики запрещают ложить апельсины в коробку для фруктов
	}

}