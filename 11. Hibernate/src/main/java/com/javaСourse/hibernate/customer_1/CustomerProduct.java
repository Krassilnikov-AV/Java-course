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

		@Column(name = "product_price")
		private Long product_price;

		public cpID() {
		}

		public cpID(Long customer_id, Long product_id, Long product_price) {
			this.customer_id = customer_id;
			this.product_id = product_id;
			this.product_price = product_price;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			cpID cpID = (cpID) o;
			return Objects.equals(customer_id, cpID.customer_id) &&
				Objects.equals(product_id, cpID.product_id) &&
				Objects.equals(product_price, cpID.product_price);
		}

		@Override
		public int hashCode() {
			return Objects.hash(customer_id, product_id, product_price);
		}
	}

	@EmbeddedId
	private cpID id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("customer_id")
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("product_id")
	private Product product;

	@Column(name = "product_price", insertable = false, updatable = false)
	private Double price;
}