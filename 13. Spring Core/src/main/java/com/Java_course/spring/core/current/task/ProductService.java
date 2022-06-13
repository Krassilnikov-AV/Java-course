package com.Java_course.spring.core.current.task;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
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

	@PostConstruct
	public void init() {
		products = new ArrayList<Product>();
		for (int i = 0; i < 10; i++) {
			products.add(new Product(new Long(i + 1), "product #" + (i + 1), 10 * i));
		}
	}


	/**
	 * При получении данных по имени из БД, данный метод должен лежать в репозитории, там где есть связь с БД.
	 */
	public Product findByTitle(final String title) {
		return products.stream().filter(p -> p.getTitle().equals(title)).findFirst().get();
	}

	public void printAll() {
		for (Product p : products)
			System.out.println(p.getId() + " title: " + p.getTitle() + " cost: " + p.getCost());
	}

}