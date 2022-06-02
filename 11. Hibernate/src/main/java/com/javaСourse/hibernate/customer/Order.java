package com.javaСourse.hibernate.customer;

//@Data
//@Entity
//@Table(name = "customer_product")
//@NoArgsConstructor
//public class Order {
//
//	@EmbeddedId
//	private OrderKey orderKey;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "customer_id", insertable = false, updatable = false)
//	private Customer customer;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "product_id", insertable = false, updatable = false)
//	private Product product;
//
//	@Column(name = "cost")
//	private Double cost;
//
//	@Override
//	public String toString() {
//		return "Order [" +
//			"orderKey = " + orderKey.getProductId() +
//			", customer = " + customer.getName() +
//			", product = " + product.getTitle() +
//			", cost = " + cost +
//			']';
//	}
//}