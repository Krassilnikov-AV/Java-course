package com.javaСourse.hibernate.advencied;


import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
@ToString
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "id")
	Long id;

	@Column(name = "name")
	String name;
}