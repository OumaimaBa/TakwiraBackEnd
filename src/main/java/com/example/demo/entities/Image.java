package com.example.demo.entities;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Image {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImage;
	@Lob
	private byte[] bin;
	@ManyToOne
	@JoinColumn(name = "idTerrain")
	private Terrain terrain;
	
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
	@Override
	public String toString() {
		return "Image [idImage=" + idImage + ", bin=" + Arrays.toString(bin) + ", terrain=" + terrain + "]";
	}
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Image(Long idImage, byte[] bin, Terrain terrain) {
		super();
		this.idImage = idImage;
		this.bin = bin;
		this.terrain = terrain;
	}
	public Long getId() {
		return idImage;
	}
	public void setId(Long idImage) {
		this.idImage = idImage;
	}
	
	public byte[] getBin() {
		return bin;
	}
	public void setBin(byte[] bin) {
		this.bin = bin;
	}

}
