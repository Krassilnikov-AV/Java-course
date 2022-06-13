package com.Java_course.spring.core.current.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Класс OrderService
 * 4. Создайте  компонент  OrderService,  позволяющий  из  корзины  сформировать  заказ.  Под
 * формирование  заказа  подразумевается  распечатка  всех  позиций  в  консоли,  с  выводом
 * итоговой стоимости выбранных товаров.
 */
@Component
public class OrderService {

	@Autowired
	Cart cart;

	public void createOrderFromCurrentCart() {
		System.out.println("Your order: ");
		List<Product> products=cart.getContainer();
		for (Product p : products) {
			System.out.println("Title product: " + p.getTitle() + " cost product: " + p.getCost());
		}
		System.out.println("order amount: " + products.stream().mapToDouble(Product::getCost).sum());
	}
}