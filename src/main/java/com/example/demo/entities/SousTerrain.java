package com.example.demo.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class SousTerrain {
	
	@EmbeddedId
	private SousTerrainId idST;
	
	private Double hauteur;
	private Double largeur;
	
	
	public SousTerrainId getIdST() {
		return idST;
	}
	public void setIdST(SousTerrainId idST) {
		this.idST = idST;
	}

	public Double getLargeur() {
		return largeur;
	}
	public void setLargeur(Double largeur) {
		this.largeur = largeur;
	}
	
	public Double getHauteur() {
		return hauteur;
	}
	public void setHauteur(Double hauteur) {
		this.hauteur = hauteur;
	}
	public SousTerrain(SousTerrainId idST, Double hauteur, Double largeur) {
		super();
		this.idST = idST;
		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	public SousTerrain() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return ""+ idST.getNom() + " "+hauteur + "m / "+ largeur + "m";
	}
	
	
}