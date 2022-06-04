package com.javaСourse.hibernate.customer_1;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "customer_product_1")
@NoArgsConstructor
public class CustomerProduct {

	@Data
	@Embeddable
	public static class cpID implements Serializable {

		@Column(name = "customer_id")
		private Long customer_id;

		@Column(name = "product_id")
		private Long product_id;

		@Column(name = "cost")
		private Long cost;

		public cpID() {
		}

		public cpID(Long customer_id, Long product_id, Long cost) {
			this.customer_id = customer_id;
			this.product_id = product_id;
			this.cost = cost;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			cpID cpID = (cpID) o;
			return Objects.equals(customer_id, cpID.customer_id) &&
				Objects.equals(product_id, cpID.product_id) &&
				Objects.equals(cost, cpID.cost);
		}

		@Override
		public int hashCode() {
			return Objects.hash(customer_id, product_id, cost);
		}
	}

	@EmbeddedId
	private cpID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("customer_id")
	private Customer_1 customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("product_id")
	private Product product;

	@Column(name = "cost", insertable = false, updatable = false)
	private Double cost;

	public CustomerProduct(Customer_1 customer, Product product) {
		this.customer = customer;
		this.product = product;
		this.id = new cpID(customer.getId(), product.getId(), (long) product.getPrice());
		this.cost = product.getPrice();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomerProduct that = (CustomerProduct) o;
		return
			customer.equals(that.customer) &&
			product.equals(that.product);
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer.getName(), product.getName(), cost);
	}

	@Override
	public String toString() {
		return ("Customer " +customer.getName() + " buy " + product.getName() + " for "+ cost);
	}
}