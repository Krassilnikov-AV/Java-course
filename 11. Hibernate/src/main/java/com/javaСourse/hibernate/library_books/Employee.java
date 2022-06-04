package com.javaСourse.hibernate.library_books;

import javax.persistence.*;

@Entity
@Table(name = "employee_info")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "id")
	Long id;

	@OneToOne
	@JoinColumn(name = "info")
	Employee employee;
}