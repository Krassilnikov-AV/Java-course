package com.javaСourse.hibernate.customer_1;


public class ProductService {

	private ProductDAO productDAO = new ProductDAO();

	public void buyProduct(Customer_1 customer_1, Product product) {
		productDAO.buyProduct(customer_1, product);
	}

	public Product findByName(String name) {
		return productDAO.findByName(name);
	}

	public void save(Product entity) {
		productDAO.save(entity);
	}

	public Product findByID(Long id) {
		return productDAO.findByID(id);
	}

	public void update(Product product){
		productDAO.update(product);
	}
}