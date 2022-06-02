package com.javaСourse.hibernate.customer_1;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "products_1")
@NoArgsConstructor
public class Product {

	@Id
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private double price;

	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<CustomerProduct> customers = new HashSet<>();

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
}