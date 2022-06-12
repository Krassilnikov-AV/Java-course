package com.Java_course.spring.core.current.simple;

import org.springframework.stereotype.Component;

/**
 * OrderService - сервис формирует заказ, который должен в БД стучаться и доставать имеющиеся продукты
 */
@Component
public class OrderService {

	/* в случае с кругой ссылкой, приведённым примером в 3-ем случае в классе ShopService() */
//	private ShopService shopService;
//
//	public OrderService(ShopService shopService) {
//		this.shopService = shopService;
//	}

	public void createOrder() {
		System.out.println("Заказ сформирован");
	}
}
