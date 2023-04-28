package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Utilisateur;

public interface UtilisateurService {

	public Utilisateur getUtilisateurById(String username);
	public Boolean addUtilisateur(Utilisateur user);
	public List<Utilisateur> getAllUtilisateurs();
	public String login(String username, String mdp);
	public String getNameUser(String username);
}
