package com.javaСourse.hibernate.advencied;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "id")
	Long id;

	@Column(name = "title")
	String title;

	@Column(name = "price")
	BigDecimal price;


	@ManyToOne
	@JoinColumn(name="manufacturer_id")
	Manufacturer manufacturer;

}