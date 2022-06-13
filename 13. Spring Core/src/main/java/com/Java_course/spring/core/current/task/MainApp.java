package com.Java_course.spring.core.current.task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1. Создайте класс Product (id, title, cost);
 * 2. Создайте  компонент  ProductService,  который  хранит  в  себе  List<Product>,  допустим  с  10
 * видами товаров. В ProductService должен быть метод вывода всех товаров в консоль printAll(),
 * получения ссылки на Product по имени findByTitle(String title);
 * 3. Создайте  компонент  Cart  (корзина)  с  возможностью  добавления  туда  товаров  add(Product
 * product);
 * 4. Создайте  компонент  OrderService,  позволяющий  из  корзины  сформировать  заказ.  Под
 * формирование  заказа  подразумевается  распечатка  всех  позиций  в  консоли,  с  выводом
 * итоговой стоимости выбранных товаров.
 * Не  надо  прописывать  ввод  данных  с  консоли.  Достаточно  набросать  немного  кода,
 * демонстрирующего  выполнение  действий  с  указанными  выше  компонентами.  Базу  данных
 * прикручивать к проекту тоже не надо.
 * В ProductService у вас будет List<Product> для его заполнения не стоит использовать конструктор, как
 * бы мы это делали в обычном проекте. Вместо этого пропишите метод с аннотацией @PostConstruct,
 * который  сработает  после  подготовки  бина  к  работе,  и  в  нем  сделайте  всю  необходимую
 * подготовительную работу.
 */
public class MainApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ProductService productService = context.getBean("productService", ProductService.class);
		Cart cart = context.getBean("cart", Cart.class);
		OrderService orderService = context.getBean("orderService", OrderService.class);

		cart.add(productService.findByTitle("product #1"));
		cart.add(productService.findByTitle("product #2"));
		cart.add(productService.findByTitle("product #3"));

		orderService.createOrderFromCurrentCart();

		context.close();
	}
}