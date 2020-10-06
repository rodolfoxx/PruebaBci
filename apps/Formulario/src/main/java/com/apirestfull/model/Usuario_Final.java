package com.apirestfull.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Usuario_Final {
		
	private String name;
    private String email;
	private String password;
	private String token;
		

	private ArrayList phones;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ArrayList getPhones() {
		return phones;
	}
	public void setPhones(ArrayList phones) {
		this.phones = phones;
	}
	

	
}
	