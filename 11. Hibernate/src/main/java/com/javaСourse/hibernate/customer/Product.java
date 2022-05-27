package com.javaСourse.hibernate.customer;


import lombok.*;
import org.hibernate.annotations.Cascade;

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
	private Long id;

	@Column(name = "name")
	private String name;
	@Column(name = "cost")
	private Double cost;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Order> orders;

	@Override
	public String toString() {
		return "Product [" +
			"id = " + id +
			", name = '" + name + '\'' +
			", cost = " + cost +
			", orders = " + orders +
			']';
	}
}