package com.lucatinder.g3.dao;

import java.util.List;

import com.lucatinder.g3.modelo.Perfil;
/**
 * Interface PerfilDAO
 * 
 * Interface para trabajar con la tabla Perfil en la base de datos.
 * @version 1.0
 * @author Jorge
 * 
 * 27/08/2019
 * 
 */
public interface PerfilDAO {

	public Perfil newPerfil(Perfil p);
	public Perfil getPerfil(int id);
	public List<Perfil> getListaPerfil(int id, int longitud);
	public List<Perfil> listaContactos(int id);
	public void darLike(int id1, int id2);
	public void darDislike(int id1, int id2);
	public boolean comprobarLike(int id1, int id2);
	public Perfil getPerfilRamdom(int id);
	public void bajaPerfil(int id);
	public List<Perfil> listaDescartes(int id);
	public List<Perfil> listaMatches(int id);
}
