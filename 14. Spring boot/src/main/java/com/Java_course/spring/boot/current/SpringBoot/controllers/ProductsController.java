package com.Java_course.spring.boot.current.SpringBoot.controllers;

import com.Java_course.spring.boot.current.SpringBoot.entities.Product;
import com.Java_course.spring.boot.current.SpringBoot.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * -при попытке постучаться по ссылке .../products,
 * запрос перехватит метод showProductsList(Model model),
 * он в свою очередь постучится в ProductService и вытащит
 * от туда список всех товаров и достанет от туда список
 * всех товаров из репозитори, а репозиторий из БД.
 * Список товаров на фронтенд и покажет нам страницу
 */

@Controller
@RequestMapping("/products")
public class ProductsController {

	private ProductsService productsService;

	@Autowired
	public void setProductsService(ProductsService productsService) {
		this.productsService = productsService;
	}
/**
 * -создаётся пустой объект, далее запрос у сервиса всех имеющихся продуктов.
 * -дале созданный экземпляр добавляем в параметр модель и показыаем страницу products*/
	@GetMapping
	public String showProductsList(Model model) {
		Product product=new Product();
		model.addAttribute("products", productsService.getAllProducts());
		model.addAttribute("product", product);
		return "products";
	}
//	добавление
	@PostMapping("/add")
	public String addProduct(@ModelAttribute(value = "product") Product product) {
		productsService.add(product);
		return "redirect:/products";
	}
}
