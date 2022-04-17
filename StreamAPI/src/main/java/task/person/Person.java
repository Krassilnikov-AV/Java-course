/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task.person;

public class Person {

	String name;
	int age;
	double salary;

	public Person(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}


	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Имя сотрдника " +
			"name='" + name + '\'';
	}
}