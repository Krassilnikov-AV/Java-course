package com.Java_course.spring.boot.current.SpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class MainController {
	/**
	 * метод, возвращает ссылку на страницу
	 * - за обработку xml отвечает thymeleaf
	 * -  @GetMapping("/index") - контроллер отправляет на указанную в кавычках страничку
	 */
	@GetMapping("/index")
	public String doSomething() {
		return "index";
	}
/**
 * - 	@ResponseBody - вернёт какой то объек вместо страницы
 * - возвращает в формате JSON
 * */
//	@GetMapping("/hello")
//	@ResponseBody
//	public String hello() {
//		return "hello";
//	}
//	@GetMapping("/hello")
//	@ResponseBody
//	public Cat hello() {
//		return new Cat(1L, "Barsik");
//	}

	/**
	 * если кто то постучится на hello, то  вернется
	 * - model - через данный интерфейс можно отправлять данные на страницу html
	 * - addAttribute - метод, ключ -значение
	 */
//	@GetMapping("/hello")
//	public String helloRequest(Model model) {
//		model.addAttribute("name", "Bob");
//		return "hello";
//	}

	/**
	 * Выдергивать имя из url
	 * 1-ый вариант
	 * -в строке запроса прописывать:  http://localhost:8189/Spring-Boot/hello?name=Max
	 * - required = false - означает может быть или не быть (не обяязательный параметр)
	 */
//	@GetMapping("/hello")
//	public String helloRequest(Model model, @RequestParam(value = "name", required = false) String name) {
//		model.addAttribute("name", name);
//		return "hello";
//	}

	/**
	 * 2-ой вариант
	 * - если хотим прописывать не отдельно ч/з знак ?,
	 * то необходимо прописывать {name} будет прописыватьсяв путь
	 * - @PathVariable(value = "name") - какая то переменная зашита в строке name,
	 * которая преобразуется в строку name
	 * !!! Данный вариант реагирует только на get запрос
	 */
//	@GetMapping("/hello/{name}")
//	public String helloRequest(Model model, @PathVariable(value = "name") String name) {
//		model.addAttribute("name", name);
//		return "hello";
//	}
	@GetMapping("/hello")
	public String helloRequest(Model model, @PathParam(value = "name") String name) {
		model.addAttribute("name", name);
		return "hello";
	}

	@GetMapping("/form")
	public String showForm() {
		return "simple-form";
	}

	/**
	 * перенаправить на index
	 */
	@PostMapping("/form")
	public String saveForm(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email) {
		System.out.println(name);
		System.out.println(email);
		return "redirect:/index";
	}

	/**
	 * -привязана полей при вызове формы
	 */
//	@GetMapping("/addcat")
//	public String showAddCatForm(Model model) {
//		Cat cat = new Cat(1L, "Barsik", "White");
//		model.addAttribute("cat", cat);
//		return "cat-form";
//	}
	@GetMapping("/addcat")
	public String showAddCatForm(Model model) {
		Cat cat = new Cat(1L, null, null);
		model.addAttribute("cat", cat);
		return "cat-form";
	}
	/**
	 * объект Cat попадает на консоль, значения в консоли прописанные в полях
	 */
	@PostMapping("/addcat")
	public String showAddCatForm(@ModelAttribute(value = "cat") Cat cat) {
		System.out.println(cat.getId() + " " + cat.getName() + " " + cat.getColor());
		return "redirect:/index";
	}
}
