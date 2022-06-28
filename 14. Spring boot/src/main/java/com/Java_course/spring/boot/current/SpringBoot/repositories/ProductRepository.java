package com.Java_course.spring.boot.current.SpringBoot.repositories;


import com.Java_course.spring.boot.current.SpringBoot.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductRepository {
	private List<Product> products;

	@PostConstruct
	public void init() {
		products = new ArrayList<>();
		products.add(new Product(1L, "Bread", 40));
		products.add(new Product(2L, "Milk", 90));
		products.add(new Product(3L, "Cheese", 200));
	}

	public List<Product> findAll() {
		return products;
	}

	public Product findByTitle(String title) {
		return products.stream().filter(p -> p.getTitle().equals(title)).findFirst().get();
	}

	public Product findById(Long id) {
		return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
	}

	public void save(Product product) {
		products.add(product);
	}

	public void deleteById(Long id) {
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product product=iter.next();
			if(product.getId().equals(id)) {
				iter.remove();
				return;
			}
		}
	}
}
