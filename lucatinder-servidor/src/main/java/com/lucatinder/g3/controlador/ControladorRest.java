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
	 * @param int id la id del perfil para conseguir una busqueda optima
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
		logger.info("-----Ejecutando el metodo obtenerPerfilesRest en la clase ControladorRest");
		return servicio.listaDescartes(id);
	
	}

}
