package com.Java_course.spring.boot.current.SpringBoot.services;


import com.Java_course.spring.boot.current.SpringBoot.entities.Product;
import com.Java_course.spring.boot.current.SpringBoot.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * - ProductsService - выполняет полностью всю нашу работу
 */
@Service
public class ProductsService {
	// подключение к БД через репозиторий........
	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// получение всех товаров, через репозиторий
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public List<Product> getAllProductsWitchFilter(String word) {
		List<Product> fullList = productRepository.findAll();
		if (word == null) {
			return fullList;
		}
		return fullList.stream().filter(p -> p.getTitle().contains(word)).collect(Collectors.toList());
	}

	public void add(Product product) {
		productRepository.save(product);
	}

	public Product getById(Long id) {
		return productRepository.findById(id);
	}

	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	public void saveOrUpdate(Product product) {
			productRepository.save(product);
	}
}
