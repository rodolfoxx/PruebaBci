package com.apirestfull.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class UsuarioP {
		

	private ArrayList phones;
	
	private String  number;
	private String  citycode;
	private String  contrycode;
	
	public ArrayList getPhones() {
		return phones;
	}
	public void setPhones(ArrayList phones) {
		this.phones = phones;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getContrycode() {
		return contrycode;
	}
	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}
	

	
}
	