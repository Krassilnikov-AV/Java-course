package com.Java_course.spring.core.current.task;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Класс ProductService
 * 2. Создайте  компонент  ProductService,  который  хранит  в  себе  List<Product>,  допустим  с  10
 * * видами товаров. В ProductService должен быть метод вывода всех товаров в консоль printAll(),
 * * получения ссылки на Product по имени findByTitle(String title);
 */

@Component
/** аннотация Component сказала спрингу, что класс, который ей аннотируем, это бин.*/
public class ProductService {

	private List<Product> products;

	public void init() {
		products = new ArrayList<Product>();
		for (int i = 0; i < 10; i++) {
			products.add(new Product(new Product(new Long(i + 1), "product #" + (i + 1), 10 * i)));
		}
	}

	public List<Product> printAll() {

		return null;
	}

	public Product findByTitle(String title) {

		return null;
	}
}