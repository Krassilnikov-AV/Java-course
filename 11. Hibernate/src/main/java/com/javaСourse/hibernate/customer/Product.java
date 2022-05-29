package com.javaСourse.hibernate.customer;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "cost")
	private Double cost;

	@ManyToMany
	@JoinTable(
		name = "customer_product",
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "customer_id")
	)
	private List<Customer> readers;

	@Override
	public String toString() {
		return "Product{" +
			"id=" + id +
			", title='" + title + '\'' +
			", cost=" + cost +
			", readers=" + readers +
			'}';
	}
}