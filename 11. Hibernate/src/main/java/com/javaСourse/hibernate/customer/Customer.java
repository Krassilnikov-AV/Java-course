package com.javaСourse.hibernate.customer;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

//	@OneToMany(mappedBy = "customer")
//	@Cascade(org.hibernate.annotations.CascadeType.ALL)
//	private List<Product> products;

	@Override
	public String toString() {
		return "Customer [" +
			"id = " + id +
			", name = '" + name + '\'' +
			']';
	}
}