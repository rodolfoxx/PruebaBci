package com.apirestfull.vo;

import java.io.Serializable;

/**
 * 
 * @author JCarrenca
 *
 */
public class MensajeVO implements Serializable {
	
	
	private String id;
	private String created;
	private String modified;
	private String last_login;
	private String token;
	private String isactive;
	private String codigores;

	public MensajeVO(String codigores,String id,String created,String modified, String last_login,String token,String isactive){
		this.setId(id);
		this.setCreated(created);
		this.setModified(modified);
		this.setLast_login(last_login);
		this.setToken(token);
		this.setIsactive(isactive);
		this.setCodigores(codigores);
	
	}

	public String getId() {
		return id;
	}

	public String getCodigores() {
		return codigores;
	}

	public void setCodigores(String codigores) {
		this.codigores = codigores;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	
	


	
	

}
