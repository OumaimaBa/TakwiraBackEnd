package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Terrain;

public interface TerrainService {

	public Optional<Terrain> getTerrainById(String id);
	public Terrain addTerrain(Terrain t);
	public List<Terrain> getAllTerrains();
	public String login(String idTerrain, String mdp);
}