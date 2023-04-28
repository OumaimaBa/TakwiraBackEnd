package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Embeddable
public class SousTerrainId implements Serializable{
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    
	private String nom;
	
	@ManyToOne
	@JoinColumn(name = "idTerrain",insertable = false, updatable = false)
	private Terrain terrain;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	public SousTerrainId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SousTerrainId(String nom, Terrain terrain) {
		super();
		this.nom = nom;
		this.terrain = terrain;
	}
	@Override
	public String toString() {
		return "SousTerrainId [nom=" + nom + ", terrain=" + terrain + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((terrain == null) ? 0 : terrain.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SousTerrainId other = (SousTerrainId) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (terrain == null) {
			if (other.terrain != null)
				return false;
		} else if (!terrain.equals(other.terrain))
			return false;
		return true;
	}
	
	
}