package com.lucatinder.g3.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the matches database table.
 * 
 */
@Entity
@Table(name="matches")
@NamedQuery(name="Match.findAll", query="SELECT m FROM Match m")
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_match")
	private int idMatch;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil1")
	private Perfil perfil1;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil2")
	private Perfil perfil2;

	public Match() {
	}

	public int getIdMatch() {
		return this.idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
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