package com.lucatinder.g3.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the perfil database table.
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

	private String genero;

	private String img;

	private String nombre;

	private String password;

	private String preferencias;

	//bi-directional many-to-one association to Contacto
	
	@OneToMany(mappedBy="perfil1")
	@JsonManagedReference
	private List<Contacto> contactos1;

	//bi-directional many-to-one association to Contacto
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

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="perfil1")
	@JsonManagedReference
	private List<Match> matches1;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="perfil2")
	@JsonManagedReference
	private List<Match> matches2;

	public Perfil() {
	}

	public int getId() {
		return this.id;
	}

	public void setIdPerfil(int id) {
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

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public String getPreferencias() {
		return this.preferencias;
	}

	public void setPreferencias(String preferencias) {
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

	public List<Match> getMatches1() {
		return this.matches1;
	}

	public void setMatches1(List<Match> matches1) {
		this.matches1 = matches1;
	}

	public Match addMatches1(Match matches1) {
		getMatches1().add(matches1);
		matches1.setPerfil1(this);

		return matches1;
	}

	public Match removeMatches1(Match matches1) {
		getMatches1().remove(matches1);
		matches1.setPerfil1(null);

		return matches1;
	}

	public List<Match> getMatches2() {
		return this.matches2;
	}

	public void setMatches2(List<Match> matches2) {
		this.matches2 = matches2;
	}

	public Match addMatches2(Match matches2) {
		getMatches2().add(matches2);
		matches2.setPerfil2(this);

		return matches2;
	}

	public Match removeMatches2(Match matches2) {
		getMatches2().remove(matches2);
		matches2.setPerfil2(null);

		return matches2;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", correo=" + correo + ", descripcion=" + descripcion + ", edad=" + edad
				+ ", genero=" + genero + ", img=" + img + ", nombre=" + nombre + ", password=" + password
				+ ", preferencias=" + preferencias + ", contactos1=" + contactos1 + ", contactos2=" + contactos2
				+ ", descartes1=" + descartes1 + ", descartes2=" + descartes2 + ", matches1=" + matches1 + ", matches2="
				+ matches2 + "]";
	}

	
}