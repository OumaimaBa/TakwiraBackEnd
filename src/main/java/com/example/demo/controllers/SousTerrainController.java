package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.SousTerrain;
import com.example.demo.repositories.SousTerrainRepository;
import com.example.demo.services.SousTerrainService;

@CrossOrigin("*")
@RequestMapping("SousTerrains")
@RestController
public class SousTerrainController {
	
	@Autowired
	public SousTerrainService sousterrainService;
	@Autowired
    private SousTerrainRepository sousTerrainRepository;
	
	@GetMapping
	public List<SousTerrain> getAllSousTerrains(){
		return sousterrainService.getAllSousTerrains();
	}
	
	@PostMapping("/add")
	public SousTerrain addSousTerrain(@RequestBody SousTerrain st) {
		return sousterrainService.addSousTerrain(st);
	}
	
	@GetMapping("/{idTerrain}")
    public List<String> getSousTerrains(@PathVariable String idTerrain) {
		List<SousTerrain> sousTerrains = sousTerrainRepository.findByIdST_Terrain_IdTerrain(idTerrain);
	    List<String> soust = new ArrayList<>();

	    for (SousTerrain st : sousTerrains) {
	        soust.add(st.toString());
	    }

	    return soust;    
	}

}