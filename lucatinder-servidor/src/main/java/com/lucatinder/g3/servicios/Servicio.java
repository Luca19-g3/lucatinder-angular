package com.lucatinder.g3.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucatinder.g3.modelo.ErrorPropio;
import com.lucatinder.g3.modelo.Perfil;
@Service
public interface Servicio {
	/**
	 * Interface ServicioImpl
	 * 
	 * Interface para dirigir la logica de la aplicacion
	 * @version 1.0
	 * @author Jorge
	 * 
	 * 27/08/2019
	 * 
	 */
	public List<Perfil> getListaPerfil(int id, int longitud);
	public Perfil newPerfil(Perfil p);
	public Perfil getPerfil(int id);
	public ErrorPropio setError(String msg);
	public void crearPerfilFalso(int cantidad);
	public ErrorPropio setMensajeCrear(String msg);
	public List<Perfil> listaContactos(int id);
	public void darLike(int id1, int id2);
	public Perfil getPerfilRamdom(int id);
	public void darDislike(int id1, int id2);
}
