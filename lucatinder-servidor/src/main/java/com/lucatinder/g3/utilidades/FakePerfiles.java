package com.lucatinder.g3.utilidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.javafaker.Faker;
import com.lucatinder.g3.modelo.Perfil;


	

public class FakePerfiles {


	/** 
	 * crea un unico perfil falso.
	 *
	 * 
	 * @return Perfil devuelve un objeto de tipo perfil aleatorio
	 * @author jesus
	 */

	public static Perfil perfilRandom() {
		Logger logger = LoggerFactory.getLogger(FakePerfiles.class);
		logger.info("entrando en perfilRamdom");
		Perfil p = new Perfil();
		Faker faker = new Faker(new Locale("ES"));
		
		
		String fullName = faker.name().fullName();
		String firstName = fullName.substring(fullName.lastIndexOf(' '));

		int ramdomN = faker.number().numberBetween(0, 1);
		String sex;
		if (ramdomN == 0) {
			sex = "M";
		} else {
			sex = "F";
		}

		int ramdomN2 = faker.number().numberBetween(0, 3);
		String prefer;
		if (ramdomN2 == 0) {
			prefer = "M";
		} else if (ramdomN2 == 1) {
			prefer = "F";
		} else {
			prefer = "A";
		}
		

		p.setCorreo(firstName + "@lucatinder.org");
		p.setNombre(fullName);
		p.setDescripcion(faker.yoda().quote());
		p.setEdad(faker.number().numberBetween(18, 90));
		p.setGenero(sex);
		p.setPassword(faker.lorem().characters(8, 16));
		p.setPreferencias(prefer);
		p.setImg(ramdomPhoto( sex));
		logger.info("saliendo de perfilRamdom");
		
		


		
		return p;
	}
	
	/**
	 *  genera un arraylist de perfiles aleatorios
	 * @param cantidad tamaño del arraylist que devuelve
	 * @return listPerfil devuelve una lista de perfiles aleatorios
	 * @author jesus
	 */

	public static List<Perfil> perfilesRamdom(int cantidad) {
		Logger logger = LoggerFactory.getLogger(FakePerfiles.class);
		logger.info("entrando en perfilesRamdom");
		List<Perfil> listPerfil = new ArrayList<Perfil>();
		
		while (cantidad>0) {
			cantidad--;
			listPerfil.add(perfilRandom());

		}

		return listPerfil;
	}

	/** ramdomNumber
	 * 
	 * debuelve un numero aleatorio
	 * @param min_num  valor minimo
	 * @param max_num valor maximo
	 * @return ramdom number
	 * @author jesus
	 * 28/08/2019
	 */
	public static int ramdomNumber(int min_num,int max_num) {
		Faker faker = new Faker();
		return max_num = faker.number().numberBetween(min_num, max_num);
		
	}
	/** metodo ramdomPhoto
	 * 
	 * debuelve una foto teniendo en cuenta el sexo del perfil
	 * 
	 * @param String sex 
	 * @return String foto
	 * @author jesus
	 * 05/09/2019
	 */
	
	  public static String ramdomPhoto(String sex) {
	        
	        
	        
	        if(sex.equals("M")) {
	            
	            
	        return  "https://source.unsplash.com/random/900%C3%97700/?man";
	        }else if(sex.equals("F")) {
	            
	            
	        return "https://los40mx00.epimg.net/los40/imagenes/2017/04/19/moda/1492632196_480234_1492632619_noticia_normal.jpg";
	        }else{
	            
	        return null ;
	        }
	        
	    }
	
}