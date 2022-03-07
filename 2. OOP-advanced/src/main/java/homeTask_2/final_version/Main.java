/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

import homeWork_2.final_version.*;

public class Main {

	public static void main(String[] args) {
		List<Obstracle> obstracles = new ArrayList<>();
		obstracles.add(new Treadmill(50));
		obstracles.add(new Wall(2));
		obstracles.add(new Treadmill(100));
		List<Contestant> contestants=new ArrayList<>();
		contestants.add(new Cat());
		contestants.add(new Human());
	for (Contestant contestant:contestants) {
		for (Obstracle obstracle :obstracles) {
			if (!obstracle.contest(contestant)) break;
		}
	}

	}
}