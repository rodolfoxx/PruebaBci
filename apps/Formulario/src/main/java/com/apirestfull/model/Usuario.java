package com.apirestfull.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Usuario {
		
	private String name;
    private String email;
	private String password;
	private String token;
		
	private BigDecimal  number;
	private BigDecimal  citycode;
	private BigDecimal  contrycode;

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
	
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
	public BigDecimal getCitycode() {
		return citycode;
	}
	public void setCitycode(BigDecimal citycode) {
		this.citycode = citycode;
	}
	public BigDecimal getContrycode() {
		return contrycode;
	}
	public void setContrycode(BigDecimal contrycode) {
		this.contrycode = contrycode;
	}
	

	
}
	