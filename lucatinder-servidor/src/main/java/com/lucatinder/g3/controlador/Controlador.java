package com.lucatinder.g3.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lucatinder.g3.LucaTinderApplication;
import com.lucatinder.g3.modelo.ErrorPropio;
import com.lucatinder.g3.modelo.Perfil;
import com.lucatinder.g3.servicios.Servicio;

/**
 * Clase Controlador
 * 
 * Controlador MVC para dirigir el flujo web y los datos que recibe el Front
 * 
 * @version 1.0
 * @author Jorge
 * 
 *         27/08/2019
 * 
 */

@Controller
public class Controlador {

	private static final Logger logger = LoggerFactory.getLogger(LucaTinderApplication.class);
	@Autowired
	private Servicio servicio;

	/**
	 * Metodo palIndex
	 * 
	 * Metodo para crear un nuevo Perfil
	 * 
	 * @param Perfil p Perfil que se va crear
	 * @return index.html
	 * @version 1.0
	 * @author Jorge
	 * 
	 *         27/08/2019
	 * 
	 */
	@GetMapping("/")
	public ModelAndView palIndex(@ModelAttribute("perfil") Perfil p, ErrorPropio e) {
		ModelAndView model = new ModelAndView("index");

		e = new ErrorPropio();
		model.addObject("errorpropio", e);
		return model;
	}

	/**
	 * Metodo login
	 * 
	 * Metodo para entrar a la aplicacion
	 * 
	 * @param ModelMap    model guarda el perfil que ha logeado
	 * @param             int id Id que introduce el usuario
	 * @param ErrorPropio e - Devuelve un mensaje de error si el cliente mete mal el
	 *                    id
	 * @return paginaPerfil.html
	 * @version 1.0
	 * @author Jorge
	 * 
	 *         27/08/2019
	 * 
	 */

	@PostMapping("/entrar")
	public ModelAndView login(@RequestParam("id") int id, ErrorPropio e, Perfil p) {
		logger.info("****************************Intentando entrar");

		ModelAndView model;
		if (servicio.getPerfil(id) == null) {
			model = new ModelAndView("index");
			e.setMensajeCreada(" ");
			e.setMensaje("Este id no existe");
			model.addObject("errorpropio", e);
			logger.info("******************************************************************" + e.getMensaje());
		} else {
			model = new ModelAndView("paginaPerfil");
			p = servicio.getPerfil(id);
			model.addObject("perfil", p);
			model.addObject("listaperfil", servicio.getListaPerfil(p.getId(), 20));

		}
		return model;
	}

	/**
	 * Metodo newPerfil
	 * 
	 * Metodo para crear un nuevo Perfil
	 * 
	 * @param Perfil p Perfil que se va crear
	 * @return model
	 * @version 1.0
	 * @author Jorge
	 * 
	 *         27/08/2019
	 * 
	 */
	@PostMapping("/new")
	public ModelAndView newPerfil(@ModelAttribute("perfil") Perfil p, ErrorPropio e) {
		logger.info("**************************************GUARDANDO Perfil");
		servicio.newPerfil(p);
		logger.info("******************************Perfil GUARDADO" + p.toString());
		ModelAndView model = new ModelAndView("index");
		e = new ErrorPropio();
		e.setMensaje(" ");
		e.setMensajeCreada("Tu cuenta ha sido creada.");
		model.addObject("errorpropio", e);

		return model;
	}

	/**
	 * Metodo listarContactos
	 * 
	 * lista los contactos del perfil al que pertenece la id
	 * 
	 * @param int id la id del perfil , perfil p el mismo perfil de la id
	 * @return model
	 * @version 1.0
	 * @author Jesus
	 * 
	 *         28/08/2019
	 * 
	 */
	@GetMapping("/listarContactos")
	public ModelAndView listarContactos(@RequestParam("id") int id, Perfil p) {
		p = servicio.getPerfil(id);
		logger.info("****************************Entrando en listarContactos");
		ModelAndView model = new ModelAndView("contactos");
		List<Perfil> lista = servicio.listaContactos(id);
		model.addObject("listaContacto", lista);
		model.addObject("id", p.getId());
		return model;
	}

	/**
	 * Metodo encuentros
	 * 
	 * redirecciona a la web selector y pasa los parametros necesarios
	 * 
	 * @param int id - id del usuario que va a dar like o dislike
	 * @return model
	 * @version 1.0
	 * @author Jorge
	 * 
	 *         28/08/2019
	 * 
	 */
	
	
	@GetMapping("/encuentros")
	public ModelAndView selector(@RequestParam("id")int id) {
		ModelAndView model = new ModelAndView("selector");
		model.addObject("id", id);
		Perfil p = servicio.getPerfilRamdom(id);
		model.addObject("perfil",p);
		
		return model;
	}
	/**@author Jorge
	 * guarda el like
	 * @param id id del perfil que da a like
	 * @param Perfil p perfil al que da like
	 * @return model
	 */
	
	@GetMapping("/darLike")
	public ModelAndView darLike(@RequestParam("id") int id, Perfil p) {

		ModelAndView model = new ModelAndView("selector");
		model.addObject("id", id);
		p = servicio.getPerfilRamdom(id);
		servicio.darLike(id, p.getId());
		model.addObject("perfil", p);
		return model;
	}
	
	/** @author Jesus y Jorge
	 * guarda el dislike
	 * @param id1 id del perfil que da a dislike
	 * @param Perfil p - perfil al que se le da el dislike
	 * @return model
	 */
	@GetMapping("/darDisLike")
	public ModelAndView darDislike(@RequestParam("id") int id, Perfil p) {
		ModelAndView model = new ModelAndView("selector");
		model.addObject("id", id);
		 p = servicio.getPerfilRamdom(id);
		 servicio.darDislike(id, p.getId());
		model.addObject("perfil", p);
		return model;
	}

}
