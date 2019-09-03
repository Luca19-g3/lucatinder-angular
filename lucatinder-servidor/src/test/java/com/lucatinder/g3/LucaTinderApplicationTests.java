package com.lucatinder.g3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lucatinder.g3.dao.PerfilDAO;
import com.lucatinder.g3.modelo.Perfil;
import com.lucatinder.g3.utilidades.FakePerfiles;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LucaTinderApplicationTests {

	 @Autowired
	 private PerfilDAO perfil;
	 
	@Test
	public void contextLoads() {
		
		getPerfilRamdom();
		
	}
	
	/**
	 * pruevas del javafaker crear 1 perfil ramdom
	 * @author jesus
	 */
	
	 public static void probadorFakerPerfil() {
		 Perfil p = FakePerfiles.perfilRandom();
			System.out.println("-------------------------------------------------------------------------------");
			 System.out.println(p);
			  assertNotEquals(null, p.getCorreo());
			  assertNotEquals(null, p.getEdad());
			  assertNotEquals(null, p.getGenero());
			  assertNotEquals(null, p.getPassword());
			  assertNotEquals(null, p.getNombre());
			  assertNotEquals(null, p.getDescripcion()); 
			  
		 }
	 
		/**
		 * pruevas del javafaker crear 20 perfiles falsos
		 * @author jesus
		 */
	 
	 public static void probadorFakeArrayPerfiles() {
		 
		ArrayList<Perfil> listPerfil = new ArrayList<Perfil>();
		
		 
	/*	listPerfil = FakePerfiles.perfilesRamdom(20); */
		
		listPerfil.toString();
		 assertEquals(20, listPerfil.size());
		 
		
		 
	 }
	 /*
	  *
	  * @author Jorge
	  * 
	  * 
	  * pruebar si va el metodo comprobarLike
	  * 
	  * 
	  */
	 
	 public void pruebaLike() {

		 
		 boolean prueba = perfil.comprobarLike(1, 2);
		 System.out.println("prueba");
		 assertTrue(prueba);
		 
		 
		 
	 }
	 
	 public void pruebadislike() {
		 perfil.darDislike(5, 55);
		 System.out.println("--------------------------------------------dislike dao -");
		 perfil.darLike(5, 54);
		 System.out.println("--------------------------------------------like dao -");
		 
	 }
	 public void getPerfilRamdom() {
		 perfil.getPerfilRamdom(1);
	 }
	 
}
	 
	 