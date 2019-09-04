package com.lucatinder.g3.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucatinder.g3.LucaTinderApplication;
import com.lucatinder.g3.dao.PerfilDAO;
import com.lucatinder.g3.modelo.ErrorPropio;
import com.lucatinder.g3.modelo.Perfil;
import com.lucatinder.g3.utilidades.FakePerfiles;


/**
 * Clase ServicioImpl
 * 
 * Clase para dirigir la logica de la aplicacion
 * 
 * @version 1.0
 * @author Jorge
 * 
 *         27/08/2019
 * 
 */

@Service
@Transactional
public class ServicioImpl implements Servicio {
	private static final Logger logger = LoggerFactory.getLogger(LucaTinderApplication.class);

	@Autowired
	private PerfilDAO perfilDao;
	@Autowired
	private ErrorPropio error;

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
		logger.info("Ejecutando el metodo newPerfil en la clase ServicioImpl");
		return perfilDao.newPerfil(p);

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
		return perfilDao.getPerfil(id);
	}
	/**
	 * Metodo setError
	 * 
	 * Metodo para mandar un mensaje de error
	 * 
	 * @param String msg Mensaje que muestra
	 * @return Error error
	 * @version 1.0
	 * @author Jorge
	 * 
	 *         27/08/2019
	 * 
	 */
	@Override
	public ErrorPropio setError(String msg) {
		logger.info("Ejecutando el metodo setError en la clase ServicioImpl");
		error.setMensaje(msg);
		return error;
	}

	


	/**
	 * Metodo getListaPerfil
	 * 
	 * Crea una lista de perfiles
	 * 
	 * @param int id del usuario que no se muestra
	 * @param int longitud longitud de la lista
	 * @return lista de perfiles
	 * @version 1.0
	 * @author Jorge
	 * @author Jesus
	 * 
	 *         28/08/2019
	 * 
	 */
	@Override
	 public List<Perfil> getListaPerfil(int id, int longitud) {
        logger.info("Ejecutando el metodo getListaPerfil en la clase ServicioImpl");
        List<Perfil> listPerfil = perfilDao.getListaPerfil(id, longitud);
        if (listPerfil.size()==longitud ) {
            return listPerfil;
        } else {
            crearPerfilFalso(longitud);
            listPerfil = perfilDao.getListaPerfil(id, longitud);
            return listPerfil;
        }
        
        
        
    }

		
	
	  /**
	   * Metodo crearPerfilFalso
	   * 
	   * crea una lissta de diversos perfiles falsos
	   * 
	   * @param int cantidad Nº de perfiles que crea
	   * @version 1.0
	   * @author Jesus
	   * 
	   *     28/08/2019
	   * 
	   */
	  
	  @Override
	  public void crearPerfilFalso(int cantidad) {
	    logger.info("Ejecutando el metodo CrearPerfilFalso en la clase ServicioImpl");
	     List<Perfil> listPerfil =FakePerfiles.perfilesRamdom(cantidad);
	    
	    for (int i = 0; i < listPerfil.size(); i++) {
	      Perfil p = newPerfil(listPerfil.get(i));
	    }
	    
	    
	  }
		/**
		 * Metodo setMensajeCrear
		 * 
		 * Metodo para mandar un mensaje
		 * 
		 * @param String msg Mensaje que muestra
		 * @return Error error
		 * @version 1.0
		 * @author Jorge
		 * 
		 *         27/08/2019
		 * 
		 */
	@Override
	public ErrorPropio setMensajeCrear(String msg) {
		error.setMensajeCreada(msg);
		return error;
	}

	/**
	 * Metodo listaContactos
	 * 
	 * Metodo para listar los perfiles a los que un perfil a dado a like
	 * 
	 * @param int id ,del perfil a consultar
	 * @return  lista de los contactos
	 * @version 1.0
	 * @author Jesus
	 * 
	 *         28/08/2019
	 * 
	 */
	@Override
	public List<Perfil> listaContactos(int id) {
		
		return perfilDao.listaContactos(id);
	}
	/**
	 * Metodo darLikes
	 * 
	 * Metodo para redireccionar al perfilDao al dar like
	 * 
	 * @param int id1 ,del perfil que da like
	 * @param int id2, id del perfil al que se le da like
	 * @return  void
	 * @version 1.0
	 * @author Jorge
	 * 
	 *         28/08/2019
	 * 
	 */
	@Override
	public boolean darLike(int id1, int id2) {
		logger.info("------- entrando en dar like");
		
		perfilDao.darLike(id1, id2);
		 boolean b = match(id1, id2);
		 return b;
		
		
	}
	/**
	 * @param id del perfil para que no se incluya en 
	 * @return Perfil p perfil seleccionado aleatoriamente entre todos nuestros usuarios
	 * @author jesus
	 */
	@Override
	public Perfil getPerfilRamdom(int id) {
		
		return perfilDao.getPerfilRamdom(id);
	}


	
	/**
	 * Metodo darDisLikes
	 * 
	 * Metodo para redireccionar al perfilDao al dar disLike
	 * 
	 * @param int id1 ,del perfil que da like
	 * @param int id2, id del perfil al que se le da disLike
	 * @return  void
	 * @version 1.0
	 * @author Jorge
	 * 
	 *         28/08/2019
	 * 
	 */
	@Override
	public void darDislike(int id1, int id2) {
		perfilDao.darDislike(id1, id2);
		
	}
	/**
	 * Metodo bajaPerfil()
	 * 
	 * Metodo para dar de baja un perfil
	 * 
	 * @param int id ,del perfil a dar de baja
	 * @return  void
	 * @version 1.0
	 * @author Jesus
	 * 
	 *         28/08/2019
	 * 
	 */
	@Override
	public void bajaPerfil(int id) {
		perfilDao.bajaPerfil(id);
		
	}
	/**
	 * Metodo listaContactos
	 * 
	 * Metodo para listar los perfiles a los que un perfil se ha dado dislike
	 * 
	 * @param int id ,del perfil que consulta
	 * @return  lista de los descartes
	 * @version 1.0
	 * @author Jorge
	 * 
	 *         28/08/2019
	 * 
	 */
	@Override
	public List<Perfil> listaDescartes(int id) {
	return perfilDao.listaDescartes(id);
	}

	
	/**
	 * Metodo match
	 * 
	 * comprueba si hay un mach y lo crea
	 * 
	 * @param int id1
	 * @param int id2
	 * @version 1.0
	 * @author jorge
	 * @author jesus
	 * 
	 *         04/09/2019
	 * 
	 */
	@Override
	public boolean match(int id1, int id2) {
		logger.info("------------entrando en match,servicios");
		if(perfilDao.comprobarLike(id1, id2)==true) {
			logger.info("----------hay match ");
			perfilDao.match(id1, id2);
			return true;
		}else {
			logger.info("----------------no hay match...todavia");
			return false;
		}
		
	}
	/**
	 * Metodo modificarPerfil
	 * 
	 * modifica el perfil
	 * 
	 * @param int id1 - del usuario que se van a cambiar los datos
	 * @param Perfil p - objeto perfil con los datos del usuario
	 * @return boolean - true si el cambio se ha efectuado, false si no
	 * @version 1.0
	 * @author jorge
	 * 
	 * 
	 *         04/09/2019
	 * 
	 */
	@Override
	public boolean modificarPerfil(int id, Perfil p) {
		return perfilDao.modifPerfil(id, p);
	}
		
	

}
