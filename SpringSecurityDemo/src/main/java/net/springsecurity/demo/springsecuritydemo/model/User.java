package net.springsecurity.demo.springsecuritydemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "role")
	private Role role;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "status")
	private Status status;

	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Role getRole() {
		return role;
	}
	public Status getStatus() {
		return status;
	}
}