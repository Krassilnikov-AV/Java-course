/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package homeWork_2.final_version;

/**
 * Класс Cat
 */
public class Cat implements Contestant {

	private int maxRunDistance;
	private int maxJumpHeight;

	public Cat() {
		this.maxRunDistance = 150;
		this.maxJumpHeight = 2;
	}

	@Override
	public boolean iump(int height) {
		if (height < 0) {
			System.out.println(this.toString() + "не может быть отрицательной");
			return false;
		} else if (height >= maxJumpHeight) {
			System.out.println("Дистанция " + height + " не по плечу" + this.toString());
			return false;
		} else {
			System.out.println(this.toString() + " Кот пробежал успешно дистанцию в " + height + " метров.");
			return true;
		}
	}

	@Override
	public boolean run(int distance) {
		if (distance < 0) {
			System.out.println(this.toString() + "не может быть отрицательной");
			return false;
		} else if (distance >= maxRunDistance) {
			System.out.println("Дистанция " + distance + " не по плечу" + this.toString());
			return false;
		} else {
			System.out.println(this.toString() + " Кот пробежал успешно дистанцию в " + distance + " метров.");
			return true;
		}
	}

	@Override
	public String toString() {
		return "Cat";
	}
}