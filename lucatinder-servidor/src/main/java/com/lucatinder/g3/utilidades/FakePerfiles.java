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
	 * @param min_num
	 * @param max_num
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
		System.out.println("-------entrando en ramdomPhoto el sexo del suso dicho es : "+sex);
		int f =0;
		Faker faker = new Faker();
		String fotos[]={"https://i.pinimg.com/564x/ae/12/f3/ae12f3d971446580bbe9382bfcccdf61.jpg",//fotos de hombres
				"https://i.pinimg.com/564x/44/30/f6/4430f624fd5e10691f3a93c4886d305b.jpg",
				"https://www.sabervivirtv.com/medio/2018/11/23/hipertension_1a1e0809_550x400.jpg",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwaoRc1AkYf1vlHNQIRD9JF0zDF770HRqo4jUE6CkhO83uB5uU4Q",
				"https://media.revistagq.com/photos/5ca5e1cff552a1f4ee32b417/16:9/w_1920,c_limit/hombres_feos_mas_guapos__715924495.jpg",
				"https://img.freepik.com/foto-gratis/calle-moda-estilo-pelo-hermosa-chica_1139-844.jpg?size=626&ext=jpg",//fotos de mujeres
				"https://static3.elnortedecastilla.es/www/multimedia/201804/30/media/cortadas/charochavez-k9lB-U501770736203hqG-624x385@El%20Norte.jpg",
				"https://cflvdg.avoz.es/default/2018/09/19/00121537365182538957814/Foto/SFS7P6F8_15520.jpg",
				"https://i1.wp.com/www.modelstockphoto.com/wp-content/uploads/2019/03/Sesion-de-fotos-book-test-de-modelos.jpg?fit=1254%2C836",
				"",};
		
		
		if(sex.equals("M")) {
			f =ramdomNumber(0,4);
			System.out.println("---------el sexo es H y el ramdom es "+f);
		return  fotos[f];
		}else if(sex.equals("F")) {
			f =ramdomNumber(5,9);
			System.out.println("el sexo es F y el ramdom es "+f);
		return fotos[f];
		}else{
			System.out.println("-----------------------------no reconocido el sexo retorno nulo");
		return null ;
		}
		
	}
}