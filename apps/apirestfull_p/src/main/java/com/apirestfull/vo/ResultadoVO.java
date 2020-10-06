package com.apirestfull.vo;
import java.io.Serializable;

/**
 * 
 * @author JCarrenca
 *
 */
public class ResultadoVO implements Serializable {


	private MensajeVO mensaje;
	

	public MensajeVO getMensaje() {
		return mensaje;
	}

	public void setMensaje(String codigores,String id,String created,String modified, String last_login,String token,String isactive) {
		MensajeVO mensaje2 = new MensajeVO(codigores,id,created,modified,last_login,token,isactive);
		this.mensaje = mensaje2;
	}
	
	public void setMensaje(MensajeVO mensajeVO) {
		this.mensaje = mensajeVO;
	}
	
	
}


