package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>{

	Optional<Utilisateur> findFirstByUsername(String username);
	Optional<Utilisateur> findFirstByUsernameAndMdp(String username, String mdp);
	
}
