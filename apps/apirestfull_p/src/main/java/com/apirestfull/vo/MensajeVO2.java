package com.apirestfull.vo;

import java.io.Serializable;

/**
 * 
 * @author JCarrenca
 *
 */
public class MensajeVO2 implements Serializable {
	
	
	private String error;


	public MensajeVO2(String error){
		this.setError(error);

	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	




	
	

}
