package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.SousTerrain;
import com.example.demo.repositories.SousTerrainRepository;
import com.example.demo.services.SousTerrainService;

@Service
public class SousTerrainServiceImpl implements SousTerrainService {
	
	@Autowired
	private SousTerrainRepository sousterrainRepo;
	
	@Override
	public SousTerrain addSousTerrain(SousTerrain st) {
		// TODO Auto-generated method stub
		return sousterrainRepo.save(st);
	}

	@Override
	public List<SousTerrain> getAllSousTerrains() {
		// TODO Auto-generated method stub
		return sousterrainRepo.findAll();
	}

	@Override
	public List<SousTerrain> getByTerrain(String idTerrain) {
		return sousterrainRepo.findByIdST_Terrain_IdTerrain(idTerrain);
	}
}