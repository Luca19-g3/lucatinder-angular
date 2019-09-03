package com.lucatinder.g3.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Clase Contacto.
 * 
 * Clase para modelar los datos de los contactos.
 *
 * @version 1.0
 * @author Jorge con wizard EclipseLink
 * 
 * 27/08/2019
 * 
 */

	@Entity
	@NamedQuery(name="Contacto.findAll", query="SELECT c FROM Contacto c")
	public class Contacto implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name="id_contacto")
		
		private int idContacto;

		//bi-directional many-to-one association to Perfil
		//--likeADOR
		@ManyToOne
		@JoinColumn(name="id_perfil")
		@JsonBackReference
		private Perfil perfil1;

		//bi-directional many-to-one association to Perfil
		//--likeADO
		@ManyToOne
		@JoinColumn(name="id_like")
		@JsonBackReference
		private Perfil perfil2;

		public Contacto() {
		}

		public int getIdContacto() {
			return this.idContacto;
		}

		public void setIdContacto(int idContacto) {
			this.idContacto = idContacto;
		}

		public Perfil getPerfil1() {
			return this.perfil1;
		}

		public void setPerfil1(Perfil perfil1) {
			this.perfil1 = perfil1;
		}

		public Perfil getPerfil2() {
			return this.perfil2;
		}

		public void setPerfil2(Perfil perfil2) {
			this.perfil2 = perfil2;
		}

	}

