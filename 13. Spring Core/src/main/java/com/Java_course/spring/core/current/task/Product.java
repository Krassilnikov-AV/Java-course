package com.Java_course.spring.core.current.task;

import lombok.*;

/**
 * Класс Product
 * 1. Создайте класс Product (id, title, cost);
 */

//@Component
///** @Component сказала спрингу, что класс, который ей аннотируем, это бин.*/
@Data
@NoArgsConstructor
@ToString
public class Product {

	private Long id;
	private String title;
	private double cost;


	public Product(Product product) {	}

	public Product(long id, String title, double cost) {
		this.id = id;
		this.title = title;
		this.cost = cost;
	}
}