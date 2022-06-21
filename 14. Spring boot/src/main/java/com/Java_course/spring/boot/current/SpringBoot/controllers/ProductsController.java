package com.Java_course.spring.boot.current.SpringBoot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @GetMapping("/add")
    public String method1() {
        return "1";
    }

    @GetMapping("/remove/{id}")
    public String method2() {
        return "1";
    }
    @GetMapping
    public String method3() {
        return "1";
    }
    @GetMapping("/edit/{id}")
    public String method4() {
        return "1";
    }
//    private ProductsService productsService;
//
//    @Autowired
//    public void setProductsService(ProductsService productsService) {
//        this.productsService = productsService;
//    }
//
//    @GetMapping
//    public String showProductsList(Model model) {
//        Product product = new Product();
//        model.addAttribute("products", productsService.getAllProducts());
//        model.addAttribute("product", product);
//        return "products";
//    }
//
//    @PostMapping("/add")
//    public String addProduct(@ModelAttribute(value = "product")Product product) {
//        productsService.add(product);
//        return "redirect:/products";
//    }
//
//    @GetMapping("/show/{id}")
//    public String showOneProduct(Model model, @PathVariable(value = "id") Long id) {
//        Product product = productsService.getById(id);
//        model.addAttribute("product", product);
//        return "product-page";
//    }
}
