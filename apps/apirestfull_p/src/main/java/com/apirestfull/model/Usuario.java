package com.apirestfull.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator",
		parameters = {
			@Parameter(
				name = "uuid_gen_strategy_class",
				value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
			)
		}
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	private String name;
    private String email;
	private String password;
	
	@CreationTimestamp
	private Date updatedAt;
	
	@CreationTimestamp
	private Date createdAt;

	private ArrayList phones;
	
	private BigDecimal  number;
	private BigDecimal  citycode;
	private BigDecimal  Contrycode;
	
	private String token;
	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
		return Contrycode;
	}

	public void setContrycode(BigDecimal contrycode) {
		Contrycode = contrycode;
	}

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
	
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public ArrayList getPhones() {
		return phones;
	}

	public void setPhones(ArrayList phones) {
		this.phones = phones;
	}
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}



	
}
	