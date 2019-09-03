package com.lucatinder.g3.modelo;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the descarte database table.
 * 
 */
@Entity
@NamedQuery(name="Descarte.findAll", query="SELECT d FROM Descarte d")
public class Descarte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_descarte")
	private int idDescarte;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil1")
	@JsonBackReference
	private Perfil perfil1;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil2")
	@JsonBackReference
	private Perfil perfil2;

	public Descarte() {
	}

	public int getIdDescarte() {
		return this.idDescarte;
	}

	public void setIdDescarte(int idDescarte) {
		this.idDescarte = idDescarte;
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
