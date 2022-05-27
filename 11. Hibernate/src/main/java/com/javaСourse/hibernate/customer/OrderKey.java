package com.javaСourse.hibernate.customer;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class OrderKey implements Serializable {

	static final long serialVersionUID = 1L;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "product_id")
	private Long productId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderKey)) return false;
		OrderKey orderKey = (OrderKey) o;
		return Objects.equals(getCustomerId(), orderKey.getCustomerId()) &&
			Objects.equals(getProductId(), orderKey.getProductId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCustomerId(), getProductId());
	}

	@Override
	public String toString() {
		return "OrderKey: [" +
			"customerId = " + customerId +
			", productId = " + productId +
			']';
	}
}
