package com.Java_course.spring.boot.current.SpringBoot.controllers;

import com.Java_course.spring.boot.current.SpringBoot.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemsController {
	private ItemsService itemsService;

	@Autowired
	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}

	@GetMapping
	public String showItemsPage(Model model) {
		model.addAttribute("items", itemsService.getAllItems());
		return "items";
	}

}