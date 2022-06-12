package com.Java_course.spring.core.current.simple;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

/**
 * ShopService - оформление заказа
 */
@Component      // id = "shopService" - автоматически задаёт имя бина
//@Component("shhhhhService") - вручную задать имя бина
/**
 * аннотация Component сказала спрингу, что класс, который ей аннотируем, это бин.*/
public class ShopService {
	/*============================== 1-ый вариант ============================================================*/
//	@Autowired
//	/**
//	 * Аннотация Autowired попросила Spring в поле, которое она аннотирует,
//	 * подставить значение. Эта операция называется «инжектнуть» (inject). */
//		ProductService productService;
//
//	@Autowired
//	OrderService orderService;
//
//	@Autowired
//	MailService mailService;
//
//	public void buy() {
//		productService.getProducts();
//		orderService.createOrder();
//		mailService.sendMail();
//	}
	/*========================= 2-ой вариант, через сеттер ========================================================*/
//	private ProductService productService;
//
//	@Autowired
//	private OrderService orderService;
//
//	@Autowired
//	private MailService mailService;
//
//	@Autowired
//	public void setProductService(ProductService productService) {
//		this.productService = productService;
//	}
//
//	public void buy() {
//		productService.getProducts();
//		orderService.createOrder();
//		mailService.sendMail();
//	}
	/*================= 3-ой вариант, через крнструктор	========================================================*/
	/**
	 * отрицательный момент:
	 * - возможно закольцевать OrderService и ProductService, данный приём приведёт к ошибке компиляции
	 * -
	 */
//	private ProductService productService;
//	private OrderService orderService;
//	private MailService mailService;
//
//	public ShopService(ProductService productService, OrderService orderService, MailService mailService) {
//		this.productService = productService;
//		this.orderService = orderService;
//		this.mailService = mailService;
//	}
//
//	public void buy() {
//		productService.getProducts();
//		orderService.createOrder();
//		mailService.sendMail();
//	}

	/*====================  */
	private ProductService productService;
	private OrderService orderService;
	private MailService mailService;
	private BeanInterface beanInterface;
    private BeanInterface beanInterface2;

//	@Autowired
//	@Qualifier("beanInterfaceImpl")
	/**@Qualifier - указыввает, какую из нескольких реализаций хотим применить*/
//	public void setBeanInterface(BeanInterface beanInterface) {
//		this.beanInterface = beanInterface;
//	}

	/**
	 * Вывод:
	 * Получен список товаров
	 * Заказ сформирован
	 * Письмо отправлено
	 * 1
	 */
	@Autowired
	@Qualifier("beanInterfaceImpl")
	public void setBeanInterface(BeanInterface beanInterface) {
		this.beanInterface = beanInterface;
	}


    @Autowired
    @Qualifier("advBeanInterfaceImpl")
    public void setBeanInterface2(BeanInterface beanInterface2) {
        this.beanInterface2 = beanInterface2;
    }
	/**
	 * Вывод:
	 * Получен список товаров
	 * Заказ сформирован
	 * Письмо отправлено
	 * 1
	 * 2
	 */
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Autowired
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public void buy() {
		productService.getProducts();
		orderService.createOrder();
		mailService.sendMail();
		beanInterface.doSomething();
		beanInterface2.doSomething();
	}
}
