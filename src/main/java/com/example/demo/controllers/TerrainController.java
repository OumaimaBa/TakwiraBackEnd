package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Terrain;
import com.example.demo.services.TerrainService;

@CrossOrigin("*")
@RequestMapping("terrains")
@RestController
public class TerrainController {
	
	@Autowired
	public TerrainService terrainService;
	
	@GetMapping
	public List<Terrain> getAllTerrains(){
		return terrainService.getAllTerrains();
	}
	
	@PostMapping("/add")
	public boolean addTerrain(@RequestBody Terrain t) {
		if (terrainService.addTerrain(t) != null) {
			return true;
		}else return false;
	}
	
	@GetMapping("/{id}")
	public Optional<Terrain> getTerrainById(@PathVariable("id") String id) {
		return terrainService.getTerrainById(id);
	}
	
	@GetMapping("/login")
	public String login(@RequestParam String idTerrain, @RequestParam String mdp) {
		return terrainService.login(idTerrain, mdp);
	}

}