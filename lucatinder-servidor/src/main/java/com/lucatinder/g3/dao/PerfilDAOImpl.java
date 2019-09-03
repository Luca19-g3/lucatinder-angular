package com.lucatinder.g3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.lucatinder.g3.LucaTinderApplication;
import com.lucatinder.g3.modelo.Contacto;
import com.lucatinder.g3.modelo.Descarte;
import com.lucatinder.g3.modelo.Perfil;
import com.lucatinder.g3.utilidades.FakePerfiles;

/**
 * Clase PerfilDAOImpl
 * 
 * Clase para trabajar con la tabla Perfil en la base de datos.
 * 
 * @version 1.0
 * @author Jorge
 * 
 *         27/08/2019
 * 
 */

@Repository
public class PerfilDAOImpl implements PerfilDAO {
	private static final Logger logger = LoggerFactory.getLogger(LucaTinderApplication.class);

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Metodo newPerfil
	 * 
	 * Metodo para crear un nuevo Perfil
	 * 
	 * @param Perfil p Perfil que se va crear
	 * @return Perfil p Perfil que se va a crear
	 * @version 1.0
	 * @author Jorge
	 * 
	 *         27/08/2019
	 * 
	 */

	@Override
	public Perfil newPerfil(Perfil p) {
		logger.info("Ejecutando el metodo newPerfil en la clase PerfilDAOImpl");
		entityManager.merge(p);
		return p;
	}

	/**
	 * Metodo getPerfil
	 * 
	 * Metodo para encontrar un perfil por id
	 * 
	 * @param int id Id del perfil que se va a buscar
	 * @return Perfil p Perfil encontrado
	 * @version 1.0
	 * @author Jorge
	 * 
	 *         27/08/2019
	 * 
	 */

	@Override
	public Perfil getPerfil(int id) {
		logger.info("Ejecutando el metodo getPerfil en la clase ServicioImpl");
		return entityManager.find(Perfil.class, id);
	}

	/**
	 * Metodo getListaPerfil
	 * 
	 * Metodo para obtener una lista de usuarios con id distinto del id dado y
	 * longitud definida
	 * 
	 * @param int id Id del perfil a evitar en la lista de usuarios
	 * @param int longitud Longitud de la lista devuelta
	 * @return List<Perfil> Lista con n objetos de tipo Perfil obtenidos
	 * @version 1.0
	 * @author Joaquin
	 * 
	 *         28/08/2019
	 * 
	 */

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Perfil> getListaPerfil(int id, int longitud) {
		logger.info("Ejecutando el metodo getListaPerfil en la clase ServicioImpl");
		String hql = "FROM Perfil WHERE id != " + id;
		return (List<Perfil>) entityManager.createQuery(hql).setMaxResults(longitud).getResultList();
	}

	/**
	 * Metodo listContactos
	 * 
	 * metodo para pedir la lista de los perfiles likeados
	 * 
	 * @param la id del perfil a consultar
	 * @return List<Perfil> Lista de todos los perfiles a los que has dado like
	 * @version 1.0
	 * @author jesus
	 * 
	 *         28/08/2019
	 * 
	 */
	@Override
	public List<Perfil> listaContactos(int id) {
		logger.info("-------------------------------------------------  Entrando a Dao listContactos");
		Perfil p = getPerfil(id);
		List<Perfil> listContacto = new ArrayList<Perfil>();
		List contactos = p.getContactos1();
		for (int i = 0; i < contactos.size(); i++) {
			Contacto c = (Contacto) contactos.get(i);

			listContacto.add(c.getPerfil2());
		}
		logger.info("------------------" + listContacto.toString());
		return listContacto;
	}
	/**
	 * Metodo darLike
	 * 
	 * metodo para dar like
	 * 
	 * @param id 1 id del usuario que da like
	 * @param id 2 id del usuario que recibe el like
	 * @return void
	 * @version 1.0
	 * @author jesus
	 * 
	 *         28/08/2019
	 * 
	 */
	@Transactional
	@Override
	public void darLike(int id1, int id2) {
		logger.info("----------------------------------------Vamo a dar un like");
		Perfil p = getPerfil(id1);
		Perfil p2 = getPerfil(id2);
		Contacto c = new Contacto();
		c.setPerfil1(p);
		c.setPerfil2(p2);
		entityManager.merge(c);

	}
	
	/**
	 * Metodo comprobar like
	 * 
	 
	 * 
	 * @param id de los 2 usuarios
	 * @return leGusto boolean
	 * @version 1.0
	 * @author jorge
	 * @author jesus
	 * 
	 *         29/08/2019
	 * 
	 */
	public boolean comprobarLike(int id1, int id2) {
		boolean leGusto;
	
			logger.info("------Entrando en comprobar like, en un filo te digo si le gustas");
			Object o = entityManager.createNativeQuery("SELECT Count(id_contacto) FROM contacto WHERE id_contacto="+id1+" AND id_like="+id2).getSingleResult();
			String s = o.toString();
			int num = Integer.parseInt(s);	
			System.out.println(num);
			System.out.println("-----------"+o);
			if (num ==0 ) {
				logger.info("----no, bicho");
				leGusto = false;
			}else if(num==1){
				logger.info("----si, le gustas");
				leGusto = true;
			}else {
				logger.warn("WARNING---------------\n Nº de campos en la tabla =  "+num+"\n Comprueva campos repetidos (nº aceptables 0,1)");
				return true;
			}
			logger.info("---------------------------------------------------------------le gusto?-" + leGusto);
		return leGusto;
	}

	/**
	 * Metodo darDislike
	 * 
	 * Guarda los perfiles de un perfil que ha dado dislike y el perfil al que se lo ha dado
	 * 
	 * @param id de los 2 perfil, el Deslikeador y el Deslikeado
	 * @version 1.0
	 * @author jesus
	 * 
	 *         29/08/2019
	 * 
	 */
	
	@Transactional
	@Override
	public void darDislike(int id1, int id2)  {
		logger.info("----------------------------------------Entrando en dardislike");
		Perfil p = getPerfil(id1);
		Perfil p2 = getPerfil(id2);
		Descarte d = new Descarte();
		d.setPerfil1(p);
		d.setPerfil2(p2);
		entityManager.merge(d);
		logger.info(d.toString());
	}

	
	/**
	 * Metodo getPerfilRamdom
	 * 
	 * selecciona un perfil ramdom
	 * 
	 *@return Perfil p devuelve un perfil ramdom 
	 * @version 1.0
	 * @author jesus
	 * 
	 *         29/08/2019
	 * 
	 */
	
	@Override
	public Perfil getPerfilRamdom(int id) {
		logger.info("----------------------Entrando a getPerfilRamdom.");
		List<Perfil> list= getListaPerfil(id, 200);
		int idR = FakePerfiles.ramdomNumber(1, list.size());
		Perfil p = list.get(idR);
		p =list.get(idR);
	
		
		
		
		return p ;
	}

	
	/**
	 * Metodo bajaPerfil
	 * 
	 * borra un perfil determinado
	 * 
	 * 
	 * @param int id del perfil a borrar
	 * @version 1.0
	 * @author jesus
	 * 
	 *         03/09/2019
	 * 
	 */
	@Transactional
	@Override
	public void bajaPerfil(int id) {
		
		
		if(null!=getPerfil(id)){
			Perfil p = getPerfil(id);
			entityManager.remove(p);
		}else {
			logger.warn("perfil no encontrado");
		}
		
	}
	
	

}

	
	
	
