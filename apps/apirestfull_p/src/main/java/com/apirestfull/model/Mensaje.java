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


public class Mensaje {
	
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public String setMensaje(String mensaje) {
		return this.mensaje = mensaje;
	}

	
}
	