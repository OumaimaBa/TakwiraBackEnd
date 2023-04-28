package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Terrain {
	@Id
    private String idTerrain;
    private String mdp;
    private String nom;
    private String adresse;
    private String description;
    private String region;
    private String tel;
    private int duree;
    private float prix;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "idTerrain", referencedColumnName = "idTerrain")
    private List<SousTerrain> sousTerrains;*/

	public String getIdTerrain() {
		return idTerrain;
	}

	public void setIdTerrain(String idTerrain) {
		this.idTerrain = idTerrain;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	/*public List<SousTerrain> getSousTerrains() {
		return sousTerrains;
	}

	public void setSousTerrains(List<SousTerrain> sousTerrains) {
		this.sousTerrains = sousTerrains;
	}*/

	@Override
	public String toString() {
		return "Terrain [idTerrain=" + idTerrain + " , mdp=" + mdp + ", nom=" + nom + ", adresse="
				+ adresse + ", description=" + description + ", region=" + region + ", tel=" + tel + ", duree=" + duree
				+ ", prix=" + prix + "]";
	}

	public Terrain(String idTerrain, String mdp, String nom, String adresse, String description,
			String region, String tel, int duree, float prix /*List<SousTerrain> sousTerrains*/) {
		super();
		this.idTerrain = idTerrain;
		this.mdp = mdp;
		this.nom = nom;
		this.adresse = adresse;
		this.description = description;
		this.region = region;
		this.tel = tel;
		this.duree = duree;
		this.prix = prix;
		//this.sousTerrains = sousTerrains;
	}

	public Terrain() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + duree;
		result = prime * result + ((idTerrain == null) ? 0 : idTerrain.hashCode());
		result = prime * result + ((mdp == null) ? 0 : mdp.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + Float.floatToIntBits(prix);
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		//result = prime * result + ((sousTerrains == null) ? 0 : sousTerrains.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		Terrain other = (Terrain) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duree != other.duree)
			return false;
		if (idTerrain == null) {
			if (other.idTerrain != null)
				return false;
		} else if (!idTerrain.equals(other.idTerrain))
			return false;
		if (mdp == null) {
			if (other.mdp != null)
				return false;
		} else if (!mdp.equals(other.mdp))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Float.floatToIntBits(prix) != Float.floatToIntBits(other.prix))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		/*if (sousTerrains == null) {
			if (other.sousTerrains != null)
				return false;
		} else if (!sousTerrains.equals(other.sousTerrains))
			return false;*/
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

   
	/*public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}*/
	
    
}