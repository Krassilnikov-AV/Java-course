/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package task.person;

import lesson_stream.exampleStream.People;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		middleAge();
		middlesalary();
	}

/*Найти средний возраст среди представленных людей	 */
	private static void middleAge() {
		System.out.println(Arrays.asList(
			new People("Вася", 19, 26000),
			new People("Петя", 23, 26000),
			new People("Лена", 21, 23000),
			new People("Leonid", 25, 39000)).stream()
			.mapToInt(People::getAge).average().getAsDouble());
	}

/*Создайте  массив  объектов  типа  Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите среднюю зарплату сотрудника;*/
	private static void middlesalary() {
		System.out.println(Arrays.asList(
			new Person("Иван", 19, 26000),
			new Person("Пётр", 23, 26000),
			new Person("Данил", 21, 23000),
			new Person("Leonid", 25, 39000)).stream()
			.mapToInt(Person::getSalary).average().getAsDouble());
	}
}