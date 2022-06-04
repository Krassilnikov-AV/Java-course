package com.javaСourse.hibernate.customer;

//@Data
//@Entity
//@Table(name = "customers_1")
//@NoArgsConstructor
//public class Customer {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
//	private Long id;
//
//	@Column(name = "name")
//	private String name;
//
//	@OneToMany(mappedBy = "customer")
//	@Cascade(org.hibernate.annotations.CascadeType.ALL)
//	private List<Product> products;
//
//	@ManyToMany
//	@JoinTable(
//		name = "customer_product",
//		joinColumns = @JoinColumn(name = "customer_id"),
//		inverseJoinColumns = @JoinColumn(name = "product_id")
//	)
//	private List<Product> products;
//
//	@Override
//	public String toString() {
//		return "Customer_1{" +
//			"id=" + id +
//			", name='" + name + '\'' +
//			", products=" + products +
//			'}';
//	}
//}