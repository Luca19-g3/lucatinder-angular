package com.lucatinder.g3.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;



/**
 * Clase Perfil
 * 
 * Clase para modelar los datos de los perfiles.
 *
 * @version 1.0
 * @author Joaquin
 * 
 * 27/08/2019
 * 
 */



	
	@Entity
	@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
	public class Perfil implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name="id_perfil")
		private int id;

		private String correo;

		@Lob
		private String descripcion;

		private int edad;

		private char genero;

		private String nombre;

		private String password;

		private char preferencias;

		//bi-directional many-to-one association to Contacto 
		//---aqui se guardan los perfiles a los que a dado like---
		@OneToMany(mappedBy="perfil1")
		@JsonManagedReference
		private List<Contacto> contactos1;

		//bi-directional many-to-one association to Contacto
		//---aqui se guardan los perfiles que han dado a like al Perfil---
		@OneToMany(mappedBy="perfil2")
		@JsonManagedReference
		private List<Contacto> contactos2;

		//bi-directional many-to-one association to Descarte
		@OneToMany(mappedBy="perfil1")
		@JsonManagedReference
		private List<Descarte> descartes1;

		//bi-directional many-to-one association to Descarte
		@OneToMany(mappedBy="perfil2")
		@JsonManagedReference
		private List<Descarte> descartes2;

		public Perfil() {
		}

		public int getId() {
			return this.id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCorreo() {
			return this.correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public String getDescripcion() {
			return this.descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public int getEdad() {
			return this.edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public char getGenero() {
			return this.genero;
		}

		public void setGenero(char genero) {
			this.genero = genero;
		}

		public String getNombre() {
			return this.nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getPassword() {
			return this.password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public char getPreferencias() {
			return this.preferencias;
		}

		public void setPreferencias(char preferencias) {
			this.preferencias = preferencias;
		}

		public List<Contacto> getContactos1() {
			return this.contactos1;
		}

		public void setContactos1(List<Contacto> contactos1) {
			this.contactos1 = contactos1;
		}

		public Contacto addContactos1(Contacto contactos1) {
			getContactos1().add(contactos1);
			contactos1.setPerfil1(this);

			return contactos1;
		}

		public Contacto removeContactos1(Contacto contactos1) {
			getContactos1().remove(contactos1);
			contactos1.setPerfil1(null);

			return contactos1;
		}

		public List<Contacto> getContactos2() {
			return this.contactos2;
		}

		public void setContactos2(List<Contacto> contactos2) {
			this.contactos2 = contactos2;
		}

		public Contacto addContactos2(Contacto contactos2) {
			getContactos2().add(contactos2);
			contactos2.setPerfil2(this);

			return contactos2;
		}

		public Contacto removeContactos2(Contacto contactos2) {
			getContactos2().remove(contactos2);
			contactos2.setPerfil2(null);

			return contactos2;
		}

		public List<Descarte> getDescartes1() {
			return this.descartes1;
		}

		public void setDescartes1(List<Descarte> descartes1) {
			this.descartes1 = descartes1;
		}

		public Descarte addDescartes1(Descarte descartes1) {
			getDescartes1().add(descartes1);
			descartes1.setPerfil1(this);

			return descartes1;
		}

		public Descarte removeDescartes1(Descarte descartes1) {
			getDescartes1().remove(descartes1);
			descartes1.setPerfil1(null);

			return descartes1;
		}

		public List<Descarte> getDescartes2() {
			return this.descartes2;
		}

		public void setDescartes2(List<Descarte> descartes2) {
			this.descartes2 = descartes2;
		}

		public Descarte addDescartes2(Descarte descartes2) {
			getDescartes2().add(descartes2);
			descartes2.setPerfil2(this);

			return descartes2;
		}

		public Descarte removeDescartes2(Descarte descartes2) {
			getDescartes2().remove(descartes2);
			descartes2.setPerfil2(null);

			return descartes2;
		}

	}