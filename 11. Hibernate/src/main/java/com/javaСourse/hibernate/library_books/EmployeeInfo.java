package com.javaСourse.hibernate.library_books;

import javax.persistence.*;


// CREATE TABLE employees (id serial, info_id id, FOREIGN KEY (info_id) REFERENCES emp_info);
// CREATE TABLE emp_info (id serial, details text, PRIMARY KEY (id));
@Entity
@Table(name = "employees")
public class EmployeeInfo {

	@Id
	@GeneratedValue
	@Column(name = "id")
	Long id;

	@OneToOne
	@JoinColumn(name = "info_id")
	EmployeeInfo info;
}