package com.Java_course.spring.core.current.task;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Класс Cart
 * 3. Создайте  компонент  Cart  (корзина)  с  возможностью  добавления  туда  товаров  add(Product
 * * product);
 */
// корзина для всех пользователей одна и та же
//	- если пользователь дважды запросив корзину, каждый раз получит новую корзину.

@Component
/** аннотация Component сказала спрингу, что класс, который ей аннотируем, это бин.*/
//@Getter
public class Cart {
	List<Product> container;


	public List<Product> getContainer() {
		return container;
	}

	/**
	 * ВОПРОС: 1. Зачем использовать @PostConstruct?
	 * <p>
	 * ОТВЕТ: 1. В управляемом bean, @PostConstruct вызывается после обычного конструктора объектов Java.
	 * потому что, когда вызывается конструктор, bean еще не инициализирован, т.е. никакие зависимости не вводятся.
	 * В методе @PostConstruct bean полностью инициализирован, и вы можете использовать зависимости.
	 * <p>
	 * ВОПРОС: 2. Почему я должен использовать @PostConstruct для инициализации bean вместо обычного конструктора?
	 * <p>
	 * ОТВЕТ: 2. потому что это контракт, который гарантирует, что этот метод будет вызываться только один раз в bean
	 * жизненном цикле. Может случиться (хотя и маловероятно), что контейнер bean создается несколько раз контейнером
	 * во внутренней работе, но он гарантирует, что @PostConstruct будет вызываться только один раз.
	 */
	@PostConstruct
	void init() {
		container = new ArrayList<>();
	}

	public void add(Product product) {
		container.add(product);
	}
}