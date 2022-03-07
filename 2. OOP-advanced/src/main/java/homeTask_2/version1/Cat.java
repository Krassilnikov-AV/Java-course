/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package homeWork_2.version1;


public class Cat implements Action {

	private String name;
	private int maxRun;
	private int maxJump;
	private Wall wall;
	private RunningЕrack runningЕrack;

	public Cat(String name, int maxRun, RunningЕrack runningЕrack) {
		this.name = name;
		this.maxRun = maxRun;
		this.runningЕrack = runningЕrack;
	}

	public Cat(String name, int maxJump, Wall wall) {
		this.name = name;
		this.maxJump = maxJump;
		this.wall = wall;
	}

	@Override
	public void run() {
		if (maxRun < 0) {
			System.out.println("Дистанция должна быть положительной");
		}
		if (maxRun == 0) {
			System.out.println("Кот не побежал");
		}
		if (maxRun > 0 && maxRun < runningЕrack.length) {
			System.out.println("Кот пробежал дистанцию равную " + runningЕrack.length);
		}
	}

	@Override
	public void jump() {

	}
}