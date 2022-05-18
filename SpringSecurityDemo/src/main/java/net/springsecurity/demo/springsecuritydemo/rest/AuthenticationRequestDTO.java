package net.springsecurity.demo.springsecuritydemo.rest;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {

	private String email;
	private String password;


	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}