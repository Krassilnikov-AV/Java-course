/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package lesson_stream.exampleStream;

public class People {
	String name;
	int age;
	int salary;

	public People(String name, int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}
}