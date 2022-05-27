package com.javaСourse.hibernate.customer;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer_product")
@NoArgsConstructor
public class Order {

	@EmbeddedId
	private OrderKey orderKey;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", insertable = false, updatable = false)
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;

	@Column(name = "price")
	private Double price;

	@Override
	public String toString() {
		return "Order [" +
			"orderKey = " + orderKey +
			", customer = " + customer +
			", product = " + product +
			", price = " + price +
			']';
	}
}