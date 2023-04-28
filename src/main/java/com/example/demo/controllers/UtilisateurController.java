package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Utilisateur;
import com.example.demo.services.UtilisateurService;

@CrossOrigin("*")
@RequestMapping("utilisateurs")
@RestController
public class UtilisateurController {

	@Autowired
	public UtilisateurService utilisateurService;
	
	@GetMapping
	public List<Utilisateur> getAllUtilisateurs(){
		return utilisateurService.getAllUtilisateurs();
	}
	
	@PostMapping("/add")
	public Boolean addUtilisateur(@RequestParam("username") String username, @RequestParam("nom") String nom,@RequestParam("prenom") String prenom,@RequestParam("mdp") String mdp,@RequestParam("age") int age,@RequestParam("adresse") String adresse,@RequestParam("post") String post,@RequestParam("tel") String tel,@RequestParam("genre") String genre, @RequestParam("image") MultipartFile image) throws IOException {
		Utilisateur user = new Utilisateur();
	    user.setUsername(username);
	    user.setNom(nom);
	    user.setPrenom(prenom);
	    user.setMdp(mdp);
	    user.setAdresse(adresse);
	    user.setAge(age);
	    user.setTel(tel);
	    user.setGenre(genre);
	    user.setPost(post);
	    user.setImage(image.getBytes());
	    return utilisateurService.addUtilisateur(user);
	}

	
	@GetMapping("/{id}")
	public Utilisateur getUtilisateurById(@PathVariable("username") String username) {
		return utilisateurService.getUtilisateurById(username);
	}
	
	@GetMapping("/login")
	public String get(@RequestParam String username, @RequestParam String mdp) {
		return utilisateurService.login(username, mdp);
	}
	@GetMapping("/getName")
	public String getNameUser(@RequestParam String username) {
		return utilisateurService.getNameUser(username);
	}}
