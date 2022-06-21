package com.Java_course.spring.boot.current.SpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	/** метод, возвращает ссылку на страницу
	 * - за обработку xml отвечает thymeleaf
	 * -  @GetMapping("/index") -
	 * */
	    @GetMapping("/index")
    public String doSomething() {
        return "index";
    }

}
