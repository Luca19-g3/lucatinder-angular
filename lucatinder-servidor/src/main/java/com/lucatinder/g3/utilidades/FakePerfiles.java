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

	
	public static int ramdomNumber(int min_num,int max_num) {
		Faker faker = new Faker();
		return max_num = faker.number().numberBetween(min_num, max_num);
		
	}

}