/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package homeWork_2.final_version;

/**
 * Класс Treadmill
 */
public class Treadmill implements Obstracle {
	private int lenght;

	public Treadmill(int lenght) {
		this.lenght = lenght;
	}

	@Override
	public boolean contest(Contestant contestant) {
		if (contestant.run(lenght)) {
			System.out.println(contestant.toString() + " пробежал дистанцию");
			return true;
		} else {
			System.out.println(contestant.toString() + " не смог пробежать дистанцию!");
			return false;
		}
	}
}