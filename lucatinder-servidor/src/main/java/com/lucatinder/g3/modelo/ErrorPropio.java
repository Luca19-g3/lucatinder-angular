package com.lucatinder.g3.modelo;



import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;



/**
 * Clase Perfil
 * 
 * Clase para gestionar los errores
 *
 * @version 1.0
 * @author Jorge
 * 
 * 27/08/2019
 * 
 */
@Component("errorpropio")
@Entity
public class ErrorPropio {
	@Id
	private String mensaje;
	private String mensajeCreada;
	
	
	public ErrorPropio() {
		
	}

	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensajeCreada() {
		return mensajeCreada;
	}

	public void setMensajeCreada(String mensajeCreada) {
		this.mensajeCreada = mensajeCreada;
	}

	@Override
	public String toString() {
		return "ErrorPropio [mensaje=" + mensaje + ", mensajeCreada=" + mensajeCreada + "]";
	}



	
	
	
	
}
