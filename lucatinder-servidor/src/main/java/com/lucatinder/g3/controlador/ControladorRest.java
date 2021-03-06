package com.lucatinder.g3.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lucatinder.g3.LucaTinderApplication;
import com.lucatinder.g3.modelo.Perfil;
import com.lucatinder.g3.servicios.Servicio;

/**
 * Clase ControladorRest
 * 
 * Controlador REST para dirigir el flujo web y los datos que recibe el Front
 * 
 * @version 1.0
 * @author Jorge
 * 
 *         27/08/2019
 * 
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControladorRest {
	private static final Logger logger = LoggerFactory.getLogger(LucaTinderApplication.class);

	@Autowired
	private Servicio servicio;
	/**
	 * Método newPerfil
	 * 
	 * Método para crear un nuevo perfil
	 * 
	 * @param int id Id del perfil al que se mostrará la lista
	 * @return Perfil p - Perfil que se ha creado
	 * @version 1.0
	 * @author Jorge
	 * 
	 *         29/08/2019
	 * 
	 */
	@PostMapping(value = "/newrest")
	public Perfil newPerfil(@RequestBody Perfil p) {
		return servicio.newPerfil(p);
		
	}

	/**
	 * Método obtenerPerfilesRest
	 * 
	 * Método para obtener una lista de 20 perfiles a través de REST
	 * 
	 * @param int id Id del perfil al que se mostrará la lista
	 * @return List<Perfil> Lista con 20 objetos de tipo Perfil
	 * @version 1.0
	 * @author Joaquin
	 * 
	 *         29/08/2019
	 * 
	 */

	@GetMapping(value = "/perfilesrest")
	public List<Perfil> obtenerPerfilesRest(@RequestParam("id") int id) {
		logger.info("-----Ejecutando el metodo obtenerPerfilesRest en la clase ControladorRest");
		return servicio.getListaPerfil(id, 20);
	}

	/**
	 * Método obtenerContactosRest
	 *
	 * Método para obtener los Contactos de un usuario través de REST
	 *
	 * @param int id Id del perfil al que le mostraras los contactos
	 * @return List<Perfil> Lista con los perfiles de contactos
	 * @version 1.0
	 * @author Jorge
	 *
	 *         29/08/2019
	 *
	 *
	 *
	 */
	

	@GetMapping(value = "/contactosrest")
	public List<Perfil> obtenerContactosRest(@RequestParam("id") int id) {
		logger.info("-----Ejecutando el metodo obtenerPerfilesRest en la clase ControladorRest");
		return servicio.listaContactos(id);
	}
	
	/**
	 * retorna un usuario aleatorio 
	 * 
	 * @param int id id del perfil que esta logeado
	 * @return perfil p un perfil aleatorio
	 * 
	 * @author jesus
	 */
	
	@GetMapping(value = "/getperfilrandomrest")
	public Perfil getperfilrandomrest(@RequestParam("id") int id) {
		logger.info("---------ejecutando getPerfilRandomRest");
		
		return servicio.getPerfilRamdom(id);
	}
	
	/**
	 * borra un perfil
	 * 
	 * @param id del perfil a borrar
	 * 
	 * @author jesus
	 *     03/09/2019
	 */
	
	@GetMapping(value = "/bajaperfilrest")
	public void bajaPerfilRest(@RequestParam("id") int id) {
		logger.info("---------ejecutando bajaPerfil");
		servicio.bajaPerfil(id);
	}
	
	/**
	 * devuelve un perfil determinado
	 * 
	 * @param id del perfil que solicita
	 * 
	 * @author jesus
	 * 
	 *   03/09/2019
	 */
	
	@GetMapping(value = "/getperfilrest")
	public Perfil getPerfilRest(@RequestParam("id") int id) {
		logger.info("---------ejecutando get perfil rest");
		Perfil p = servicio.getPerfil(id);
		return p;
		
	}
	
	/**
	 * Método obtenerDescartesRest
	 *
	 * Método para obtener los Descartes de un usuario través de REST
	 *
	 * @param int id Id del perfil al que le mostraras los descartes
	 * @return List<Perfil> Lista con los perfiles de descartes
	 * @version 1.0
	 * @author Jorge
	 *
	 *         29/08/2019
	 *
	 *
	 *
	 */
	

	@GetMapping(value = "/descartesrest")
	public List<Perfil> obtenerDescartesRest(@RequestParam("id") int id) {
		logger.info("-----Ejecutando el metodo obtenerDescartesRest en la clase ControladorRest");
		logger.info("----------------------------"+servicio.listaDescartes(id));
		return servicio.listaDescartes(id);
	
	}
	/**
	 * Método login
	 *
	 * Metodo para entrar a la aplicacion
	 *
	 * @param int id Id del perfil aque logea
	 * @return Perfil p - Perfil que se logea
	 * @version 1.0
	 * @author Jorge
	 *
	 *         29/08/2019
	 *
	 *
	 *
	 */
	@GetMapping(value = "/entrarrest")
	public Perfil login(@RequestParam("id") int id) {
		Perfil p = servicio.getPerfil(id);
		return p;
	}
	
	/**
	 * Método login
	 *
	 * Metodo para entrar a la aplicacion
	 *
	 * @param int id1 
	 * @param int id2
	 * @return boolean si es true se ha creado un match y si es false no se ha creado
	 * @version 1.0
	 * @author Jesus
	 *
	 *         04/09/2019
	 *-----hay que cambiar el return
	 *
	 *
	 */
	
	@GetMapping(value = "/darlikerest")
	public boolean darLike(@RequestParam("id1") int id1, @RequestParam("id2") int id2) {
		logger.info("-----------------ejecutando dar like");
		boolean b = servicio.darLike(id1, id2);
		return b;
	}
	/**
	 * Método darDisLike
	 *
	 * 
	 *
	 * @param int id1 
	 * @param int id2
	 * @version 1.0
	 * @author Jesus
	 *
	 *         04/09/2019
	 *
	 */
	
	@GetMapping(value = "/dardislikerest")
	
	public void darDislike(@RequestParam("id1") int id1, @RequestParam("id2") int id2) {
		logger.info("-----------------ejecutando dar dislike ");
		servicio.darDislike(id1, id2);
		
	}
	/**
	 * Método darDisLike
	 *
	 * 
	 *
	 * @param int id1 
	 * 
	 * @version 1.0
	 * @author Jorge
	 * @return List<Perfil> - Lista de los perfiles con los que tiene match
	 *         05/09/2019
	 *
	 */
	
	@GetMapping(value = "/listarmatchesrest")
	public List<Perfil> listarMatches(@RequestParam("id") int id) {
		logger.info("-----Ejecutando el metodo ListarMatches en la clase ControladorRest");
		return servicio.listarMatches(id);
	}
	
	/**
	 * Método actualizarPerfil
	 *
	 * Método para actualizar un perfil.
	 * 
	 * @param Perfil p objeto perfil con los datos del perfil a actualizar 
	 * @param int id del usuario a actualizar 
	 * 
	 * @version 1.0
	 * @author Joaquin
	 * @return boolean - true = el perfil se ha actualizado | false = el perfil no se ha actualizado
	 *         05/09/2019
	 *
	 */
	
	@PostMapping(value = "/actualizarperfil")
	public boolean actualizarPerfil(@RequestBody Perfil p) {
		logger.info("-----Ejecutando el metodo actualizarPerfil en la clase ControladorRest");
		return servicio.modificarPerfil(p.getId(), p);
	}
	

}
