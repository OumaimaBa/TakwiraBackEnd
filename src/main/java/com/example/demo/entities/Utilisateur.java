package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Utilisateur {

	@Id
	private String username;
	private String mdp;
	private String nom;
	private String prenom;
	private String adresse;
	private int age;
	private String genre;
	@Lob
	private byte[] image;
	private String tel;
	private String post;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	public Utilisateur(String username, String mdp, String nom, String prenom, String adresse, int age,
			String genre, byte[] image, String tel, String post) {
		super();
		this.username = username;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.age = age;
		this.genre = genre;
		this.image = image;
		this.tel = tel;
		this.post = post;
	}
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Utilisateur [username=" + username + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", age=" + age + ", genre=" + genre + ", image=" + image + ", tel="
				+ tel + ", post=" + post + "]";
	}
	
	
}
