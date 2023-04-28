package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tournoi {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTournoi;
	private int nbEquipes;
	private int nbPersEquipe;
	private Float prixEquipe; 
	private Date dateDebut;
	private Date dateFin;
	private String Prix;
	private String statut;
	
	@ManyToOne
	@JoinColumn(name = "idTerrain")
	private Terrain terrain;
	
	public int getNbEquipes() {
		return nbEquipes;
	}
	public void setNbEquipes(int nbEquipes) {
		this.nbEquipes = nbEquipes;
	}
	public int getNbPersEquipe() {
		return nbPersEquipe;
	}
	public void setNbPersEquipe(int nbPersEquipe) {
		this.nbPersEquipe = nbPersEquipe;
	}
	public Float getPrixEquipe() {
		return prixEquipe;
	}
	public void setPrixEquipe(Float prixEquipe) {
		this.prixEquipe = prixEquipe;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getPrix() {
		return Prix;
	}
	public void setPrix(String prix) {
		Prix = prix;
	}
	public Tournoi(Long idTournoi, int nbEquipes, int nbPersEquipe, Float prixEquipe, Date dateDebut, Date dateFin,
			String prix, Terrain terrain, String statut) {
		super();
		this.idTournoi = idTournoi;
		this.nbEquipes = nbEquipes;
		this.nbPersEquipe = nbPersEquipe;
		this.prixEquipe = prixEquipe;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.Prix = prix;
		this.statut=statut;
		this.terrain = terrain;
	}
	public Tournoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tournoi [idTournoi=" + idTournoi + ", nbEquipes=" + nbEquipes + ", nbPersEquipe=" + nbPersEquipe
				+ ", prixEquipe=" + prixEquipe + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", Prix=" + Prix
				+ ", terrain=" + terrain + "]";
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}

	
}
