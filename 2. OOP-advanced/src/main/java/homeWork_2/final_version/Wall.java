/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package homeWork_2.final_version;

/**
 * Класс Wall
 */
public class Wall implements Obstracle {

	private int height;

	public Wall(int height) {
		this.height = height;
	}

	@Override
	public boolean contest(Contestant contestant) {
		if (contestant.iump(height)) {
			System.out.println(contestant.toString() + " пеепрыгнул высоту");
			return true;
		} else {
			System.out.println(contestant.toString() + " не смог перепрыгнуть высоту!");
			return false;
		}
	}
}