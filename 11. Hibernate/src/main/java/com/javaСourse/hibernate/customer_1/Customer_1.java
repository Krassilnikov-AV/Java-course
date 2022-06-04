package com.javaСourse.hibernate.customer_1;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@Table(name = "customers_1")
@NoArgsConstructor
public class Customer_1 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<CustomerProduct> products = new HashSet();

	@Override
	public String toString() {
		return "Customer_1 name: " + name;
	}
}
