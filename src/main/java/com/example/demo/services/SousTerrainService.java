package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.SousTerrain;

public interface SousTerrainService {

	public SousTerrain addSousTerrain(SousTerrain st);
	public List<SousTerrain> getAllSousTerrains();
	public List<SousTerrain> getByTerrain(String idTerrain);
}