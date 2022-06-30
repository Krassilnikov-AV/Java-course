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
	 * -дале созданный экземпляр добавляем в параметр модель и показыаем страницу products
	 */
//	@GetMapping
//	public String showProductsList(Model model) {
//		Product product = new Product();
//		model.addAttribute("products", productsService.getAllProducts());
//		model.addAttribute("product", product);
//		return "products";
//	}
/**
 * пример: /products?word=Hello
 * поиск товара,  котором есть слово "Hello"
 *  * - required = false - не обязатеьный параметр
 * */
	@GetMapping
	public String showProductsList(Model model, @RequestParam(value = "word", required = false) String word) {
		Product product = new Product();
		model.addAttribute("products", productsService.getAllProductsWitchFilter(word));
		model.addAttribute("product", product);
		model.addAttribute("word", word);
		return "products";
	}

	@GetMapping("/add")
	public String showAddProductFrom(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "product-edit";
	}

	@GetMapping("/edit/{id}")
	public String showEditProductFrom(Model model, @PathVariable(value = "id") Long id) {
		Product product = productsService.getById(id);
		model.addAttribute("product", product);
		return "product-edit";
	}

	@PostMapping("/edit")
	public String addProduct(@ModelAttribute(value = "product") Product product) {
		productsService.saveOrUpdate(product);
		return "redirect:/products";
	}

	@GetMapping("/show/{id}")
	public String showOneProduct(Model model, @PathVariable(value = "id") Long id) {
//        Product product = new Product(10L, "CCC+++", 1000);
//        запрос продукта у сервиса
		Product product = productsService.getById(id);
		model.addAttribute("product", product);
		return "product-page";
	}

	/**
	 * - redirect: - посылаете запрос на страницу /products
	 */
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable(value = "id") Long id) {
		productsService.deleteById(id);
		return "redirect:/products";
	}
}
